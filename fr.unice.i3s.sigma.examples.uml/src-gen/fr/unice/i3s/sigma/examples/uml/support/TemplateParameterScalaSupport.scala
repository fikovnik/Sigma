package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;

trait TemplateParameterScalaSupport {
  implicit class TemplateParameterScalaSupport(that: TemplateParameter) {
    def default: ParameterableElement = that.getDefault
    def default_=(value: ParameterableElement): Unit = that.setDefault(value)
    def ownedDefault: ParameterableElement = that.getOwnedDefault
    def ownedDefault_=(value: ParameterableElement): Unit = that.setOwnedDefault(value)
    def ownedParameteredElement: ParameterableElement = that.getOwnedParameteredElement
    def ownedParameteredElement_=(value: ParameterableElement): Unit = that.setOwnedParameteredElement(value)
    def parameteredElement: ParameterableElement = that.getParameteredElement
    def parameteredElement_=(value: ParameterableElement): Unit = that.setParameteredElement(value)
    def signature: TemplateSignature = that.getSignature
    def signature_=(value: TemplateSignature): Unit = that.setSignature(value)
  }
}

object TemplateParameterScalaSupport extends TemplateParameterScalaSupport
