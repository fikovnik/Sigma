package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

trait ControlFlowScalaSupport extends EMFScalaSupport {
  type ControlFlow = org.eclipse.uml2.uml.ControlFlow
  
  protected implicit val _controlflowProxyBuilder = new EMFProxyBuilder[ControlFlow](UMLPackageScalaSupport._umlBuilder)
  
  object ControlFlow {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, guard: ValueSpecification = null, inPartition: EList[ActivityPartition] = null, interrupts: InterruptibleActivityRegion = null, redefinedEdge: EList[ActivityEdge] = null, source: ActivityNode = null, target: ActivityNode = null, weight: ValueSpecification = null): ControlFlow = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ControlFlow]
      
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
      
      _instance
    }
  }
}

object ControlFlowScalaSupport extends ControlFlowScalaSupport
