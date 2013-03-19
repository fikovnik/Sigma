package fr.unice.i3s.sigma.delegates

import scala.collection.JavaConversions._
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate.Factory
import java.lang.reflect.Method
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.EClass
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import org.eclipse.emf.ecore.EPackage
import java.text.ParseException

final class SigmaInvocationDelegateFactory extends AbstractSigmaDelegateFactory[EOperation] with Factory {

  override def createInvocationDelegate(operation: EOperation) = {
    // we do not need to cache the results - it will called only once per delegate
    if (isDelegated(operation)) doCreateDelegate(operation)
    else null
  }

  // TODO: implement
  protected def isDelegated(operation: EOperation) = true

  protected def doCreateDelegate(operation: EOperation) = {
    lookupDelegate(operation, operation.eContainingClass, delegateOverride(operation)) match {
      case Right(delegateMethod) ⇒
        new SigmaInvocationDelegate(operation, delegateMethod, domain)
      case Left(msg) ⇒
        throw new SigmaDelegateNotFoundException(s"Unable to find invocation delegate for ${operation.getName}: $msg")
    }
  }

  override def delegateMethodName(operation: EOperation): String = "invoke" + operation.name

  override def checkMethodSignature(operation: EOperation, method: Method): Boolean = {
    // must have a compatible return type
    if (!domain.compatibleType(operation, method.getGenericReturnType)) false

    val mparams = method.getGenericParameterTypes

    // must have the first argument of type of the operation container
    if (!(mparams.length >= 1 &&
      domain.compatibleType(operation.eContainingClass, mparams(0)))) false

    val eparams = operation.eParameters

    // must have compatible parameter types
    if (!((mparams.drop(1) zip eparams) forall {
      case (mp, ep) ⇒ domain.compatibleType(ep, mp)
    })) false

    // must have compatible exceptions
    // TODO: implement

    true
  }

  override def methodSignature(operation: EOperation): String = {
    val selfType = domain.classifierTypeName(operation.eContainingClass)
    val name = delegateMethodName(operation)
    val typeParams = domain.classifierTypeParameters(operation.eContainingClass)
    val returnType = domain.elementTypeName(operation)

    val argNames = "self" +=: (operation.eParameters map (_.getName))
    val argTypes = selfType +=: (operation.eParameters map (domain.elementTypeName(_)))
    val args = (argNames zip argTypes) map {
      case (name, typeName) ⇒ s"$name: $typeName"
    }

    // TODO: implement exception

    s"def $name${typeParams}(${args.mkString(", ")}): $returnType"
  }

}