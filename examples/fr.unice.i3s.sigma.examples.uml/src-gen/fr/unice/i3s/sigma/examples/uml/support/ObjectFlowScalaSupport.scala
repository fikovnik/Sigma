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
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ObjectFlowScalaSupport extends EMFScalaSupport {
  type ObjectFlow = org.eclipse.uml2.uml.ObjectFlow
  
  protected implicit val _objectflowProxyBuilder = new EMFProxyBuilder[ObjectFlow](UMLPackageScalaSupport._umlBuilder)
  
  object ObjectFlow {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, guard: ValueSpecification = null, inPartition: EList[ActivityPartition] = null, interrupts: InterruptibleActivityRegion = null, redefinedEdge: EList[ActivityEdge] = null, source: ActivityNode = null, target: ActivityNode = null, weight: ValueSpecification = null, isMulticast: Boolean = false, isMultireceive: Boolean = false, selection: Behavior = null, transformation: Behavior = null): ObjectFlow = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ObjectFlow]
      
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
      if (isMulticast != false) _instance.setIsMulticast(isMulticast)
      if (isMultireceive != false) _instance.setIsMultireceive(isMultireceive)
      if (selection != null) _instance.setSelection(selection)
      if (transformation != null) _instance.setTransformation(transformation)
      
      _instance
    }
  }
  
  implicit class ObjectFlowScalaSupport(that: ObjectFlow) {
    def isMulticast: Boolean = that.isMulticast
    def isMulticast_=(value: Boolean): Unit = that.setIsMulticast(value)
    def isMultireceive: Boolean = that.isMultireceive
    def isMultireceive_=(value: Boolean): Unit = that.setIsMultireceive(value)
    def selection: Behavior = that.getSelection
    def selection_=(value: Behavior): Unit = that.setSelection(value)
    def selection_=(value: ⇒ Option[Behavior]): Unit =
      that.setSelection(UMLPackageScalaSupport._umlBuilder.ref(value))
    def transformation: Behavior = that.getTransformation
    def transformation_=(value: Behavior): Unit = that.setTransformation(value)
    def transformation_=(value: ⇒ Option[Behavior]): Unit =
      that.setTransformation(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object ObjectFlowScalaSupport extends ObjectFlowScalaSupport
