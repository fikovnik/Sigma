package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.StateInvariant;

trait StateInvariantScalaSupport {
  implicit class StateInvariantScalaSupport(that: StateInvariant) {
    def invariant: Constraint = that.getInvariant
    def invariant_=(value: Constraint): Unit = that.setInvariant(value)
  }
}

object StateInvariantScalaSupport extends StateInvariantScalaSupport
