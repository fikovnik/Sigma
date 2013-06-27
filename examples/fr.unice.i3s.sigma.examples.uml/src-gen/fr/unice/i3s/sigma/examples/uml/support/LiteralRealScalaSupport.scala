package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.VisibilityKind;

trait LiteralRealScalaSupport extends EMFScalaSupport {
  type LiteralReal = org.eclipse.uml2.uml.LiteralReal
  
  protected implicit val _literalrealProxyBuilder = new EMFProxyBuilder[LiteralReal](UMLPackageScalaSupport._umlBuilder)
  
  object LiteralReal {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, type_ : Type = null, value: Double = 0.0): LiteralReal = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[LiteralReal]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (type_  != null) _instance.setType(type_ )
      if (value != 0.0) _instance.setValue(value)
      
      _instance
    }
  }
  
  implicit class LiteralRealScalaSupport(that: LiteralReal) {
    def value: Double = that.getValue
    def value_=(value: Double): Unit = that.setValue(value)
  }
}

object LiteralRealScalaSupport extends LiteralRealScalaSupport
