package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OutputPin;

trait OpaqueActionScalaSupport {
  implicit class OpaqueActionScalaSupport(that: OpaqueAction) {
    def body: EList[String] = that.getBodies
    def inputValue: EList[InputPin] = that.getInputValues
    def language: EList[String] = that.getLanguages
    def outputValue: EList[OutputPin] = that.getOutputValues
  }
}

object OpaqueActionScalaSupport extends OpaqueActionScalaSupport
