package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.FinalState;

trait FinalStateScalaSupport {
  implicit class FinalStateScalaSupport(that: FinalState) {
    
  }
}

object FinalStateScalaSupport extends FinalStateScalaSupport
