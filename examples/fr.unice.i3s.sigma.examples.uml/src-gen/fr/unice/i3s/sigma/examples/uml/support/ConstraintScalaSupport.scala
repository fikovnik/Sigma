package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ConstraintScalaSupport extends EMFScalaSupport {
  type Constraint = org.eclipse.uml2.uml.Constraint
  
  protected implicit val _constraintProxyBuilder = new EMFProxyBuilder[Constraint](UMLPackageScalaSupport._umlBuilder)
  
  object Constraint {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, constrainedElement: EList[Element] = null, specification: ValueSpecification = null): Constraint = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Constraint]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (constrainedElement != null) _instance.getConstrainedElements.addAll(constrainedElement)
      if (specification != null) _instance.setSpecification(specification)
      
      _instance
    }
  }
  
  implicit class ConstraintScalaSupport(that: Constraint) {
    def constrainedElement: EList[Element] = that.getConstrainedElements
    def context: Namespace = that.getContext
    def context_=(value: Namespace): Unit = that.setContext(value)
    def context_=(value: ⇒ Option[Namespace]): Unit =
      that.setContext(UMLPackageScalaSupport._umlBuilder.ref(value))
    def specification: ValueSpecification = that.getSpecification
    def specification_=(value: ValueSpecification): Unit = that.setSpecification(value)
  }
}

object ConstraintScalaSupport extends ConstraintScalaSupport
