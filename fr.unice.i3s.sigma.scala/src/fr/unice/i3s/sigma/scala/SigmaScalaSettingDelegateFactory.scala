package fr.unice.i3s.sigma.scala

import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate.Factory
import fr.unice.i3s.sigma.delegates.SigmaSettingDelegateFactory

final class SigmaScalaSettingDelegateFactory extends SigmaSettingDelegateFactory {

  override def getDomain = SigmaScalaDelegateDomain.instance

  override def doCreateSettingDelegate(target: EStructuralFeature) =
    new SigmaScalaSettingDelegate(target, getDomain)

}