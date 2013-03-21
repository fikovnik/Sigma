package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.ClearStructuralFeatureAction;
import org.eclipse.uml2.uml.OutputPin;

trait ClearStructuralFeatureActionScalaSupport {
  implicit class ClearStructuralFeatureActionScalaSupport(that: ClearStructuralFeatureAction) {
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
  }
}

object ClearStructuralFeatureActionScalaSupport extends ClearStructuralFeatureActionScalaSupport
