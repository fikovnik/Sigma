package fr.unice.i3s.sigma.scala

import org.eclipse.emf.ecore.EClassifier

import fr.unice.i3s.sigma.core.SigmaValidationDelegateFactory

final class SigmaScalaValidationDelegateFactory extends SigmaValidationDelegateFactory {

  override def createDelegate(eClassifier: EClassifier, constrant: String) = {
    new SigmaScalaValiationDelegate(eClassifier, SigmaScalaDelegateDomain.instance, constrant)
  }

}