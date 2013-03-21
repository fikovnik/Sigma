package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.StructuralFeatureAction;

trait StructuralFeatureActionScalaSupport {
  implicit class StructuralFeatureActionScalaSupport(that: StructuralFeatureAction) {
    def `object`: InputPin = that.getObject
    def object_=(value: InputPin): Unit = that.setObject(value)
    def structuralFeature: StructuralFeature = that.getStructuralFeature
    def structuralFeature_=(value: StructuralFeature): Unit = that.setStructuralFeature(value)
  }
}

object StructuralFeatureActionScalaSupport extends StructuralFeatureActionScalaSupport
