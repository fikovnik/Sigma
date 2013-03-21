package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.IntervalConstraint;

trait IntervalConstraintScalaSupport {
  implicit class IntervalConstraintScalaSupport(that: IntervalConstraint) {
    
  }
}

object IntervalConstraintScalaSupport extends IntervalConstraintScalaSupport
