package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.ExpansionRegion;

trait ExpansionNodeScalaSupport {
  implicit class ExpansionNodeScalaSupport(that: ExpansionNode) {
    def regionAsInput: ExpansionRegion = that.getRegionAsInput
    def regionAsInput_=(value: ExpansionRegion): Unit = that.setRegionAsInput(value)
    def regionAsOutput: ExpansionRegion = that.getRegionAsOutput
    def regionAsOutput_=(value: ExpansionRegion): Unit = that.setRegionAsOutput(value)
  }
}

object ExpansionNodeScalaSupport extends ExpansionNodeScalaSupport
