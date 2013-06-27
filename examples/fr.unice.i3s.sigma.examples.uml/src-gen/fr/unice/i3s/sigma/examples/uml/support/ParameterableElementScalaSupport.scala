package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.TemplateParameter;

import scala.Option;

trait ParameterableElementScalaSupport extends EMFScalaSupport {
  type ParameterableElement = org.eclipse.uml2.uml.ParameterableElement
  
  protected implicit val _parameterableelementProxyBuilder = new EMFProxyBuilder[ParameterableElement](UMLPackageScalaSupport._umlBuilder)
  
  object ParameterableElement {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, templateParameter: TemplateParameter = null): ParameterableElement = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ParameterableElement]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      
      _instance
    }
  }
  
  implicit class ParameterableElementScalaSupport(that: ParameterableElement) {
    def owningTemplateParameter: TemplateParameter = that.getOwningTemplateParameter
    def owningTemplateParameter_=(value: TemplateParameter): Unit = that.setOwningTemplateParameter(value)
    def owningTemplateParameter_=(value: ⇒ Option[TemplateParameter]): Unit =
      that.setOwningTemplateParameter(UMLPackageScalaSupport._umlBuilder.ref(value))
    def templateParameter: TemplateParameter = that.getTemplateParameter
    def templateParameter_=(value: TemplateParameter): Unit = that.setTemplateParameter(value)
    def templateParameter_=(value: ⇒ Option[TemplateParameter]): Unit =
      that.setTemplateParameter(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object ParameterableElementScalaSupport extends ParameterableElementScalaSupport
