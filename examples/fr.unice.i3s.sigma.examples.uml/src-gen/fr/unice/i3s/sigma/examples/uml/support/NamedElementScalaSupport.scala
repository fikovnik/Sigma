package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

trait NamedElementScalaSupport extends EMFScalaSupport {
  type NamedElement = org.eclipse.uml2.uml.NamedElement
  
  protected implicit val _namedelementProxyBuilder = new EMFProxyBuilder[NamedElement](UMLPackageScalaSupport._umlBuilder)
  
  object NamedElement {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL): NamedElement = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[NamedElement]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      
      _instance
    }
  }
  
  implicit class NamedElementScalaSupport(that: NamedElement) {
    def clientDependency: EList[Dependency] = that.getClientDependencies
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
    def nameExpression: StringExpression = that.getNameExpression
    def nameExpression_=(value: StringExpression): Unit = that.setNameExpression(value)
    def namespace: Namespace = that.getNamespace
    def qualifiedName: String = that.getQualifiedName
    def visibility: VisibilityKind = that.getVisibility
    def visibility_=(value: VisibilityKind): Unit = that.setVisibility(value)
  }
}

object NamedElementScalaSupport extends NamedElementScalaSupport
