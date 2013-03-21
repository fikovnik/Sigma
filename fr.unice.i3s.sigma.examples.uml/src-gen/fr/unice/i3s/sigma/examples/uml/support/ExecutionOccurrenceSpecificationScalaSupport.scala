package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;

trait ExecutionOccurrenceSpecificationScalaSupport {
  implicit class ExecutionOccurrenceSpecificationScalaSupport(that: ExecutionOccurrenceSpecification) {
    def execution: ExecutionSpecification = that.getExecution
    def execution_=(value: ExecutionSpecification): Unit = that.setExecution(value)
  }
}

object ExecutionOccurrenceSpecificationScalaSupport extends ExecutionOccurrenceSpecificationScalaSupport
