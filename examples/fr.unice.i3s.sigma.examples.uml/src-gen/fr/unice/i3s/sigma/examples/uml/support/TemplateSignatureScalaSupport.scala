package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.TemplateableElement;

import scala.Option;

trait TemplateSignatureScalaSupport extends EMFScalaSupport {
  type TemplateSignature = org.eclipse.uml2.uml.TemplateSignature
  
  protected implicit val _templatesignatureProxyBuilder = new EMFProxyBuilder[TemplateSignature](UMLPackageScalaSupport._umlBuilder)
  
  object TemplateSignature {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, ownedParameter: EList[TemplateParameter] = null, parameter: EList[TemplateParameter] = null): TemplateSignature = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[TemplateSignature]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (ownedParameter != null) _instance.getOwnedParameters.addAll(ownedParameter)
      if (parameter != null) _instance.getParameters.addAll(parameter)
      
      _instance
    }
  }
  
  implicit class TemplateSignatureScalaSupport(that: TemplateSignature) {
    def ownedParameter: EList[TemplateParameter] = that.getOwnedParameters
    def parameter: EList[TemplateParameter] = that.getParameters
    def template: TemplateableElement = that.getTemplate
    def template_=(value: TemplateableElement): Unit = that.setTemplate(value)
    def template_=(value: ⇒ Option[TemplateableElement]): Unit =
      that.setTemplate(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object TemplateSignatureScalaSupport extends TemplateSignatureScalaSupport
