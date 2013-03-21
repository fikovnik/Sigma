package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;

trait InteractionOperandScalaSupport {
  implicit class InteractionOperandScalaSupport(that: InteractionOperand) {
    def guard: InteractionConstraint = that.getGuard
    def guard_=(value: InteractionConstraint): Unit = that.setGuard(value)
    def fragment: EList[InteractionFragment] = that.getFragments
  }
}

object InteractionOperandScalaSupport extends InteractionOperandScalaSupport
