package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ComponentRealization;

trait ComponentRealizationScalaSupport {
  implicit class ComponentRealizationScalaSupport(that: ComponentRealization) {
    def realizingClassifier: EList[Classifier] = that.getRealizingClassifiers
    def abstraction: Component = that.getAbstraction
    def abstraction_=(value: Component): Unit = that.setAbstraction(value)
  }
}

object ComponentRealizationScalaSupport extends ComponentRealizationScalaSupport
