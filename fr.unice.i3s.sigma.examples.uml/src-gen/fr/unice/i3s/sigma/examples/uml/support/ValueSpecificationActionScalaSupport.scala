package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.ValueSpecificationAction;

trait ValueSpecificationActionScalaSupport {
  implicit class ValueSpecificationActionScalaSupport(that: ValueSpecificationAction) {
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
    def value: ValueSpecification = that.getValue
    def value_=(value: ValueSpecification): Unit = that.setValue(value)
  }
}

object ValueSpecificationActionScalaSupport extends ValueSpecificationActionScalaSupport
