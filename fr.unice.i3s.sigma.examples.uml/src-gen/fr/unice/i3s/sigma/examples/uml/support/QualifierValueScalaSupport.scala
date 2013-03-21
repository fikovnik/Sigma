package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.QualifierValue;

trait QualifierValueScalaSupport {
  implicit class QualifierValueScalaSupport(that: QualifierValue) {
    def qualifier: Property = that.getQualifier
    def qualifier_=(value: Property): Unit = that.setQualifier(value)
    def value: InputPin = that.getValue
    def value_=(value: InputPin): Unit = that.setValue(value)
  }
}

object QualifierValueScalaSupport extends QualifierValueScalaSupport
