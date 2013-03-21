package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;

trait EnumerationLiteralScalaSupport {
  implicit class EnumerationLiteralScalaSupport(that: EnumerationLiteral) {
    def enumeration: Enumeration = that.getEnumeration
    def enumeration_=(value: Enumeration): Unit = that.setEnumeration(value)
  }
}

object EnumerationLiteralScalaSupport extends EnumerationLiteralScalaSupport
