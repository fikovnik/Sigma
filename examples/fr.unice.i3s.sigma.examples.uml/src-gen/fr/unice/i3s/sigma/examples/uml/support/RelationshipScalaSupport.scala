package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Relationship;

trait RelationshipScalaSupport extends EMFScalaSupport {
  type Relationship = org.eclipse.uml2.uml.Relationship
  
  protected implicit val _relationshipProxyBuilder = new EMFProxyBuilder[Relationship](UMLPackageScalaSupport._umlBuilder)
  
  object Relationship {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null): Relationship = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Relationship]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      
      _instance
    }
  }
  
  implicit class RelationshipScalaSupport(that: Relationship) {
    def relatedElement: EList[Element] = that.getRelatedElements
  }
}

object RelationshipScalaSupport extends RelationshipScalaSupport
