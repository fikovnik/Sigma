package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;

trait TemplateParameterSubstitutionScalaSupport {
  implicit class TemplateParameterSubstitutionScalaSupport(that: TemplateParameterSubstitution) {
    def actual: ParameterableElement = that.getActual
    def actual_=(value: ParameterableElement): Unit = that.setActual(value)
    def formal: TemplateParameter = that.getFormal
    def formal_=(value: TemplateParameter): Unit = that.setFormal(value)
    def ownedActual: ParameterableElement = that.getOwnedActual
    def ownedActual_=(value: ParameterableElement): Unit = that.setOwnedActual(value)
    def templateBinding: TemplateBinding = that.getTemplateBinding
    def templateBinding_=(value: TemplateBinding): Unit = that.setTemplateBinding(value)
  }
}

object TemplateParameterSubstitutionScalaSupport extends TemplateParameterSubstitutionScalaSupport
