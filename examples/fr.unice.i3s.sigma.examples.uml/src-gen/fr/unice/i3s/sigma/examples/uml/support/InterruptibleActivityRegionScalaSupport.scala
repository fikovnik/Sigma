package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

trait InterruptibleActivityRegionScalaSupport extends EMFScalaSupport {
  type InterruptibleActivityRegion = org.eclipse.uml2.uml.InterruptibleActivityRegion
  
  protected implicit val _interruptibleactivityregionProxyBuilder = new EMFProxyBuilder[InterruptibleActivityRegion](UMLPackageScalaSupport._umlBuilder)
  
  object InterruptibleActivityRegion {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, node: EList[ActivityNode] = null, interruptingEdge: EList[ActivityEdge] = null): InterruptibleActivityRegion = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[InterruptibleActivityRegion]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (node != null) _instance.getNodes.addAll(node)
      if (interruptingEdge != null) _instance.getInterruptingEdges.addAll(interruptingEdge)
      
      _instance
    }
  }
  
  implicit class InterruptibleActivityRegionScalaSupport(that: InterruptibleActivityRegion) {
    def node: EList[ActivityNode] = that.getNodes
    def interruptingEdge: EList[ActivityEdge] = that.getInterruptingEdges
  }
}

object InterruptibleActivityRegionScalaSupport extends InterruptibleActivityRegionScalaSupport
