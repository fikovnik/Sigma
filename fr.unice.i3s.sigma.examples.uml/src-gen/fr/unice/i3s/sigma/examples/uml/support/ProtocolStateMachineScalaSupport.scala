package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ProtocolConformance;
import org.eclipse.uml2.uml.ProtocolStateMachine;

trait ProtocolStateMachineScalaSupport {
  implicit class ProtocolStateMachineScalaSupport(that: ProtocolStateMachine) {
    def conformance: EList[ProtocolConformance] = that.getConformances
  }
}

object ProtocolStateMachineScalaSupport extends ProtocolStateMachineScalaSupport
