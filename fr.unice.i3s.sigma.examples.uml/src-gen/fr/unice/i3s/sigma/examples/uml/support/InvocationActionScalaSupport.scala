package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InvocationAction;
import org.eclipse.uml2.uml.Port;

trait InvocationActionScalaSupport {
  implicit class InvocationActionScalaSupport(that: InvocationAction) {
    def argument: EList[InputPin] = that.getArguments
    def onPort: Port = that.getOnPort
    def onPort_=(value: Port): Unit = that.setOnPort(value)
  }
}

object InvocationActionScalaSupport extends InvocationActionScalaSupport
