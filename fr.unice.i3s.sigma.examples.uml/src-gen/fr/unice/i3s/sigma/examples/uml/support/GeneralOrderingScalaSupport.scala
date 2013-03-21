package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.OccurrenceSpecification;

trait GeneralOrderingScalaSupport {
  implicit class GeneralOrderingScalaSupport(that: GeneralOrdering) {
    def after: OccurrenceSpecification = that.getAfter
    def after_=(value: OccurrenceSpecification): Unit = that.setAfter(value)
    def before: OccurrenceSpecification = that.getBefore
    def before_=(value: OccurrenceSpecification): Unit = that.setBefore(value)
  }
}

object GeneralOrderingScalaSupport extends GeneralOrderingScalaSupport
