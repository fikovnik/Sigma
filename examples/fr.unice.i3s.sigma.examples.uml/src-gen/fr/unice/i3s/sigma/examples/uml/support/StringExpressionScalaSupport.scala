package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait StringExpressionScalaSupport extends EMFScalaSupport {
  type StringExpression = org.eclipse.uml2.uml.StringExpression
  
  protected implicit val _stringexpressionProxyBuilder = new EMFProxyBuilder[StringExpression](UMLPackageScalaSupport._umlBuilder)
  
  object StringExpression {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, type_ : Type = null, operand: EList[ValueSpecification] = null, symbol: String = null, ownedTemplateSignature: TemplateSignature = null, templateBinding: EList[TemplateBinding] = null, subExpression: EList[StringExpression] = null): StringExpression = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[StringExpression]
      
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
      if (ownedTemplateSignature != null) _instance.setOwnedTemplateSignature(ownedTemplateSignature)
      if (templateBinding != null) _instance.getTemplateBindings.addAll(templateBinding)
      if (subExpression != null) _instance.getSubExpressions.addAll(subExpression)
      
      _instance
    }
  }
  
  implicit class StringExpressionScalaSupport(that: StringExpression) {
    def owningExpression: StringExpression = that.getOwningExpression
    def owningExpression_=(value: StringExpression): Unit = that.setOwningExpression(value)
    def owningExpression_=(value: ⇒ Option[StringExpression]): Unit =
      that.setOwningExpression(UMLPackageScalaSupport._umlBuilder.ref(value))
    def subExpression: EList[StringExpression] = that.getSubExpressions
  }
}

object StringExpressionScalaSupport extends StringExpressionScalaSupport
