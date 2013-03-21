package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;

trait CombinedFragmentScalaSupport {
  implicit class CombinedFragmentScalaSupport(that: CombinedFragment) {
    def cfragmentGate: EList[Gate] = that.getCfragmentGates
    def interactionOperator: InteractionOperatorKind = that.getInteractionOperator
    def interactionOperator_=(value: InteractionOperatorKind): Unit = that.setInteractionOperator(value)
    def operand: EList[InteractionOperand] = that.getOperands
  }
}

object CombinedFragmentScalaSupport extends CombinedFragmentScalaSupport
