package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.VisibilityKind;

trait AddStructuralFeatureValueActionScalaSupport extends EMFScalaSupport {
  type AddStructuralFeatureValueAction = org.eclipse.uml2.uml.AddStructuralFeatureValueAction
  
  protected implicit val _addstructuralfeaturevalueactionProxyBuilder = new EMFProxyBuilder[AddStructuralFeatureValueAction](UMLPackageScalaSupport._umlBuilder)
  
  object AddStructuralFeatureValueAction {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, inPartition: EList[ActivityPartition] = null, inInterruptibleRegion: EList[InterruptibleActivityRegion] = null, outgoing: EList[ActivityEdge] = null, incoming: EList[ActivityEdge] = null, redefinedNode: EList[ActivityNode] = null, handler: EList[ExceptionHandler] = null, isLocallyReentrant: Boolean = false, localPostcondition: EList[Constraint] = null, localPrecondition: EList[Constraint] = null, object_ : InputPin = null, structuralFeature: StructuralFeature = null, result: OutputPin = null, value: InputPin = null, insertAt: InputPin = null, isReplaceAll: Boolean = false): AddStructuralFeatureValueAction = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[AddStructuralFeatureValueAction]
      
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
      if (result != null) _instance.setResult(result)
      if (value != null) _instance.setValue(value)
      if (insertAt != null) _instance.setInsertAt(insertAt)
      if (isReplaceAll != false) _instance.setIsReplaceAll(isReplaceAll)
      
      _instance
    }
  }
  
  implicit class AddStructuralFeatureValueActionScalaSupport(that: AddStructuralFeatureValueAction) {
    def insertAt: InputPin = that.getInsertAt
    def insertAt_=(value: InputPin): Unit = that.setInsertAt(value)
    def isReplaceAll: Boolean = that.isReplaceAll
    def isReplaceAll_=(value: Boolean): Unit = that.setIsReplaceAll(value)
  }
}

object AddStructuralFeatureValueActionScalaSupport extends AddStructuralFeatureValueActionScalaSupport
