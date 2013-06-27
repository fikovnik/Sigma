package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

trait TimeConstraintScalaSupport extends EMFScalaSupport {
  type TimeConstraint = org.eclipse.uml2.uml.TimeConstraint
  
  protected implicit val _timeconstraintProxyBuilder = new EMFProxyBuilder[TimeConstraint](UMLPackageScalaSupport._umlBuilder)
  
  object TimeConstraint {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, constrainedElement: EList[Element] = null, specification: ValueSpecification = null, firstEvent: Boolean = true): TimeConstraint = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[TimeConstraint]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (constrainedElement != null) _instance.getConstrainedElements.addAll(constrainedElement)
      if (specification != null) _instance.setSpecification(specification)
      if (firstEvent != true) _instance.setFirstEvent(firstEvent)
      
      _instance
    }
  }
  
  implicit class TimeConstraintScalaSupport(that: TimeConstraint) {
    def firstEvent: Boolean = that.isFirstEvent
    def firstEvent_=(value: Boolean): Unit = that.setFirstEvent(value)
  }
}

object TimeConstraintScalaSupport extends TimeConstraintScalaSupport
