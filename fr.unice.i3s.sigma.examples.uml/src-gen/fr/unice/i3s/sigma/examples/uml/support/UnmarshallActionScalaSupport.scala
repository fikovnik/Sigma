package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.UnmarshallAction;

trait UnmarshallActionScalaSupport {
  implicit class UnmarshallActionScalaSupport(that: UnmarshallAction) {
    def `object`: InputPin = that.getObject
    def object_=(value: InputPin): Unit = that.setObject(value)
    def result: EList[OutputPin] = that.getResults
    def unmarshallType: Classifier = that.getUnmarshallType
    def unmarshallType_=(value: Classifier): Unit = that.setUnmarshallType(value)
  }
}

object UnmarshallActionScalaSupport extends UnmarshallActionScalaSupport
