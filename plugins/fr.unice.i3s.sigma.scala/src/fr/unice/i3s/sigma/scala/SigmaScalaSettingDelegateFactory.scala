package fr.unice.i3s.sigma.scala

import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate.Factory

final class SigmaScalaSettingDelegateFactory extends Factory {

  override def createSettingDelegate(eStructuralFeature: EStructuralFeature) = {
    new SigmaScalaSettingDelegate(eStructuralFeature, SigmaScalaDelegateDomain.instance)
  }

}