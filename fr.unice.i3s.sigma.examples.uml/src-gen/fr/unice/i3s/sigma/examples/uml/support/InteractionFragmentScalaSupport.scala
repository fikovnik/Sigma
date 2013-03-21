package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;

trait InteractionFragmentScalaSupport {
  implicit class InteractionFragmentScalaSupport(that: InteractionFragment) {
    def covered: EList[Lifeline] = that.getCovereds
    def enclosingInteraction: Interaction = that.getEnclosingInteraction
    def enclosingInteraction_=(value: Interaction): Unit = that.setEnclosingInteraction(value)
    def enclosingOperand: InteractionOperand = that.getEnclosingOperand
    def enclosingOperand_=(value: InteractionOperand): Unit = that.setEnclosingOperand(value)
    def generalOrdering: EList[GeneralOrdering] = that.getGeneralOrderings
  }
}

object InteractionFragmentScalaSupport extends InteractionFragmentScalaSupport
