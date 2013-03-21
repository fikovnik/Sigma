package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.ProtocolStateMachine;

trait PortScalaSupport {
  implicit class PortScalaSupport(that: Port) {
    def isBehavior: Boolean = that.isBehavior
    def isBehavior_=(value: Boolean): Unit = that.setIsBehavior(value)
    def isConjugated: Boolean = that.isConjugated
    def isConjugated_=(value: Boolean): Unit = that.setIsConjugated(value)
    def isService: Boolean = that.isService
    def isService_=(value: Boolean): Unit = that.setIsService(value)
    def protocol: ProtocolStateMachine = that.getProtocol
    def protocol_=(value: ProtocolStateMachine): Unit = that.setProtocol(value)
    def provided: EList[Interface] = that.getProvideds
    def redefinedPort: EList[Port] = that.getRedefinedPorts
    def required: EList[Interface] = that.getRequireds
  }
}

object PortScalaSupport extends PortScalaSupport
