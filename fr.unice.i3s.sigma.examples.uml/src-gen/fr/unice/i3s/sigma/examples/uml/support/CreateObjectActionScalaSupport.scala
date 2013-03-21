package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CreateObjectAction;
import org.eclipse.uml2.uml.OutputPin;

trait CreateObjectActionScalaSupport {
  implicit class CreateObjectActionScalaSupport(that: CreateObjectAction) {
    def classifier: Classifier = that.getClassifier
    def classifier_=(value: Classifier): Unit = that.setClassifier(value)
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
  }
}

object CreateObjectActionScalaSupport extends CreateObjectActionScalaSupport
