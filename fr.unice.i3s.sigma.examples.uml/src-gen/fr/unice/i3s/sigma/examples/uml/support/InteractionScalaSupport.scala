package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;

trait InteractionScalaSupport {
  implicit class InteractionScalaSupport(that: Interaction) {
    def action: EList[Action] = that.getActions
    def formalGate: EList[Gate] = that.getFormalGates
    def fragment: EList[InteractionFragment] = that.getFragments
    def lifeline: EList[Lifeline] = that.getLifelines
    def message: EList[Message] = that.getMessages
  }
}

object InteractionScalaSupport extends InteractionScalaSupport
