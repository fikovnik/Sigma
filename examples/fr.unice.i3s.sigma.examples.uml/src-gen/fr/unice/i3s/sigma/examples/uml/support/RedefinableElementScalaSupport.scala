package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.RedefinableElement;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

trait RedefinableElementScalaSupport extends EMFScalaSupport {
  type RedefinableElement = org.eclipse.uml2.uml.RedefinableElement
  
  protected implicit val _redefinableelementProxyBuilder = new EMFProxyBuilder[RedefinableElement](UMLPackageScalaSupport._umlBuilder)
  
  object RedefinableElement {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false): RedefinableElement = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[RedefinableElement]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (isLeaf != false) _instance.setIsLeaf(isLeaf)
      
      _instance
    }
  }
  
  implicit class RedefinableElementScalaSupport(that: RedefinableElement) {
    def isLeaf: Boolean = that.isLeaf
    def isLeaf_=(value: Boolean): Unit = that.setIsLeaf(value)
    def redefinedElement: EList[RedefinableElement] = that.getRedefinedElements
    def redefinitionContext: EList[Classifier] = that.getRedefinitionContexts
  }
}

object RedefinableElementScalaSupport extends RedefinableElementScalaSupport
