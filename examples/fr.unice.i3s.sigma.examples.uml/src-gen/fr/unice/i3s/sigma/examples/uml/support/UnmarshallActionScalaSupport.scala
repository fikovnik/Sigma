package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.UnmarshallAction;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait UnmarshallActionScalaSupport extends EMFScalaSupport {
  type UnmarshallAction = org.eclipse.uml2.uml.UnmarshallAction
  
  protected implicit val _unmarshallactionProxyBuilder = new EMFProxyBuilder[UnmarshallAction](UMLPackageScalaSupport._umlBuilder)
  
  object UnmarshallAction {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, inPartition: EList[ActivityPartition] = null, inInterruptibleRegion: EList[InterruptibleActivityRegion] = null, outgoing: EList[ActivityEdge] = null, incoming: EList[ActivityEdge] = null, redefinedNode: EList[ActivityNode] = null, handler: EList[ExceptionHandler] = null, isLocallyReentrant: Boolean = false, localPostcondition: EList[Constraint] = null, localPrecondition: EList[Constraint] = null, object_ : InputPin = null, result: EList[OutputPin] = null, unmarshallType: Classifier = null): UnmarshallAction = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[UnmarshallAction]
      
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
      if (result != null) _instance.getResults.addAll(result)
      if (unmarshallType != null) _instance.setUnmarshallType(unmarshallType)
      
      _instance
    }
  }
  
  implicit class UnmarshallActionScalaSupport(that: UnmarshallAction) {
    def object_ : InputPin = that.getObject
    def object__=(value: InputPin): Unit = that.setObject(value)
    def result: EList[OutputPin] = that.getResults
    def unmarshallType: Classifier = that.getUnmarshallType
    def unmarshallType_=(value: Classifier): Unit = that.setUnmarshallType(value)
    def unmarshallType_=(value: ⇒ Option[Classifier]): Unit =
      that.setUnmarshallType(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object UnmarshallActionScalaSupport extends UnmarshallActionScalaSupport
