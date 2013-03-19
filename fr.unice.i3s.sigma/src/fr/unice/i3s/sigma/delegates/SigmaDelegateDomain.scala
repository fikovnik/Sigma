package fr.unice.i3s.sigma.delegates

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import scala.collection.JavaConversions._
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EGenericType
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.EValidator
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import java.lang.reflect.Method
import scala.beans.BeanProperty
import fr.unice.i3s.sigma.support.EMFScalaSupport
import fr.unice.i3s.sigma.util.DelegatingEList
import scala.collection.Seq
import java.lang.reflect.InvocationTargetException
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import org.apache.commons.lang3.reflect.TypeUtils
import scala.collection.mutable.Buffer
import fr.unice.i3s.sigma.validation.ValidationResult
import fr.unice.i3s.sigma.validation.Passed
import fr.unice.i3s.sigma.validation.Error

final object SigmaDelegateDomain {

  private val SIGMA_DELEGATE_URI = "http://www.i3s.unice.fr/Sigma"
  private val DELEGATE_ANNOTATION_KEY = "delegate"
  private val DELEGATE_CLASS_SUFFIX = "Delegate"

  private val TYPE_MAPPING = Map("boolean" -> "Boolean")
  private val COLLECTION_TYPE = classOf[Buffer[_]]

  /**
   * Registers globally Java version of the Sigma delegates for the
   * {@link SigmaConstants#SIGMA_DELEGATE_URI} URI. This includes:
   * <ul>
   * <li>Invocation delegate {@link SigmaInvocationDelegate}
   * <li>Setting delegate {@link SettingDelegate}
   * <li>Validation delegate {@link ValidationDelegate}
   * </ul>
   *
   * In order to fully leverage the extended return type of the Sigma
   * validation delegate a {@link SigmaEObjectValidation} must be registered
   * as the package validator. Normally, this is not the case and it has to be
   * done explicitly by changing the generate {@code <PackageName>Validator}
   * super class to be {@link SigmaEObjectValidator}.
   */
  def installGlobally() {
    EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE +=
      (instance.getURI -> new SigmaInvocationDelegateFactory);

    EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE +=
      (instance.getURI -> new SigmaSettingDelegateFactory);

    EValidator.ValidationDelegate.Registry.INSTANCE +=
      (instance.getURI -> new SigmaValidationDelegateFactory);
  }

  val instance = new SigmaDelegateDomain

}

final class SigmaDelegateDomain extends EMFScalaSupport with EcorePackageScalaSupport {
  import SigmaDelegateDomain._

  def getURI: String = SIGMA_DELEGATE_URI

  def loadDelegateClass(className: String): Option[Class[_]] = {
    val clazz = try {
      Class.forName(className)
    } catch {
      case _: Throwable ⇒
        try {
          Class.forName(className + "$");
        } catch {
          case _: Throwable ⇒ null
        }
    }
    Option(clazz)
  }

  def delegateAnnotationKey: String = DELEGATE_ANNOTATION_KEY

  def classDelegateName(clazz: EClass) = clazz.name + DELEGATE_CLASS_SUFFIX

  def classifierName(c: EClassifier) = {
    c match {
      case t: EDataType ⇒ TYPE_MAPPING.get(t.getInstanceClassName).getOrElse(t.getInstanceClass.getSimpleName)
      case t: EClass ⇒ Option(c.getName).orElse(Option(c.getInstanceTypeName)).getOrElse("")
    }
  }

  def classifierTypeName(c: EClassifier) = {
    c.getName + (c.getETypeParameters match {
      case p if p.isEmpty ⇒ ""
      case p ⇒ p.map(_.getName).mkString("[", ",", "]")
    })
  }

  def classifierTypeParameters(c: EClassifier) = {
    c.getETypeParameters match {
      case p if p.isEmpty ⇒ ""
      case p ⇒ p.map(t ⇒
        t.getName + " <: " + t.getEBounds.map(genericType(_)).mkString("&")).mkString("[", ",", "]")
    }
  }

  def elementTypeName(c: ETypedElement) = {
    var typeName = genericType(c.getEGenericType)

    typeName = if (c.isMany) COLLECTION_TYPE.getSimpleName + "[" + typeName + "]" else typeName
    typeName = if (!c.isRequired && !c.isMany) "Option[" + typeName + "]" else typeName

    typeName
  }

