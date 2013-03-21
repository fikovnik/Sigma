package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.DurationInterval;

trait DurationIntervalScalaSupport {
  implicit class DurationIntervalScalaSupport(that: DurationInterval) {
    
  }
}

object DurationIntervalScalaSupport extends DurationIntervalScalaSupport
