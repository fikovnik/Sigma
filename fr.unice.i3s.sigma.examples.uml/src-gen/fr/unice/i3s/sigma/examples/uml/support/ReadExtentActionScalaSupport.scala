package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.ReadExtentAction;

trait ReadExtentActionScalaSupport {
  implicit class ReadExtentActionScalaSupport(that: ReadExtentAction) {
    def classifier: Classifier = that.getClassifier
    def classifier_=(value: Classifier): Unit = that.setClassifier(value)
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
  }
}

object ReadExtentActionScalaSupport extends ReadExtentActionScalaSupport
