package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.ProtocolTransition;

trait ProtocolTransitionScalaSupport {
  implicit class ProtocolTransitionScalaSupport(that: ProtocolTransition) {
    def postCondition: Constraint = that.getPostCondition
    def postCondition_=(value: Constraint): Unit = that.setPostCondition(value)
    def preCondition: Constraint = that.getPreCondition
    def preCondition_=(value: Constraint): Unit = that.setPreCondition(value)
    def referred: EList[Operation] = that.getReferreds
  }
}

object ProtocolTransitionScalaSupport extends ProtocolTransitionScalaSupport
