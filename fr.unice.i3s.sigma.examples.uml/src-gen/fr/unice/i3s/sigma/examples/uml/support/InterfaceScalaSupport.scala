package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ProtocolStateMachine;
import org.eclipse.uml2.uml.Reception;

trait InterfaceScalaSupport {
  implicit class InterfaceScalaSupport(that: Interface) {
    def nestedClassifier: EList[Classifier] = that.getNestedClassifiers
    def ownedAttribute: EList[Property] = that.getOwnedAttributes
    def ownedOperation: EList[Operation] = that.getOwnedOperations
    def ownedReception: EList[Reception] = that.getOwnedReceptions
    def protocol: ProtocolStateMachine = that.getProtocol
    def protocol_=(value: ProtocolStateMachine): Unit = that.setProtocol(value)
    def redefinedInterface: EList[Interface] = that.getRedefinedInterfaces
  }
}

object InterfaceScalaSupport extends InterfaceScalaSupport
