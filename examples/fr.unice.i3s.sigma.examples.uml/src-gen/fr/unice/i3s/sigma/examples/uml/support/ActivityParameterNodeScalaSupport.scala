package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.ObjectNodeOrderingKind;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ActivityParameterNodeScalaSupport extends EMFScalaSupport {
  type ActivityParameterNode = org.eclipse.uml2.uml.ActivityParameterNode
  
  protected implicit val _activityparameternodeProxyBuilder = new EMFProxyBuilder[ActivityParameterNode](UMLPackageScalaSupport._umlBuilder)
  
  object ActivityParameterNode {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, inPartition: EList[ActivityPartition] = null, inInterruptibleRegion: EList[InterruptibleActivityRegion] = null, outgoing: EList[ActivityEdge] = null, incoming: EList[ActivityEdge] = null, redefinedNode: EList[ActivityNode] = null, type_ : Type = null, inState: EList[State] = null, isControlType: Boolean = false, ordering: ObjectNodeOrderingKind = ObjectNodeOrderingKind.FIFO_LITERAL, selection: Behavior = null, upperBound: ValueSpecification = null, parameter: Parameter = null): ActivityParameterNode = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ActivityParameterNode]
      
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
      if (parameter != null) _instance.setParameter(parameter)
      
      _instance
    }
  }
  
  implicit class ActivityParameterNodeScalaSupport(that: ActivityParameterNode) {
    def parameter: Parameter = that.getParameter
    def parameter_=(value: Parameter): Unit = that.setParameter(value)
    def parameter_=(value: ⇒ Option[Parameter]): Unit =
      that.setParameter(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object ActivityParameterNodeScalaSupport extends ActivityParameterNodeScalaSupport
