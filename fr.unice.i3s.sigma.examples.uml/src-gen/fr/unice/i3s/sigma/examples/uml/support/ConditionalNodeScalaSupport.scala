package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Clause;
import org.eclipse.uml2.uml.ConditionalNode;
import org.eclipse.uml2.uml.OutputPin;

trait ConditionalNodeScalaSupport {
  implicit class ConditionalNodeScalaSupport(that: ConditionalNode) {
    def clause: EList[Clause] = that.getClauses
    def isAssured: Boolean = that.isAssured
    def isAssured_=(value: Boolean): Unit = that.setIsAssured(value)
    def isDeterminate: Boolean = that.isDeterminate
    def isDeterminate_=(value: Boolean): Unit = that.setIsDeterminate(value)
    def result: EList[OutputPin] = that.getResults
  }
}

object ConditionalNodeScalaSupport extends ConditionalNodeScalaSupport
