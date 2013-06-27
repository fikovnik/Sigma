package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

trait ExpressionScalaSupport extends EMFScalaSupport {
  type Expression = org.eclipse.uml2.uml.Expression
  
  protected implicit val _expressionProxyBuilder = new EMFProxyBuilder[Expression](UMLPackageScalaSupport._umlBuilder)
  
  object Expression {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, type_ : Type = null, operand: EList[ValueSpecification] = null, symbol: String = null): Expression = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Expression]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (type_  != null) _instance.setType(type_ )
      if (operand != null) _instance.getOperands.addAll(operand)
      if (symbol != null) _instance.setSymbol(symbol)
      
      _instance
    }
  }
  
  implicit class ExpressionScalaSupport(that: Expression) {
    def operand: EList[ValueSpecification] = that.getOperands
    def symbol: String = that.getSymbol
    def symbol_=(value: String): Unit = that.setSymbol(value)
  }
}

object ExpressionScalaSupport extends ExpressionScalaSupport
