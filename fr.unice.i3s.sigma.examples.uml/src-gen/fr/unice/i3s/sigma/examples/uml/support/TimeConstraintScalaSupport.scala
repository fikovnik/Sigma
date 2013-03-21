package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.TimeConstraint;

trait TimeConstraintScalaSupport {
  implicit class TimeConstraintScalaSupport(that: TimeConstraint) {
    def firstEvent: Boolean = that.isFirstEvent
    def firstEvent_=(value: Boolean): Unit = that.setFirstEvent(value)
  }
}

object TimeConstraintScalaSupport extends TimeConstraintScalaSupport
