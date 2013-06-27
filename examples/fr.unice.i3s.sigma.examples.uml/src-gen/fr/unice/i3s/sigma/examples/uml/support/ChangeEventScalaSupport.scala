package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

trait ChangeEventScalaSupport extends EMFScalaSupport {
  type ChangeEvent = org.eclipse.uml2.uml.ChangeEvent
  
  protected implicit val _changeeventProxyBuilder = new EMFProxyBuilder[ChangeEvent](UMLPackageScalaSupport._umlBuilder)
  
  object ChangeEvent {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, changeExpression: ValueSpecification = null): ChangeEvent = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ChangeEvent]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (changeExpression != null) _instance.setChangeExpression(changeExpression)
      
      _instance
    }
  }
  
  implicit class ChangeEventScalaSupport(that: ChangeEvent) {
    def changeExpression: ValueSpecification = that.getChangeExpression
    def changeExpression_=(value: ValueSpecification): Unit = that.setChangeExpression(value)
  }
}

object ChangeEventScalaSupport extends ChangeEventScalaSupport