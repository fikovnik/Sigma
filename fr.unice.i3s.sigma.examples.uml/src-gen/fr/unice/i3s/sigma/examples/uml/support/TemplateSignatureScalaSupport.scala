package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.TemplateableElement;

trait TemplateSignatureScalaSupport {
  implicit class TemplateSignatureScalaSupport(that: TemplateSignature) {
    def ownedParameter: EList[TemplateParameter] = that.getOwnedParameters
    def parameter: EList[TemplateParameter] = that.getParameters
    def template: TemplateableElement = that.getTemplate
    def template_=(value: TemplateableElement): Unit = that.setTemplate(value)
  }
}

object TemplateSignatureScalaSupport extends TemplateSignatureScalaSupport
