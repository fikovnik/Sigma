package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageKind;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait MessageScalaSupport extends EMFScalaSupport {
  type Message = org.eclipse.uml2.uml.Message
  
  protected implicit val _messageProxyBuilder = new EMFProxyBuilder[Message](UMLPackageScalaSupport._umlBuilder)
  
  object Message {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, argument: EList[ValueSpecification] = null, connector: Connector = null, messageSort: MessageSort = MessageSort.SYNCH_CALL_LITERAL, receiveEvent: MessageEnd = null, sendEvent: MessageEnd = null, signature: NamedElement = null): Message = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Message]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (argument != null) _instance.getArguments.addAll(argument)
      if (connector != null) _instance.setConnector(connector)
      if (messageSort != MessageSort.SYNCH_CALL_LITERAL) _instance.setMessageSort(messageSort)
      if (receiveEvent != null) _instance.setReceiveEvent(receiveEvent)
      if (sendEvent != null) _instance.setSendEvent(sendEvent)
      if (signature != null) _instance.setSignature(signature)
      
      _instance
    }
  }
  
  implicit class MessageScalaSupport(that: Message) {
    def argument: EList[ValueSpecification] = that.getArguments
    def connector: Connector = that.getConnector
    def connector_=(value: Connector): Unit = that.setConnector(value)
    def connector_=(value: ⇒ Option[Connector]): Unit =
      that.setConnector(UMLPackageScalaSupport._umlBuilder.ref(value))
    def interaction: Interaction = that.getInteraction
    def interaction_=(value: Interaction): Unit = that.setInteraction(value)
    def interaction_=(value: ⇒ Option[Interaction]): Unit =
      that.setInteraction(UMLPackageScalaSupport._umlBuilder.ref(value))
    def messageKind: MessageKind = that.getMessageKind
    def messageSort: MessageSort = that.getMessageSort
    def messageSort_=(value: MessageSort): Unit = that.setMessageSort(value)
    def receiveEvent: MessageEnd = that.getReceiveEvent
    def receiveEvent_=(value: MessageEnd): Unit = that.setReceiveEvent(value)
    def receiveEvent_=(value: ⇒ Option[MessageEnd]): Unit =
      that.setReceiveEvent(UMLPackageScalaSupport._umlBuilder.ref(value))
    def sendEvent: MessageEnd = that.getSendEvent
    def sendEvent_=(value: MessageEnd): Unit = that.setSendEvent(value)
    def sendEvent_=(value: ⇒ Option[MessageEnd]): Unit =
      that.setSendEvent(UMLPackageScalaSupport._umlBuilder.ref(value))
    def signature: NamedElement = that.getSignature
    def signature_=(value: NamedElement): Unit = that.setSignature(value)
    def signature_=(value: ⇒ Option[NamedElement]): Unit =
      that.setSignature(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object MessageScalaSupport extends MessageScalaSupport
