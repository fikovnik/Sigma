package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait OpaqueExpressionScalaSupport extends EMFScalaSupport {
  type OpaqueExpression = org.eclipse.uml2.uml.OpaqueExpression
  
  protected implicit val _opaqueexpressionProxyBuilder = new EMFProxyBuilder[OpaqueExpression](UMLPackageScalaSupport._umlBuilder)
  
  object OpaqueExpression {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, type_ : Type = null, behavior: Behavior = null, body: EList[String] = null, language: EList[String] = null): OpaqueExpression = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[OpaqueExpression]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (type_  != null) _instance.setType(type_ )
      if (behavior != null) _instance.setBehavior(behavior)
      if (body != null) _instance.getBodies.addAll(body)
      if (language != null) _instance.getLanguages.addAll(language)
      
      _instance
    }
  }
  
  implicit class OpaqueExpressionScalaSupport(that: OpaqueExpression) {
    def behavior: Behavior = that.getBehavior
    def behavior_=(value: Behavior): Unit = that.setBehavior(value)
    def behavior_=(value: ⇒ Option[Behavior]): Unit =
      that.setBehavior(UMLPackageScalaSupport._umlBuilder.ref(value))
    def body: EList[String] = that.getBodies
    def language: EList[String] = that.getLanguages
    def result: Parameter = that.getResult
  }
}

object OpaqueExpressionScalaSupport extends OpaqueExpressionScalaSupport
