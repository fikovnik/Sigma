package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;

trait CommentScalaSupport extends EMFScalaSupport {
  type Comment = org.eclipse.uml2.uml.Comment
  
  protected implicit val _commentProxyBuilder = new EMFProxyBuilder[Comment](UMLPackageScalaSupport._umlBuilder)
  
  object Comment {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, annotatedElement: EList[Element] = null, body: String = null): Comment = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Comment]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (annotatedElement != null) _instance.getAnnotatedElements.addAll(annotatedElement)
      if (body != null) _instance.setBody(body)
      
      _instance
    }
  }
  
  implicit class CommentScalaSupport(that: Comment) {
    def annotatedElement: EList[Element] = that.getAnnotatedElements
    def body: String = that.getBody
    def body_=(value: String): Unit = that.setBody(value)
  }
}

object CommentScalaSupport extends CommentScalaSupport
