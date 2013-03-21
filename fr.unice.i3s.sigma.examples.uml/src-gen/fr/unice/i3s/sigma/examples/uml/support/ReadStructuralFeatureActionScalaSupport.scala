package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.ReadStructuralFeatureAction;

trait ReadStructuralFeatureActionScalaSupport {
  implicit class ReadStructuralFeatureActionScalaSupport(that: ReadStructuralFeatureAction) {
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
  }
}

object ReadStructuralFeatureActionScalaSupport extends ReadStructuralFeatureActionScalaSupport
