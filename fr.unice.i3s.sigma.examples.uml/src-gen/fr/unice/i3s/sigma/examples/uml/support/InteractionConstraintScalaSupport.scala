package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.ValueSpecification;

trait InteractionConstraintScalaSupport {
  implicit class InteractionConstraintScalaSupport(that: InteractionConstraint) {
    def maxint: ValueSpecification = that.getMaxint
    def maxint_=(value: ValueSpecification): Unit = that.setMaxint(value)
    def minint: ValueSpecification = that.getMinint
    def minint_=(value: ValueSpecification): Unit = that.setMinint(value)
  }
}

object InteractionConstraintScalaSupport extends InteractionConstraintScalaSupport
