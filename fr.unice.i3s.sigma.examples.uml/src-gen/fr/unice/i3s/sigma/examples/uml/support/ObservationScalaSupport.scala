package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Observation;

trait ObservationScalaSupport {
  implicit class ObservationScalaSupport(that: Observation) {
    
  }
}

object ObservationScalaSupport extends ObservationScalaSupport
