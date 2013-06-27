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
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ActivityEdgeScalaSupport extends EMFScalaSupport {
  type ActivityEdge = org.eclipse.uml2.uml.ActivityEdge
  
  protected implicit val _activityedgeProxyBuilder = new EMFProxyBuilder[ActivityEdge](UMLPackageScalaSupport._umlBuilder)
  
  object ActivityEdge {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, guard: ValueSpecification = null, inPartition: EList[ActivityPartition] = null, interrupts: InterruptibleActivityRegion = null, redefinedEdge: EList[ActivityEdge] = null, source: ActivityNode = null, target: ActivityNode = null, weight: ValueSpecification = null): ActivityEdge = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ActivityEdge]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (isLeaf != false) _instance.setIsLeaf(isLeaf)
      if (guard != null) _instance.setGuard(guard)
      if (inPartition != null) _instance.getInPartitions.addAll(inPartition)
      if (interrupts != null) _instance.setInterrupts(interrupts)
      if (redefinedEdge != null) _instance.getRedefinedEdges.addAll(redefinedEdge)
      if (source != null) _instance.setSource(source)
      if (target != null) _instance.setTarget(target)
      if (weight != null) _instance.setWeight(weight)
      
      _instance
    }
  }
  
  implicit class ActivityEdgeScalaSupport(that: ActivityEdge) {
    def activity: Activity = that.getActivity
    def activity_=(value: Activity): Unit = that.setActivity(value)
    def activity_=(value: ⇒ Option[Activity]): Unit =
      that.setActivity(UMLPackageScalaSupport._umlBuilder.ref(value))
    def guard: ValueSpecification = that.getGuard
    def guard_=(value: ValueSpecification): Unit = that.setGuard(value)
    def inPartition: EList[ActivityPartition] = that.getInPartitions
    def inStructuredNode: StructuredActivityNode = that.getInStructuredNode
    def inStructuredNode_=(value: StructuredActivityNode): Unit = that.setInStructuredNode(value)
    def inStructuredNode_=(value: ⇒ Option[StructuredActivityNode]): Unit =
      that.setInStructuredNode(UMLPackageScalaSupport._umlBuilder.ref(value))
    def interrupts: InterruptibleActivityRegion = that.getInterrupts
    def interrupts_=(value: InterruptibleActivityRegion): Unit = that.setInterrupts(value)
    def interrupts_=(value: ⇒ Option[InterruptibleActivityRegion]): Unit =
      that.setInterrupts(UMLPackageScalaSupport._umlBuilder.ref(value))
    def redefinedEdge: EList[ActivityEdge] = that.getRedefinedEdges
    def source: ActivityNode = that.getSource
    def source_=(value: ActivityNode): Unit = that.setSource(value)
    def source_=(value: ⇒ Option[ActivityNode]): Unit =
      that.setSource(UMLPackageScalaSupport._umlBuilder.ref(value))
    def target: ActivityNode = that.getTarget
    def target_=(value: ActivityNode): Unit = that.setTarget(value)
    def target_=(value: ⇒ Option[ActivityNode]): Unit =
      that.setTarget(UMLPackageScalaSupport._umlBuilder.ref(value))
    def weight: ValueSpecification = that.getWeight
    def weight_=(value: ValueSpecification): Unit = that.setWeight(value)
    def inGroup: EList[ActivityGroup] = that.getInGroups
  }
}

object ActivityEdgeScalaSupport extends ActivityEdgeScalaSupport
