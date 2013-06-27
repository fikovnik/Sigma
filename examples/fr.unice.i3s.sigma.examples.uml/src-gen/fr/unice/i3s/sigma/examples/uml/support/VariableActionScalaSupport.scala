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
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.VariableAction;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait VariableActionScalaSupport extends EMFScalaSupport {
  type VariableAction = org.eclipse.uml2.uml.VariableAction
  
  protected implicit val _variableactionProxyBuilder = new EMFProxyBuilder[VariableAction](UMLPackageScalaSupport._umlBuilder)
  
  object VariableAction {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, inPartition: EList[ActivityPartition] = null, inInterruptibleRegion: EList[InterruptibleActivityRegion] = null, outgoing: EList[ActivityEdge] = null, incoming: EList[ActivityEdge] = null, redefinedNode: EList[ActivityNode] = null, handler: EList[ExceptionHandler] = null, isLocallyReentrant: Boolean = false, localPostcondition: EList[Constraint] = null, localPrecondition: EList[Constraint] = null, variable: Variable = null): VariableAction = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[VariableAction]
      
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
      if (variable != null) _instance.setVariable(variable)
      
      _instance
    }
  }
  
  implicit class VariableActionScalaSupport(that: VariableAction) {
    def variable: Variable = that.getVariable
    def variable_=(value: Variable): Unit = that.setVariable(value)
    def variable_=(value: ⇒ Option[Variable]): Unit =
      that.setVariable(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object VariableActionScalaSupport extends VariableActionScalaSupport
