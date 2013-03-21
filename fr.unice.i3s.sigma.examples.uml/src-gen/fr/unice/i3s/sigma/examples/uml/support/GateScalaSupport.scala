package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Gate;

trait GateScalaSupport {
  implicit class GateScalaSupport(that: Gate) {
    
  }
}

object GateScalaSupport extends GateScalaSupport
