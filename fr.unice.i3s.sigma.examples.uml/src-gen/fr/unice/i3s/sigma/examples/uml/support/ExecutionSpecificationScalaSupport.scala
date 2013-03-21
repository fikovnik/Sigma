package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.OccurrenceSpecification;

trait ExecutionSpecificationScalaSupport {
  implicit class ExecutionSpecificationScalaSupport(that: ExecutionSpecification) {
    def finish: OccurrenceSpecification = that.getFinish
    def finish_=(value: OccurrenceSpecification): Unit = that.setFinish(value)
    def start: OccurrenceSpecification = that.getStart
    def start_=(value: OccurrenceSpecification): Unit = that.setStart(value)
  }
}

object ExecutionSpecificationScalaSupport extends ExecutionSpecificationScalaSupport
