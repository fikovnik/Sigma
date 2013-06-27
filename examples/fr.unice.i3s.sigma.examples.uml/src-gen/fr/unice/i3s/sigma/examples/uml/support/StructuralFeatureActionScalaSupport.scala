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
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.StructuralFeatureAction;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait StructuralFeatureActionScalaSupport extends EMFScalaSupport {
  type StructuralFeatureAction = org.eclipse.uml2.uml.StructuralFeatureAction
  
  protected implicit val _structuralfeatureactionProxyBuilder = new EMFProxyBuilder[StructuralFeatureAction](UMLPackageScalaSupport._umlBuilder)
  
  object StructuralFeatureAction {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, inPartition: EList[ActivityPartition] = null, inInterruptibleRegion: EList[InterruptibleActivityRegion] = null, outgoing: EList[ActivityEdge] = null, incoming: EList[ActivityEdge] = null, redefinedNode: EList[ActivityNode] = null, handler: EList[ExceptionHandler] = null, isLocallyReentrant: Boolean = false, localPostcondition: EList[Constraint] = null, localPrecondition: EList[Constraint] = null, object_ : InputPin = null, structuralFeature: StructuralFeature = null): StructuralFeatureAction = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[StructuralFeatureAction]
      
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
      if (object_  != null) _instance.setObject(object_ )
      if (structuralFeature != null) _instance.setStructuralFeature(structuralFeature)
      
      _instance
    }
  }
  
  implicit class StructuralFeatureActionScalaSupport(that: StructuralFeatureAction) {
    def object_ : InputPin = that.getObject
    def object__=(value: InputPin): Unit = that.setObject(value)
    def structuralFeature: StructuralFeature = that.getStructuralFeature
    def structuralFeature_=(value: StructuralFeature): Unit = that.setStructuralFeature(value)
    def structuralFeature_=(value: ⇒ Option[StructuralFeature]): Unit =
      that.setStructuralFeature(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object StructuralFeatureActionScalaSupport extends StructuralFeatureActionScalaSupport
