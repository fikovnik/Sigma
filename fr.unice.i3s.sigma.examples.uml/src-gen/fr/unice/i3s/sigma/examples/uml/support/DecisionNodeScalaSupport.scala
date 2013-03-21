package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.ObjectFlow;

trait DecisionNodeScalaSupport {
  implicit class DecisionNodeScalaSupport(that: DecisionNode) {
    def decisionInput: Behavior = that.getDecisionInput
    def decisionInput_=(value: Behavior): Unit = that.setDecisionInput(value)
    def decisionInputFlow: ObjectFlow = that.getDecisionInputFlow
    def decisionInputFlow_=(value: ObjectFlow): Unit = that.setDecisionInputFlow(value)
  }
}

object DecisionNodeScalaSupport extends DecisionNodeScalaSupport
