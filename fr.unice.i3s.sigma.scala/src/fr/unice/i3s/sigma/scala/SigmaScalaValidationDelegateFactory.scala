package fr.unice.i3s.sigma.scala

import org.eclipse.emf.ecore.EClass

import fr.unice.i3s.sigma.delegates.SigmaValidationDelegateFactory

final class SigmaScalaValidationDelegateFactory extends SigmaValidationDelegateFactory {

  override def getDomain = SigmaScalaDelegateDomain.instance

  override def doCreateValidationDelegate(target: EClass, constraint: String) =
    new SigmaScalaValiationDelegate(target, getDomain, constraint)

}