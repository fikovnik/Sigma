package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.VisibilityKind;

trait LiteralStringScalaSupport extends EMFScalaSupport {
  type LiteralString = org.eclipse.uml2.uml.LiteralString
  
  protected implicit val _literalstringProxyBuilder = new EMFProxyBuilder[LiteralString](UMLPackageScalaSupport._umlBuilder)
  
  object LiteralString {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, type_ : Type = null, value: String = null): LiteralString = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[LiteralString]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (type_  != null) _instance.setType(type_ )
      if (value != null) _instance.setValue(value)
      
      _instance
    }
  }
  
  implicit class LiteralStringScalaSupport(that: LiteralString) {
    def value: String = that.getValue
    def value_=(value: String): Unit = that.setValue(value)
  }
}

object LiteralStringScalaSupport extends LiteralStringScalaSupport
