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
import org.eclipse.uml2.uml.ReadIsClassifiedObjectAction;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ReadIsClassifiedObjectActionScalaSupport extends EMFScalaSupport {
  type ReadIsClassifiedObjectAction = org.eclipse.uml2.uml.ReadIsClassifiedObjectAction
  
  protected implicit val _readisclassifiedobjectactionProxyBuilder = new EMFProxyBuilder[ReadIsClassifiedObjectAction](UMLPackageScalaSupport._umlBuilder)
  
  object ReadIsClassifiedObjectAction {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, inPartition: EList[ActivityPartition] = null, inInterruptibleRegion: EList[InterruptibleActivityRegion] = null, outgoing: EList[ActivityEdge] = null, incoming: EList[ActivityEdge] = null, redefinedNode: EList[ActivityNode] = null, handler: EList[ExceptionHandler] = null, isLocallyReentrant: Boolean = false, localPostcondition: EList[Constraint] = null, localPrecondition: EList[Constraint] = null, classifier: Classifier = null, isDirect: Boolean = false, object_ : InputPin = null, result: OutputPin = null): ReadIsClassifiedObjectAction = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ReadIsClassifiedObjectAction]
      
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
      if (classifier != null) _instance.setClassifier(classifier)
      if (isDirect != false) _instance.setIsDirect(isDirect)
      if (object_  != null) _instance.setObject(object_ )
      if (result != null) _instance.setResult(result)
      
      _instance
    }
  }
  
  implicit class ReadIsClassifiedObjectActionScalaSupport(that: ReadIsClassifiedObjectAction) {
    def classifier: Classifier = that.getClassifier
    def classifier_=(value: Classifier): Unit = that.setClassifier(value)
    def classifier_=(value: ⇒ Option[Classifier]): Unit =
      that.setClassifier(UMLPackageScalaSupport._umlBuilder.ref(value))
    def isDirect: Boolean = that.isDirect
    def isDirect_=(value: Boolean): Unit = that.setIsDirect(value)
    def object_ : InputPin = that.getObject
    def object__=(value: InputPin): Unit = that.setObject(value)
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
  }
}

object ReadIsClassifiedObjectActionScalaSupport extends ReadIsClassifiedObjectActionScalaSupport
