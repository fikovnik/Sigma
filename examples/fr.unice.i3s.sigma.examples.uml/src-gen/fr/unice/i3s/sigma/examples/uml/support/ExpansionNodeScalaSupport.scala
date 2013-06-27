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
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.ExpansionRegion;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.ObjectNodeOrderingKind;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ExpansionNodeScalaSupport extends EMFScalaSupport {
  type ExpansionNode = org.eclipse.uml2.uml.ExpansionNode
  
  protected implicit val _expansionnodeProxyBuilder = new EMFProxyBuilder[ExpansionNode](UMLPackageScalaSupport._umlBuilder)
  
  object ExpansionNode {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, inPartition: EList[ActivityPartition] = null, inInterruptibleRegion: EList[InterruptibleActivityRegion] = null, outgoing: EList[ActivityEdge] = null, incoming: EList[ActivityEdge] = null, redefinedNode: EList[ActivityNode] = null, type_ : Type = null, inState: EList[State] = null, isControlType: Boolean = false, ordering: ObjectNodeOrderingKind = ObjectNodeOrderingKind.FIFO_LITERAL, selection: Behavior = null, upperBound: ValueSpecification = null, regionAsInput: ExpansionRegion = null, regionAsOutput: ExpansionRegion = null): ExpansionNode = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ExpansionNode]
      
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
      if (type_  != null) _instance.setType(type_ )
      if (inState != null) _instance.getInStates.addAll(inState)
      if (isControlType != false) _instance.setIsControlType(isControlType)
      if (ordering != ObjectNodeOrderingKind.FIFO_LITERAL) _instance.setOrdering(ordering)
      if (selection != null) _instance.setSelection(selection)
      if (upperBound != null) _instance.setUpperBound(upperBound)
      if (regionAsInput != null) _instance.setRegionAsInput(regionAsInput)
      if (regionAsOutput != null) _instance.setRegionAsOutput(regionAsOutput)
      
      _instance
    }
  }
  
  implicit class ExpansionNodeScalaSupport(that: ExpansionNode) {
    def regionAsInput: ExpansionRegion = that.getRegionAsInput
    def regionAsInput_=(value: ExpansionRegion): Unit = that.setRegionAsInput(value)
    def regionAsInput_=(value: ⇒ Option[ExpansionRegion]): Unit =
      that.setRegionAsInput(UMLPackageScalaSupport._umlBuilder.ref(value))
    def regionAsOutput: ExpansionRegion = that.getRegionAsOutput
    def regionAsOutput_=(value: ExpansionRegion): Unit = that.setRegionAsOutput(value)
    def regionAsOutput_=(value: ⇒ Option[ExpansionRegion]): Unit =
      that.setRegionAsOutput(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object ExpansionNodeScalaSupport extends ExpansionNodeScalaSupport
