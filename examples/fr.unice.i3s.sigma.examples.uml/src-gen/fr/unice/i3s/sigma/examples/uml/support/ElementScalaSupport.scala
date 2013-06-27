package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;

trait ElementScalaSupport extends EMFScalaSupport {
  type Element = org.eclipse.uml2.uml.Element
  
  protected implicit val _elementProxyBuilder = new EMFProxyBuilder[Element](UMLPackageScalaSupport._umlBuilder)
  
  object Element {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null): Element = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Element]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      
      _instance
    }
  }
  
  implicit class ElementScalaSupport(that: Element) {
    def ownedComment: EList[Comment] = that.getOwnedComments
    def ownedElement: EList[Element] = that.getOwnedElements
    def owner: Element = that.getOwner
  }
}

object ElementScalaSupport extends ElementScalaSupport
