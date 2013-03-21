package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.Variable;

trait StructuredActivityNodeScalaSupport {
  implicit class StructuredActivityNodeScalaSupport(that: StructuredActivityNode) {
    def mustIsolate: Boolean = that.isMustIsolate
    def mustIsolate_=(value: Boolean): Unit = that.setMustIsolate(value)
    def node: EList[ActivityNode] = that.getNodes
    def structuredNodeInput: EList[InputPin] = that.getStructuredNodeInputs
    def structuredNodeOutput: EList[OutputPin] = that.getStructuredNodeOutputs
    def variable: EList[Variable] = that.getVariables
    def edge: EList[ActivityEdge] = that.getEdges
  }
}

object StructuredActivityNodeScalaSupport extends StructuredActivityNodeScalaSupport
