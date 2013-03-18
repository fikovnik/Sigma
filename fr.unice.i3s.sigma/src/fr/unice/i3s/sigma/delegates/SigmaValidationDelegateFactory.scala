package fr.unice.i3s.sigma.delegates

import scala.collection.JavaConversions._
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EValidator.ValidationDelegate
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EOperation
import java.util.{ Map ⇒ JMap }
import org.eclipse.emf.ecore.scala.EcorePackageScalaSupport
import org.eclipse.emf.ecore.util.EcoreUtil
import java.lang.reflect.Method
import fr.unice.i3s.sigma.validation.Error
import org.eclipse.emf.ecore.util.EObjectValidator
import fr.unice.i3s.sigma.validation.ValidationResult

final class SigmaValidationDelegateFactory extends AbstractSigmaDelegateFactory[(EClass, String)] with ValidationDelegate with EcorePackageScalaSupport {

  protected val delegates = collection.mutable.Map[String, SigmaValidationDelegate]()

  protected def getDelegate(clazz: EClass, constraint: String) = {
    val id = clazz.instanceClass.getCanonicalName + "#" + constraint
    delegates.synchronized {
      delegates.get(id) match {
        case Some(delegate) ⇒ delegate
        case None ⇒ {
          Option(createValidationDelegate(clazz, constraint)) match {
            case Some(delegate) ⇒
              delegates += (id -> delegate)
              delegate
            case None ⇒
              throw new SigmaDelegateNotFoundException(
                s"No Sigma delegate registered for constraint `$constraint` in `${clazz.name}`")
          }
        }
      }
    }
  }

  protected def createValidationDelegate(clazz: EClass, constraint: String) = {
    if (isDelegated(clazz, constraint)) doCreateDelegate(clazz, constraint)
    else null
  }

  protected def doCreateDelegate(clazz: EClass, constraint: String) = {
    lookupDelegate((clazz, constraint), clazz, Option(EcoreUtil.getAnnotation(clazz, domain.getURI, constraint))) match {
      case Right(delegateMethod) ⇒
        new SigmaValidationDelegate(clazz, constraint, delegateMethod, domain)
      case Left(msg) ⇒
        throw new SigmaDelegateNotFoundException(s"Unable to find invocation delegate for ${clazz.getName}#$constraint: $msg")
    }
  }

  // TODO: implement
  protected def isDelegated(clazz: EClass, constraint: String) = true

  protected def doValidate(clazz: EClass, target: EObject, context: JMap[Object, Object], constraint: String): ValidationResult =
    try {
      val delegate = getDelegate(clazz, constraint)
      delegate.validate(target)
    } catch {
      case e: SigmaDelegateNotFoundException ⇒
        Error(s"No Sigma delegate has been found for constraint `$constraint` for `$target`")
      case e: Throwable ⇒
        Error(s"Error in executing Sigma validation delegate for constraint `$constraint` for `$target`: ${e.getMessage}")
    }

  override def delegateMethodName(element: (EClass, String)): String = "validate" + element._2

  override def checkMethodSignature(element: (EClass, String), method: Method): Boolean = {
    // must have a compatible return type
    if (!method.getReturnType.isAssignableFrom(classOf[Boolean])) false

    val mparams = method.getGenericParameterTypes

    // must have the first argument of type of the operation container
    if (!(mparams.length == 1 &&
      domain.compatibleType(element._1, mparams(0)))) false

    true
  }

  override def methodSignature(element: (EClass, String)): String = {
    val selfType = domain.classifierTypeName(element._1)
    val name = delegateMethodName(element)
    val typeParams = domain.classifierTypeParameters(element._1)

    s"def $name$typeParams(self: $selfType): Boolean"
  }

  override def validate(eClass: EClass, eObject: EObject,
    context: JMap[Object, Object], invariant: EOperation, expression: String) =
    doValidate(eClass, eObject, context, invariant.getName()).isValidOrCanceled;

  override def validate(eClass: EClass, eObject: EObject,
    context: JMap[Object, Object], constraint: String, expression: String) =
    doValidate(eClass, eObject, context, constraint)
      .isValidOrCanceled

  override def validate(eDataType: EDataType, value: Object,
    context: JMap[Object, Object], constraint: String, expression: String) =
    // TODO: better exception
    throw new RuntimeException;

}