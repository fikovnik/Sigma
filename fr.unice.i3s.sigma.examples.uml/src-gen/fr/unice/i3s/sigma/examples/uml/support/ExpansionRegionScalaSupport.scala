package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ExpansionKind;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.ExpansionRegion;

trait ExpansionRegionScalaSupport {
  implicit class ExpansionRegionScalaSupport(that: ExpansionRegion) {
    def mode: ExpansionKind = that.getMode
    def mode_=(value: ExpansionKind): Unit = that.setMode(value)
    def outputElement: EList[ExpansionNode] = that.getOutputElements
    def inputElement: EList[ExpansionNode] = that.getInputElements
  }
}

object ExpansionRegionScalaSupport extends ExpansionRegionScalaSupport
