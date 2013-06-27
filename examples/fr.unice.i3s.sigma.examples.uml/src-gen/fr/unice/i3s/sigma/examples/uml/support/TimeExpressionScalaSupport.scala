package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Observation;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

trait TimeExpressionScalaSupport extends EMFScalaSupport {
  type TimeExpression = org.eclipse.uml2.uml.TimeExpression
  
  protected implicit val _timeexpressionProxyBuilder = new EMFProxyBuilder[TimeExpression](UMLPackageScalaSupport._umlBuilder)
  
  object TimeExpression {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, type_ : Type = null, expr: ValueSpecification = null, observation: EList[Observation] = null): TimeExpression = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[TimeExpression]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (type_  != null) _instance.setType(type_ )
      if (expr != null) _instance.setExpr(expr)
      if (observation != null) _instance.getObservations.addAll(observation)
      
      _instance
    }
  }
  
  implicit class TimeExpressionScalaSupport(that: TimeExpression) {
    def expr: ValueSpecification = that.getExpr
    def expr_=(value: ValueSpecification): Unit = that.setExpr(value)
    def observation: EList[Observation] = that.getObservations
  }
}

object TimeExpressionScalaSupport extends TimeExpressionScalaSupport
