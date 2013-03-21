package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.ValuePin;
import org.eclipse.uml2.uml.ValueSpecification;

trait ValuePinScalaSupport {
  implicit class ValuePinScalaSupport(that: ValuePin) {
    def value: ValueSpecification = that.getValue
    def value_=(value: ValueSpecification): Unit = that.setValue(value)
  }
}

object ValuePinScalaSupport extends ValuePinScalaSupport
