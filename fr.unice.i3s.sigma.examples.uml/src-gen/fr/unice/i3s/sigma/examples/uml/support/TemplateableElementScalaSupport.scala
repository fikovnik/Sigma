package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.TemplateableElement;

trait TemplateableElementScalaSupport {
  implicit class TemplateableElementScalaSupport(that: TemplateableElement) {
    def ownedTemplateSignature: TemplateSignature = that.getOwnedTemplateSignature
    def ownedTemplateSignature_=(value: TemplateSignature): Unit = that.setOwnedTemplateSignature(value)
    def templateBinding: EList[TemplateBinding] = that.getTemplateBindings
  }
}

object TemplateableElementScalaSupport extends TemplateableElementScalaSupport
