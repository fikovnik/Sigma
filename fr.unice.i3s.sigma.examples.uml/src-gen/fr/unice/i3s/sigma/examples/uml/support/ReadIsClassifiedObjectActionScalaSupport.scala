package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.ReadIsClassifiedObjectAction;

trait ReadIsClassifiedObjectActionScalaSupport {
  implicit class ReadIsClassifiedObjectActionScalaSupport(that: ReadIsClassifiedObjectAction) {
    def classifier: Classifier = that.getClassifier
    def classifier_=(value: Classifier): Unit = that.setClassifier(value)
    def isDirect: Boolean = that.isDirect
    def isDirect_=(value: Boolean): Unit = that.setIsDirect(value)
    def `object`: InputPin = that.getObject
    def object_=(value: InputPin): Unit = that.setObject(value)
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
  }
}

object ReadIsClassifiedObjectActionScalaSupport extends ReadIsClassifiedObjectActionScalaSupport
