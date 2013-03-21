package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.OutputPin;

trait LoopNodeScalaSupport {
  implicit class LoopNodeScalaSupport(that: LoopNode) {
    def bodyOutput: EList[OutputPin] = that.getBodyOutputs
    def bodyPart: EList[ExecutableNode] = that.getBodyParts
    def decider: OutputPin = that.getDecider
    def decider_=(value: OutputPin): Unit = that.setDecider(value)
    def isTestedFirst: Boolean = that.isTestedFirst
    def isTestedFirst_=(value: Boolean): Unit = that.setIsTestedFirst(value)
    def loopVariable: EList[OutputPin] = that.getLoopVariables
    def loopVariableInput: EList[InputPin] = that.getLoopVariableInputs
    def result: EList[OutputPin] = that.getResults
    def setupPart: EList[ExecutableNode] = that.getSetupParts
    def test: EList[ExecutableNode] = that.getTests
  }
}

object LoopNodeScalaSupport extends LoopNodeScalaSupport
