package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait VariableScalaSupport extends EMFScalaSupport {
  type Variable = org.eclipse.uml2.uml.Variable
  
  protected implicit val _variableProxyBuilder = new EMFProxyBuilder[Variable](UMLPackageScalaSupport._umlBuilder)
  
  object Variable {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, type_ : Type = null, templateParameter: TemplateParameter = null, isOrdered: Boolean = false, isUnique: Boolean = true, lowerValue: ValueSpecification = null, upperValue: ValueSpecification = null): Variable = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Variable]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (type_  != null) _instance.setType(type_ )
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (isOrdered != false) _instance.setIsOrdered(isOrdered)
      if (isUnique != true) _instance.setIsUnique(isUnique)
      if (lowerValue != null) _instance.setLowerValue(lowerValue)
      if (upperValue != null) _instance.setUpperValue(upperValue)
      
      _instance
    }
  }
  
  implicit class VariableScalaSupport(that: Variable) {
    def activityScope: Activity = that.getActivityScope
    def activityScope_=(value: Activity): Unit = that.setActivityScope(value)
    def activityScope_=(value: ⇒ Option[Activity]): Unit =
      that.setActivityScope(UMLPackageScalaSupport._umlBuilder.ref(value))
    def scope: StructuredActivityNode = that.getScope
    def scope_=(value: StructuredActivityNode): Unit = that.setScope(value)
    def scope_=(value: ⇒ Option[StructuredActivityNode]): Unit =
      that.setScope(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object VariableScalaSupport extends VariableScalaSupport
