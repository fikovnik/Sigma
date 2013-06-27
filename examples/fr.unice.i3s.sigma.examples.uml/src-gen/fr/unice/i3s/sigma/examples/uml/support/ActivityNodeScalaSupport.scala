package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ActivityNodeScalaSupport extends EMFScalaSupport {
  type ActivityNode = org.eclipse.uml2.uml.ActivityNode
  
  protected implicit val _activitynodeProxyBuilder = new EMFProxyBuilder[ActivityNode](UMLPackageScalaSupport._umlBuilder)
  
  object ActivityNode {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, inPartition: EList[ActivityPartition] = null, inInterruptibleRegion: EList[InterruptibleActivityRegion] = null, outgoing: EList[ActivityEdge] = null, incoming: EList[ActivityEdge] = null, redefinedNode: EList[ActivityNode] = null): ActivityNode = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ActivityNode]
      
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
      
      _instance
    }
  }
  
  implicit class ActivityNodeScalaSupport(that: ActivityNode) {
    def activity: Activity = that.getActivity
    def activity_=(value: Activity): Unit = that.setActivity(value)
    def activity_=(value: ⇒ Option[Activity]): Unit =
      that.setActivity(UMLPackageScalaSupport._umlBuilder.ref(value))
    def inPartition: EList[ActivityPartition] = that.getInPartitions
    def inStructuredNode: StructuredActivityNode = that.getInStructuredNode
    def inStructuredNode_=(value: StructuredActivityNode): Unit = that.setInStructuredNode(value)
    def inStructuredNode_=(value: ⇒ Option[StructuredActivityNode]): Unit =
      that.setInStructuredNode(UMLPackageScalaSupport._umlBuilder.ref(value))
    def inInterruptibleRegion: EList[InterruptibleActivityRegion] = that.getInInterruptibleRegions
    def outgoing: EList[ActivityEdge] = that.getOutgoings
    def incoming: EList[ActivityEdge] = that.getIncomings
    def inGroup: EList[ActivityGroup] = that.getInGroups
    def redefinedNode: EList[ActivityNode] = that.getRedefinedNodes
  }
}

object ActivityNodeScalaSupport extends ActivityNodeScalaSupport
