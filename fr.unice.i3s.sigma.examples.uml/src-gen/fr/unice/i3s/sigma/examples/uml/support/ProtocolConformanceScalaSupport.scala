package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.ProtocolConformance;
import org.eclipse.uml2.uml.ProtocolStateMachine;

trait ProtocolConformanceScalaSupport {
  implicit class ProtocolConformanceScalaSupport(that: ProtocolConformance) {
    def generalMachine: ProtocolStateMachine = that.getGeneralMachine
    def generalMachine_=(value: ProtocolStateMachine): Unit = that.setGeneralMachine(value)
    def specificMachine: ProtocolStateMachine = that.getSpecificMachine
    def specificMachine_=(value: ProtocolStateMachine): Unit = that.setSpecificMachine(value)
  }
}

object ProtocolConformanceScalaSupport extends ProtocolConformanceScalaSupport
