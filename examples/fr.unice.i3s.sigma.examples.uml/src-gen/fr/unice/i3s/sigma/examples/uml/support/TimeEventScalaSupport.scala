package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.VisibilityKind;

trait TimeEventScalaSupport extends EMFScalaSupport {
  type TimeEvent = org.eclipse.uml2.uml.TimeEvent
  
  protected implicit val _timeeventProxyBuilder = new EMFProxyBuilder[TimeEvent](UMLPackageScalaSupport._umlBuilder)
  
  object TimeEvent {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, isRelative: Boolean = false, when: TimeExpression = null): TimeEvent = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[TimeEvent]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (isRelative != false) _instance.setIsRelative(isRelative)
      if (when != null) _instance.setWhen(when)
      
      _instance
    }
  }
  
  implicit class TimeEventScalaSupport(that: TimeEvent) {
    def isRelative: Boolean = that.isRelative
    def isRelative_=(value: Boolean): Unit = that.setIsRelative(value)
    def when: TimeExpression = that.getWhen
    def when_=(value: TimeExpression): Unit = that.setWhen(value)
  }
}

object TimeEventScalaSupport extends TimeEventScalaSupport
