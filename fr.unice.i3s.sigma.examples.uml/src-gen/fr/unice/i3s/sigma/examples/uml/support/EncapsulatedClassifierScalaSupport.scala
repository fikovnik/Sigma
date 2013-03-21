package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Port;

trait EncapsulatedClassifierScalaSupport {
  implicit class EncapsulatedClassifierScalaSupport(that: EncapsulatedClassifier) {
    def ownedPort: EList[Port] = that.getOwnedPorts
  }
}

object EncapsulatedClassifierScalaSupport extends EncapsulatedClassifierScalaSupport
