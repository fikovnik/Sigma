package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.RedefinableTemplateSignature;
import org.eclipse.uml2.uml.TemplateParameter;

trait RedefinableTemplateSignatureScalaSupport {
  implicit class RedefinableTemplateSignatureScalaSupport(that: RedefinableTemplateSignature) {
    def extendedSignature: EList[RedefinableTemplateSignature] = that.getExtendedSignatures
    def inheritedParameter: EList[TemplateParameter] = that.getInheritedParameters
    def classifier: Classifier = that.getClassifier
  }
}

object RedefinableTemplateSignatureScalaSupport extends RedefinableTemplateSignatureScalaSupport
