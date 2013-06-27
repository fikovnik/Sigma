package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait TypeScalaSupport extends EMFScalaSupport {
  type Type = org.eclipse.uml2.uml.Type
  
  protected implicit val _typeProxyBuilder = new EMFProxyBuilder[Type](UMLPackageScalaSupport._umlBuilder)
  
  object Type {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null): Type = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Type]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      
      _instance
    }
  }
  
  implicit class TypeScalaSupport(that: Type) {
    def package_ : org.eclipse.uml2.uml.Package = that.getPackage
    def package__=(value: org.eclipse.uml2.uml.Package): Unit = that.setPackage(value)
    def package__=(value: ⇒ Option[org.eclipse.uml2.uml.Package]): Unit =
      that.setPackage(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object TypeScalaSupport extends TypeScalaSupport
