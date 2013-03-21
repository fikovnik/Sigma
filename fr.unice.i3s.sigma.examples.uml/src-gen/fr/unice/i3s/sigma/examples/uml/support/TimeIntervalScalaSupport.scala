package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.TimeInterval;

trait TimeIntervalScalaSupport {
  implicit class TimeIntervalScalaSupport(that: TimeInterval) {
    
  }
}

object TimeIntervalScalaSupport extends TimeIntervalScalaSupport
