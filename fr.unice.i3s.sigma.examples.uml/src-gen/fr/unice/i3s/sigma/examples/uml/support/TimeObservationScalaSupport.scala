package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.TimeObservation;

trait TimeObservationScalaSupport {
  implicit class TimeObservationScalaSupport(that: TimeObservation) {
    def event: NamedElement = that.getEvent
    def event_=(value: NamedElement): Unit = that.setEvent(value)
    def firstEvent: Boolean = that.isFirstEvent
    def firstEvent_=(value: Boolean): Unit = that.setFirstEvent(value)
  }
}

object TimeObservationScalaSupport extends TimeObservationScalaSupport
