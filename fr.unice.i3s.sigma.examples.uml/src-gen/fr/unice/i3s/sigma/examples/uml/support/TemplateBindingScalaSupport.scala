package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.TemplateableElement;

trait TemplateBindingScalaSupport {
  implicit class TemplateBindingScalaSupport(that: TemplateBinding) {
    def parameterSubstitution: EList[TemplateParameterSubstitution] = that.getParameterSubstitutions
    def signature: TemplateSignature = that.getSignature
    def signature_=(value: TemplateSignature): Unit = that.setSignature(value)
    def boundElement: TemplateableElement = that.getBoundElement
    def boundElement_=(value: TemplateableElement): Unit = that.setBoundElement(value)
  }
}

object TemplateBindingScalaSupport extends TemplateBindingScalaSupport
