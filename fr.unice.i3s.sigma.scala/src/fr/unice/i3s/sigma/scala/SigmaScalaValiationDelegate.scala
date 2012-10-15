package fr.unice.i3s.sigma.scala

import org.eclipse.emf.ecore.EClassifier

import fr.unice.i3s.sigma.delegates.SigmaValidationDelegate

final class SigmaScalaValiationDelegate(target: EClassifier, domain: SigmaScalaDelegateDomain,
  constraint: String) extends SigmaValidationDelegate(target, domain, constraint) {

  override def getExpectedMethodSignature() = {
    "def %s%s(self : %s) : Boolean" format (
      getDelegateMethodName,
      domain.classifierTypeParameters(target),
      domain.classifierTypeName(target))
  }

}