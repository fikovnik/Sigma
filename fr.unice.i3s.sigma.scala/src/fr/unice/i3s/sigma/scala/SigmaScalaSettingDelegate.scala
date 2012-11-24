package fr.unice.i3s.sigma.scala

import org.eclipse.emf.ecore.EStructuralFeature

import fr.unice.i3s.sigma.delegates.SigmaSettingDelegate

final class SigmaScalaSettingDelegate(eStructuralFeature: EStructuralFeature,
  domain: SigmaScalaDelegateDomain) extends SigmaSettingDelegate(eStructuralFeature, domain) {

  override def getMethodSignature: String = {
    val selfType = domain.classifierTypeName(target.getEContainingClass())
    val name = getMethodName
    val typeParams = domain.classifierTypeParameters(target.getEContainingClass())
    val returnType = domain.elementTypeName(target)

    s"def $name$typeParams(self: $selfType): $returnType"
  }

}