package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;

trait ActionScalaSupport {
  implicit class ActionScalaSupport(that: Action) {
    def context: Classifier = that.getContext
    def input: EList[InputPin] = that.getInputs
    def isLocallyReentrant: Boolean = that.isLocallyReentrant
    def isLocallyReentrant_=(value: Boolean): Unit = that.setIsLocallyReentrant(value)
    def localPostcondition: EList[Constraint] = that.getLocalPostconditions
    def localPrecondition: EList[Constraint] = that.getLocalPreconditions
    def output: EList[OutputPin] = that.getOutputs
  }
}

object ActionScalaSupport extends ActionScalaSupport
