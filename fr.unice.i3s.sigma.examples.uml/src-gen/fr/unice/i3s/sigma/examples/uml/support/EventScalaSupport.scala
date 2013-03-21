package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Event;

trait EventScalaSupport {
  implicit class EventScalaSupport(that: Event) {
    
  }
}

object EventScalaSupport extends EventScalaSupport
