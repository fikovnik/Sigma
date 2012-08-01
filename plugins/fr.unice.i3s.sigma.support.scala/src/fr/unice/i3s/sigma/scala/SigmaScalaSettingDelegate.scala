package fr.unice.i3s.sigma.scala

import org.eclipse.emf.ecore.EStructuralFeature

import fr.unice.i3s.sigma.core.SigmaSettingDelegate

final class SigmaScalaSettingDelegate(eStructuralFeature : EStructuralFeature, 
    domain : SigmaScalaDelegateDomain) extends SigmaSettingDelegate(eStructuralFeature, domain) {

  override def getExpectedMethodSignature() = {
    "def %s%s(self : %s) : %s" format (
        getDelegateMethodName,
        domain.classifierTypeParameters(target.getEContainingClass()),
        domain.classifierTypeName(target.getEContainingClass()), 
        domain.elementTypeName(target))
  }
  
}