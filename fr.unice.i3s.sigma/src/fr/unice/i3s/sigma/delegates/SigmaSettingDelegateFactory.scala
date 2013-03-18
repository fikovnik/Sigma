package fr.unice.i3s.sigma.delegates

import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate.Factory
import java.lang.reflect.Method
import org.eclipse.emf.ecore.scala.EcorePackageScalaSupport

final class SigmaSettingDelegateFactory extends AbstractSigmaDelegateFactory[EStructuralFeature] with Factory with EcorePackageScalaSupport {
  import EcorePackageScalaSupport._

  override def createSettingDelegate(feature: EStructuralFeature) = {
    // we do not need to cache the results - it will called only once per delegate
    if (isDelegated(feature)) doCreateDelegate(feature)
    else null
  }

  // TODO: implement
  protected def isDelegated(feature: EStructuralFeature) = true

  def doCreateDelegate(feature: EStructuralFeature) = {
    lookupDelegate(feature, feature.eContainingClass, delegateOverride(feature)) match {
      case Right(delegateMethod) ⇒
        new SigmaSettingDelegate(feature, delegateMethod, domain)
      case Left(msg) ⇒
        throw new SigmaDelegateNotFoundException(s"Unable to find setting delegate for ${feature.getName}: $msg")
    }
  }

  override def delegateMethodName(feature: EStructuralFeature) = feature.eType match {
    case EBoolean | EBooleanObject ⇒ "is" + feature.name
    case _ ⇒ "get" + feature.name
  }

  override def checkMethodSignature(operation: EStructuralFeature, method: Method) = {
    // must have a compatible return type
    if (!domain.compatibleType(operation, method.getGenericReturnType)) false

    val mparams = method.getGenericParameterTypes

    // must have the first argument of type of the operation container
    if (!(mparams.length >= 1 &&
      domain.compatibleType(operation.eContainingClass, mparams(0)))) false

    // TODO: check exceptions

    true
  }

  override def methodSignature(feature: EStructuralFeature): String = {
    val selfType = domain.classifierTypeName(feature.eContainingClass)
    val name = delegateMethodName(feature)
    val typeParams = domain.classifierTypeParameters(feature.eContainingClass)
    val returnType = domain.elementTypeName(feature)

    // TODO: exceptions
    s"def $name$typeParams(self: $selfType): $returnType"
  }

}