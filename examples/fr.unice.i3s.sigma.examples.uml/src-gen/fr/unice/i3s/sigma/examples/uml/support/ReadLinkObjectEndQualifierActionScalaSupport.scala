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
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ReadLinkObjectEndQualifierAction;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ReadLinkObjectEndQualifierActionScalaSupport extends EMFScalaSupport {
  type ReadLinkObjectEndQualifierAction = org.eclipse.uml2.uml.ReadLinkObjectEndQualifierAction
  
  protected implicit val _readlinkobjectendqualifieractionProxyBuilder = new EMFProxyBuilder[ReadLinkObjectEndQualifierAction](UMLPackageScalaSupport._umlBuilder)
  
  object ReadLinkObjectEndQualifierAction {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, inPartition: EList[ActivityPartition] = null, inInterruptibleRegion: EList[InterruptibleActivityRegion] = null, outgoing: EList[ActivityEdge] = null, incoming: EList[ActivityEdge] = null, redefinedNode: EList[ActivityNode] = null, handler: EList[ExceptionHandler] = null, isLocallyReentrant: Boolean = false, localPostcondition: EList[Constraint] = null, localPrecondition: EList[Constraint] = null, object_ : InputPin = null, qualifier: Property = null, result: OutputPin = null): ReadLinkObjectEndQualifierAction = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ReadLinkObjectEndQualifierAction]
      
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
      if (qualifier != null) _instance.setQualifier(qualifier)
      if (result != null) _instance.setResult(result)
      
      _instance
    }
  }
  
  implicit class ReadLinkObjectEndQualifierActionScalaSupport(that: ReadLinkObjectEndQualifierAction) {
    def object_ : InputPin = that.getObject
    def object__=(value: InputPin): Unit = that.setObject(value)
    def qualifier: Property = that.getQualifier
    def qualifier_=(value: Property): Unit = that.setQualifier(value)
    def qualifier_=(value: ⇒ Option[Property]): Unit =
      that.setQualifier(UMLPackageScalaSupport._umlBuilder.ref(value))
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
  }
}

object ReadLinkObjectEndQualifierActionScalaSupport extends ReadLinkObjectEndQualifierActionScalaSupport
