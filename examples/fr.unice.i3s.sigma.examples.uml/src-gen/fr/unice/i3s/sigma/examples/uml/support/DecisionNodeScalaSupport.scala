package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait DecisionNodeScalaSupport extends EMFScalaSupport {
  type DecisionNode = org.eclipse.uml2.uml.DecisionNode
  
  protected implicit val _decisionnodeProxyBuilder = new EMFProxyBuilder[DecisionNode](UMLPackageScalaSupport._umlBuilder)
  
  object DecisionNode {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, inPartition: EList[ActivityPartition] = null, inInterruptibleRegion: EList[InterruptibleActivityRegion] = null, outgoing: EList[ActivityEdge] = null, incoming: EList[ActivityEdge] = null, redefinedNode: EList[ActivityNode] = null, decisionInput: Behavior = null, decisionInputFlow: ObjectFlow = null): DecisionNode = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[DecisionNode]
      
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
      if (decisionInput != null) _instance.setDecisionInput(decisionInput)
      if (decisionInputFlow != null) _instance.setDecisionInputFlow(decisionInputFlow)
      
      _instance
    }
  }
  
  implicit class DecisionNodeScalaSupport(that: DecisionNode) {
    def decisionInput: Behavior = that.getDecisionInput
    def decisionInput_=(value: Behavior): Unit = that.setDecisionInput(value)
    def decisionInput_=(value: ⇒ Option[Behavior]): Unit =
      that.setDecisionInput(UMLPackageScalaSupport._umlBuilder.ref(value))
    def decisionInputFlow: ObjectFlow = that.getDecisionInputFlow
    def decisionInputFlow_=(value: ObjectFlow): Unit = that.setDecisionInputFlow(value)
    def decisionInputFlow_=(value: ⇒ Option[ObjectFlow]): Unit =
      that.setDecisionInputFlow(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object DecisionNodeScalaSupport extends DecisionNodeScalaSupport
