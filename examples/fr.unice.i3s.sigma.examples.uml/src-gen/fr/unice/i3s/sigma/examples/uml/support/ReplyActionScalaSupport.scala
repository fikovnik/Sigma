package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.ReplyAction;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ReplyActionScalaSupport extends EMFScalaSupport {
  type ReplyAction = org.eclipse.uml2.uml.ReplyAction
  
  protected implicit val _replyactionProxyBuilder = new EMFProxyBuilder[ReplyAction](UMLPackageScalaSupport._umlBuilder)
  
  object ReplyAction {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, inPartition: EList[ActivityPartition] = null, inInterruptibleRegion: EList[InterruptibleActivityRegion] = null, outgoing: EList[ActivityEdge] = null, incoming: EList[ActivityEdge] = null, redefinedNode: EList[ActivityNode] = null, handler: EList[ExceptionHandler] = null, isLocallyReentrant: Boolean = false, localPostcondition: EList[Constraint] = null, localPrecondition: EList[Constraint] = null, replyToCall: Trigger = null, replyValue: EList[InputPin] = null, returnInformation: InputPin = null): ReplyAction = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ReplyAction]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (isLeaf != false) _instance.setIsLeaf(isLeaf)
      if (inPartition != null) _instance.getInPartitions.addAll(inPartition)
      if (inInterruptibleRegion != null) _instance.getInInterruptibleRegions.addAll(inInterruptibleRegion)
      if (outgoing != null) _instance.getOutgoings.addAll(outgoing)
      if (incoming != null) _instance.getIncomings.addAll(incoming)
      if (redefinedNode != null) _instance.getRedefinedNodes.addAll(redefinedNode)
      if (handler != null) _instance.getHandlers.addAll(handler)
      if (isLocallyReentrant != false) _instance.setIsLocallyReentrant(isLocallyReentrant)
      if (localPostcondition != null) _instance.getLocalPostconditions.addAll(localPostcondition)
      if (localPrecondition != null) _instance.getLocalPreconditions.addAll(localPrecondition)
      if (replyToCall != null) _instance.setReplyToCall(replyToCall)
      if (replyValue != null) _instance.getReplyValues.addAll(replyValue)
      if (returnInformation != null) _instance.setReturnInformation(returnInformation)
      
      _instance
    }
  }
  
  implicit class ReplyActionScalaSupport(that: ReplyAction) {
    def replyToCall: Trigger = that.getReplyToCall
    def replyToCall_=(value: Trigger): Unit = that.setReplyToCall(value)
    def replyToCall_=(value: ⇒ Option[Trigger]): Unit =
      that.setReplyToCall(UMLPackageScalaSupport._umlBuilder.ref(value))
    def replyValue: EList[InputPin] = that.getReplyValues
    def returnInformation: InputPin = that.getReturnInformation
    def returnInformation_=(value: InputPin): Unit = that.setReturnInformation(value)
  }
}

object ReplyActionScalaSupport extends ReplyActionScalaSupport
