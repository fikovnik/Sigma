package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Trigger;

trait TriggerScalaSupport {
  implicit class TriggerScalaSupport(that: Trigger) {
    def event: Event = that.getEvent
    def event_=(value: Event): Unit = that.setEvent(value)
    def port: EList[Port] = that.getPorts
  }
}

object TriggerScalaSupport extends TriggerScalaSupport
