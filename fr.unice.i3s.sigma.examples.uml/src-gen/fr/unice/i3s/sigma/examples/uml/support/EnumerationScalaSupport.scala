package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;

trait EnumerationScalaSupport {
  implicit class EnumerationScalaSupport(that: Enumeration) {
    def ownedLiteral: EList[EnumerationLiteral] = that.getOwnedLiterals
  }
}

object EnumerationScalaSupport extends EnumerationScalaSupport
