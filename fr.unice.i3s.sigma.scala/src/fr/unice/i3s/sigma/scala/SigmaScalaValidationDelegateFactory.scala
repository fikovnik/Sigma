package fr.unice.i3s.sigma.scala

import org.eclipse.emf.ecore.EClassifier

import fr.unice.i3s.sigma.delegates.SigmaValidationDelegateFactory
import fr.unice.i3s.sigma.scala.SigmaScalaDelegateDomain.{ instance => domain }

final class SigmaScalaValidationDelegateFactory extends SigmaValidationDelegateFactory(domain) {

  override def getExpectedMethodSignature(target: EClassifier, constraint: String): String = {
    val selfType = domain.classifierTypeName(target)
    val name = getExpectedMethodName(constraint)
    val typeParams = domain.classifierTypeParameters(target)

    s"def $name$typeParams(self: $selfType): Boolean"
  }

}