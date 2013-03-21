package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Trigger;

trait AcceptEventActionScalaSupport {
  implicit class AcceptEventActionScalaSupport(that: AcceptEventAction) {
    def isUnmarshall: Boolean = that.isUnmarshall
    def isUnmarshall_=(value: Boolean): Unit = that.setIsUnmarshall(value)
    def result: EList[OutputPin] = that.getResults
    def trigger: EList[Trigger] = that.getTriggers
  }
}

object AcceptEventActionScalaSupport extends AcceptEventActionScalaSupport
