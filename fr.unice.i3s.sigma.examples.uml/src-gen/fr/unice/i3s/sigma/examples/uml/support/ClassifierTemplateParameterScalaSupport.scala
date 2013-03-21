package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;

trait ClassifierTemplateParameterScalaSupport {
  implicit class ClassifierTemplateParameterScalaSupport(that: ClassifierTemplateParameter) {
    def allowSubstitutable: Boolean = that.isAllowSubstitutable
    def allowSubstitutable_=(value: Boolean): Unit = that.setAllowSubstitutable(value)
    def constrainingClassifier: EList[Classifier] = that.getConstrainingClassifiers
  }
}

object ClassifierTemplateParameterScalaSupport extends ClassifierTemplateParameterScalaSupport
