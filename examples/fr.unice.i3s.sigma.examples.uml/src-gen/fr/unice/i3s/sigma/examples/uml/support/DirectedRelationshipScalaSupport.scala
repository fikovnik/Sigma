package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;

trait DirectedRelationshipScalaSupport extends EMFScalaSupport {
  type DirectedRelationship = org.eclipse.uml2.uml.DirectedRelationship
  
  protected implicit val _directedrelationshipProxyBuilder = new EMFProxyBuilder[DirectedRelationship](UMLPackageScalaSupport._umlBuilder)
  
  object DirectedRelationship {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null): DirectedRelationship = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[DirectedRelationship]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      
      _instance
    }
  }
  
  implicit class DirectedRelationshipScalaSupport(that: DirectedRelationship) {
    def source: EList[Element] = that.getSources
    def target: EList[Element] = that.getTargets
  }
}

object DirectedRelationshipScalaSupport extends DirectedRelationshipScalaSupport
