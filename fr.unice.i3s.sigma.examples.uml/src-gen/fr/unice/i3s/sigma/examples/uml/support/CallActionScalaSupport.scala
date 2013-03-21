package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.CallAction;
import org.eclipse.uml2.uml.OutputPin;

trait CallActionScalaSupport {
  implicit class CallActionScalaSupport(that: CallAction) {
    def isSynchronous: Boolean = that.isSynchronous
    def isSynchronous_=(value: Boolean): Unit = that.setIsSynchronous(value)
    def result: EList[OutputPin] = that.getResults
  }
}

object CallActionScalaSupport extends CallActionScalaSupport
