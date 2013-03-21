package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.TemplateParameter;

trait ParameterableElementScalaSupport {
  implicit class ParameterableElementScalaSupport(that: ParameterableElement) {
    def owningTemplateParameter: TemplateParameter = that.getOwningTemplateParameter
    def owningTemplateParameter_=(value: TemplateParameter): Unit = that.setOwningTemplateParameter(value)
    def templateParameter: TemplateParameter = that.getTemplateParameter
    def templateParameter_=(value: TemplateParameter): Unit = that.setTemplateParameter(value)
  }
}

object ParameterableElementScalaSupport extends ParameterableElementScalaSupport