  def genericType(c: EGenericType): String = {
    // taken from EGenericTypeImpl.toString(StringBuilder)

    val r = new StringBuilder
    if (c.getEClassifier != null) {
      r ++= classifierName(c.getEClassifier)

      if (!c.getETypeArguments.isEmpty()) {
        r ++= c.getETypeArguments.map(genericType(_)).mkString("[", ", ", "]")
      }

    } else if (c.getETypeParameter != null) {
      val name = Option(c.getETypeParameter.getName()).getOrElse("")
      r ++= name
    } else {
      r += '_'
      if (c.getELowerBound != null) {
        r ++= " >: "
        r ++= genericType(c.getELowerBound)
      } else {
        if (c.getEUpperBound != null) {
          r ++= " <: "
          r ++= genericType(c.getEUpperBound)
        }
      }
    }

    r.toString
  }

  def getCollectionType() = {
    COLLECTION_TYPE
  }

  def processResult(eType: ETypedElement, value: Any) = {
    value match {
      case o: Seq[_] ⇒ new DelegatingEList(o.toBuffer)
      case o: Option[_] ⇒ o.getOrElse(null)
      case _ ⇒ value
    }
  }

  def safeDynamicInvoke[T](delegateMethod: Method, target: Object)(block: ⇒ T): T = {
    try block
    catch {
      case e: IllegalArgumentException ⇒
        throw handleIllegalArgumentException(delegateMethod, target, e)
      case e: IllegalAccessException ⇒
        throw handleIllegalAccessException(delegateMethod, target, e)
      case e: InvocationTargetException ⇒
        throw handleInvocationTargetException(delegateMethod, target, e)
    }
  }

  protected def handleIllegalArgumentException(delegateMethod: Method, target: Object, e: IllegalArgumentException) = {
    // FIXME: add logging instead of this
    e.printStackTrace();

    // FIXME: if the problem is in implementation of the toString() method
    // this will keep failing
    new SigmaDelegateException(s"Unable to invoke delegate method: `$delegateMethod` on `$target`", e)
  }

  protected def handleIllegalAccessException(delegateMethod: Method, target: Object, e: IllegalAccessException) = {
    // FIXME: add logging instead of this
    e.printStackTrace();

    // FIXME: if the problem is in implementation of the toString() method
    // this will keep failing
    new SigmaDelegateException(s"Unable to invoke delegate method: `$delegateMethod` on `$target`", e)
  }

  protected def handleInvocationTargetException(delegateMethod: Method, target: Object, e: InvocationTargetException) = {
    // FIXME: add logging instead of this
    e.printStackTrace();

    // FIXME: if the problem is in implementation of the toString() method
    // this will keep failing
    new SigmaDelegateException(s"Unable to invoke delegate method: `$delegateMethod` on `$target`: ${e.getTargetException}", e.getTargetException)
  }

  def compatibleType(classifier: EClassifier, sType: Type): Boolean = {
    // FIXME: get rid of TypeUtils
    // FIXME: this only work for simple cases without bounds and arrays
    TypeUtils.isAssignable(sType, classifier.instanceClass)
  }

  def compatibleType(eType: ETypedElement, sType: Type): Boolean = {
    if (eType.required) {
      sType match {
        case c: ParameterizedType if classOf[Option[_]].isAssignableFrom(c.getRawType.asInstanceOf[Class[_]]) ⇒
          compatibleType(eType.getEType, c.getActualTypeArguments()(0))
        case _ ⇒ compatibleType(eType.eType, sType)
      }
    } else if (eType.many) {
      sType match {
        case pType: ParameterizedType ⇒
          getCollectionType.isAssignableFrom(pType.getRawType.asInstanceOf[Class[_]]) &&
            compatibleType(eType.eType, pType.getActualTypeArguments()(0))
        case _ ⇒ false
      }
    } else {
      compatibleType(eType.eType, sType)
    }
  }

  def toValidationResult(status: Any, target: EObject, delegate: SigmaValidationDelegate): ValidationResult =
    status match {
      case o: Boolean if o == true ⇒ Passed
      case o: Boolean if o == false ⇒ Error(s"The `${delegate.constraint}` constraint is violated on `$target`")
      case o: String if classOf[String].isAssignableFrom(delegate.delegateMethod.getReturnType) ⇒
        if (o == null) Passed
        else Error(o)
      case o: ValidationResult ⇒ o
      case _ ⇒ throw new RuntimeException(s"Unexpected return type from `$delegate` while validating `$target`")
    }

  //  private val invocationFactory = new JSigmaInvocationDelegateFactory
  //  def getInvocationDelegateFactory = invocationFactory;

  //  private val settingFactory = new SigmaScalaSettingDelegateFactory
  //  def getSettingDelegateFactory = settingFactory;
  //
  //  private val validationFactory = new SigmaScalaValidationDelegateFactory
  //  def getValidationDelegateFactory = validationFactory;

}
