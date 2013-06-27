package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait CallBehaviorActionScalaSupport extends EMFScalaSupport {
  type CallBehaviorAction = org.eclipse.uml2.uml.CallBehaviorAction
  
  protected implicit val _callbehavioractionProxyBuilder = new EMFProxyBuilder[CallBehaviorAction](UMLPackageScalaSupport._umlBuilder)
  
  object CallBehaviorAction {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, inPartition: EList[ActivityPartition] = null, inInterruptibleRegion: EList[InterruptibleActivityRegion] = null, outgoing: EList[ActivityEdge] = null, incoming: EList[ActivityEdge] = null, redefinedNode: EList[ActivityNode] = null, handler: EList[ExceptionHandler] = null, isLocallyReentrant: Boolean = false, localPostcondition: EList[Constraint] = null, localPrecondition: EList[Constraint] = null, argument: EList[InputPin] = null, onPort: Port = null, isSynchronous: Boolean = true, result: EList[OutputPin] = null, behavior: Behavior = null): CallBehaviorAction = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[CallBehaviorAction]
      
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
      if (argument != null) _instance.getArguments.addAll(argument)
      if (onPort != null) _instance.setOnPort(onPort)
      if (isSynchronous != true) _instance.setIsSynchronous(isSynchronous)
      if (result != null) _instance.getResults.addAll(result)
      if (behavior != null) _instance.setBehavior(behavior)
      
      _instance
    }
  }
  
  implicit class CallBehaviorActionScalaSupport(that: CallBehaviorAction) {
    def behavior: Behavior = that.getBehavior
    def behavior_=(value: Behavior): Unit = that.setBehavior(value)
    def behavior_=(value: ⇒ Option[Behavior]): Unit =
      that.setBehavior(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object CallBehaviorActionScalaSupport extends CallBehaviorActionScalaSupport
