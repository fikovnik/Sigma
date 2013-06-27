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
import org.eclipse.uml2.uml.DestroyObjectAction;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

trait DestroyObjectActionScalaSupport extends EMFScalaSupport {
  type DestroyObjectAction = org.eclipse.uml2.uml.DestroyObjectAction
  
  protected implicit val _destroyobjectactionProxyBuilder = new EMFProxyBuilder[DestroyObjectAction](UMLPackageScalaSupport._umlBuilder)
  
  object DestroyObjectAction {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, inPartition: EList[ActivityPartition] = null, inInterruptibleRegion: EList[InterruptibleActivityRegion] = null, outgoing: EList[ActivityEdge] = null, incoming: EList[ActivityEdge] = null, redefinedNode: EList[ActivityNode] = null, handler: EList[ExceptionHandler] = null, isLocallyReentrant: Boolean = false, localPostcondition: EList[Constraint] = null, localPrecondition: EList[Constraint] = null, isDestroyLinks: Boolean = false, isDestroyOwnedObjects: Boolean = false, target: InputPin = null): DestroyObjectAction = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[DestroyObjectAction]
      
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
      if (isDestroyLinks != false) _instance.setIsDestroyLinks(isDestroyLinks)
      if (isDestroyOwnedObjects != false) _instance.setIsDestroyOwnedObjects(isDestroyOwnedObjects)
      if (target != null) _instance.setTarget(target)
      
      _instance
    }
  }
  
  implicit class DestroyObjectActionScalaSupport(that: DestroyObjectAction) {
    def isDestroyLinks: Boolean = that.isDestroyLinks
    def isDestroyLinks_=(value: Boolean): Unit = that.setIsDestroyLinks(value)
    def isDestroyOwnedObjects: Boolean = that.isDestroyOwnedObjects
    def isDestroyOwnedObjects_=(value: Boolean): Unit = that.setIsDestroyOwnedObjects(value)
    def target: InputPin = that.getTarget
    def target_=(value: InputPin): Unit = that.setTarget(value)
  }
}

object DestroyObjectActionScalaSupport extends DestroyObjectActionScalaSupport
