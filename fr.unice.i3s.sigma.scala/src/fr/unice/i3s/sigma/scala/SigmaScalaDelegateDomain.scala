package fr.unice.i3s.sigma.scala

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
import fr.unice.i3s.sigma.delegates.SigmaDelegateDomain
import fr.unice.i3s.sigma.core.{ ValidationResult ⇒ JValidationResult }
import org.eclipse.emf.common.util.EList
import fr.unice.i3s.sigma.core.ISigmaQuickFix
import fr.unice.i3s.sigma.delegates.SigmaQuickFix
import org.eclipse.emf.ecore.EObject
import java.lang.reflect.Method
import fr.unice.i3s.sigma.delegates.ISigmaValidationDelegate
import scala.beans.BeanProperty
import fr.unice.i3s.sigma.scala.common.EMFScalaSupport

final object SigmaScalaDelegateDomain extends SigmaDelegateDomain {

  private val TYPE_MAPPING = Map("boolean" -> "Boolean")
  private val COLLECTION_TYPE = classOf[List[_]]

  def installGlobally() {
    EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE +=
      (getURI -> new SigmaScalaInvocationDelegateFactory);

    EStructuralFeature.Internal.SettingDelegate.Factory.Registry.INSTANCE +=
      (getURI -> new SigmaScalaSettingDelegateFactory);

    EValidator.ValidationDelegate.Registry.INSTANCE +=
      (getURI -> new SigmaScalaValidationDelegateFactory);
  }

  val instance = new SigmaScalaDelegateDomain

}

final class SigmaScalaDelegateDomain extends SigmaDelegateDomain with EMFScalaSupport {
  import SigmaScalaDelegateDomain._

  override def getURI = {
    super.getURI + "/Scala"
  }

  override def loadDelegateClass(className: String) = {
    var clazz = super.loadDelegateClass(className)

    if (clazz == null) {
      // support for scala objects
      try {
        clazz = Class.forName(className + "$");
      } catch { case _: Throwable => }
    }

    clazz
  }

  override def classifierName(c: EClassifier) = {
    c match {
      case t: EDataType => TYPE_MAPPING.get(t.getInstanceClassName).getOrElse(t.getInstanceClass.getSimpleName)
      case t: EClass => Option(c.getName).orElse(Option(c.getInstanceTypeName)).getOrElse("")
    }
  }

  override def classifierTypeName(c: EClassifier) = {
    c.getName + (c.getETypeParameters match {
      case p if p.isEmpty => ""
      case p => p.map(_.getName).mkString("[", ",", "]")
    })
  }

  def classifierTypeParameters(c: EClassifier) = {
    c.getETypeParameters match {
      case p if p.isEmpty => ""
      case p => p.map(t =>
        t.getName + " <: " + t.getEBounds.map(genericType(_)).mkString("&")).mkString("[", ",", "]")
    }
  }

  override def elementTypeName(c: ETypedElement) = {
    // FIXME: this can fail and then it might be eaten up by the stringtemplate
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

  override def getCollectionType() = {
    COLLECTION_TYPE
  }

  override def processResult(eType: ETypedElement, o: Object) = {
    super.processResult(eType, o match {
      case c: Option[_] => c.getOrElse(null)
      case c: List[_] => scalaListAsEList(c)
      case _ => o
    })
  }

  override def processArgument(eType: ETypedElement, o: Object) = {
    if (eType.isMany) {
      o match {
        case c: EList[_] => eListAsScalaImmutableList(c)
        case _ => o
      }
    } else {
      o
    }
  }

  override def checkElementType(eType: ETypedElement, sType: Type): Boolean = {
    if (!eType.isRequired) {
      sType match {
        case c: ParameterizedType if classOf[Option[_]].isAssignableFrom(c.getRawType.asInstanceOf[Class[_]]) =>
          checkClassifierType(eType.getEType, c.getActualTypeArguments()(0))
        case _ => super.checkElementType(eType, sType)
      }
    } else {
      super.checkElementType(eType, sType)
    }
  }

  override def toSigmaValidationResult(status: Any, delegate: ISigmaValidationDelegate, eObject: EObject): JValidationResult = {
    status match {
      //      case Option[String] => super.toSigmaValidationResult(s.get, delegate, constraint, `object`)
      case vr: ValidationResult => vr match {
        case _: OK => JValidationResult.ok()
        case Info(message) => JValidationResult.info(message)
        case Warning(message, quickFix) => JValidationResult.warning(message, new SigmaScalaQuickFix(quickFix))
        case Error(message) => JValidationResult.error(message)
        case _: Cancel => JValidationResult.cancel()
      }

      case _ => super.toSigmaValidationResult(status, delegate, eObject)
    }
  }

  private val invocationFactory = new SigmaScalaInvocationDelegateFactory
  override def getInvocationDelegateFactory = invocationFactory;

  private val settingFactory = new SigmaScalaSettingDelegateFactory
  override def getSettingDelegateFactory = settingFactory;

  private val validationFactory = new SigmaScalaValidationDelegateFactory
  override def getValidationDelegateFactory = validationFactory;

  // BeanProperty
  //  override def getValidationDelegateFactory: SigmaScalaValidationDelegateFactory = 

}
