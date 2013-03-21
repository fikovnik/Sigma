package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.WriteStructuralFeatureAction;

trait WriteStructuralFeatureActionScalaSupport {
  implicit class WriteStructuralFeatureActionScalaSupport(that: WriteStructuralFeatureAction) {
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
    def value: InputPin = that.getValue
    def value_=(value: InputPin): Unit = that.setValue(value)
  }
}

object WriteStructuralFeatureActionScalaSupport extends WriteStructuralFeatureActionScalaSupport
