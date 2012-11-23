package fr.unice.i3s.sigma.scala

import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate.Factory
import fr.unice.i3s.sigma.delegates.SigmaSettingDelegateFactory
import fr.unice.i3s.sigma.scala.SigmaScalaDelegateDomain.{ instance => domain }

final class SigmaScalaSettingDelegateFactory extends SigmaSettingDelegateFactory(domain) {

  override def getExpectedMethodSignature(target: EStructuralFeature): String = {
    val selfType = domain.classifierTypeName(target.getEContainingClass())
    val name = getExpectedMethodName(target)
    val typeParams = domain.classifierTypeParameters(target.getEContainingClass())
    val returnType = domain.elementTypeName(target)

    s"def $name$typeParams(self: $selfType): $returnType"
  }

}