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
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.ObjectNodeOrderingKind;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ObjectNodeScalaSupport extends EMFScalaSupport {
  type ObjectNode = org.eclipse.uml2.uml.ObjectNode
  
  protected implicit val _objectnodeProxyBuilder = new EMFProxyBuilder[ObjectNode](UMLPackageScalaSupport._umlBuilder)
  
  object ObjectNode {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, inPartition: EList[ActivityPartition] = null, inInterruptibleRegion: EList[InterruptibleActivityRegion] = null, outgoing: EList[ActivityEdge] = null, incoming: EList[ActivityEdge] = null, redefinedNode: EList[ActivityNode] = null, type_ : Type = null, inState: EList[State] = null, isControlType: Boolean = false, ordering: ObjectNodeOrderingKind = ObjectNodeOrderingKind.FIFO_LITERAL, selection: Behavior = null, upperBound: ValueSpecification = null): ObjectNode = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ObjectNode]
      
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
      
      _instance
    }
  }
  
  implicit class ObjectNodeScalaSupport(that: ObjectNode) {
    def inState: EList[State] = that.getInStates
    def isControlType: Boolean = that.isControlType
    def isControlType_=(value: Boolean): Unit = that.setIsControlType(value)
    def ordering: ObjectNodeOrderingKind = that.getOrdering
    def ordering_=(value: ObjectNodeOrderingKind): Unit = that.setOrdering(value)
    def selection: Behavior = that.getSelection
    def selection_=(value: Behavior): Unit = that.setSelection(value)
    def selection_=(value: ⇒ Option[Behavior]): Unit =
      that.setSelection(UMLPackageScalaSupport._umlBuilder.ref(value))
    def upperBound: ValueSpecification = that.getUpperBound
    def upperBound_=(value: ValueSpecification): Unit = that.setUpperBound(value)
  }
}

object ObjectNodeScalaSupport extends ObjectNodeScalaSupport
