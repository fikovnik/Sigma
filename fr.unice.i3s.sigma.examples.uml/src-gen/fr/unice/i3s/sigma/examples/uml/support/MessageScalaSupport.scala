package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageKind;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.ValueSpecification;

trait MessageScalaSupport {
  implicit class MessageScalaSupport(that: Message) {
    def argument: EList[ValueSpecification] = that.getArguments
    def connector: Connector = that.getConnector
    def connector_=(value: Connector): Unit = that.setConnector(value)
    def interaction: Interaction = that.getInteraction
    def interaction_=(value: Interaction): Unit = that.setInteraction(value)
    def messageKind: MessageKind = that.getMessageKind
    def messageSort: MessageSort = that.getMessageSort
    def messageSort_=(value: MessageSort): Unit = that.setMessageSort(value)
    def receiveEvent: MessageEnd = that.getReceiveEvent
    def receiveEvent_=(value: MessageEnd): Unit = that.setReceiveEvent(value)
    def sendEvent: MessageEnd = that.getSendEvent
    def sendEvent_=(value: MessageEnd): Unit = that.setSendEvent(value)
    def signature: NamedElement = that.getSignature
    def signature_=(value: NamedElement): Unit = that.setSignature(value)
  }
}

object MessageScalaSupport extends MessageScalaSupport
