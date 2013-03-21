package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.SendObjectAction;

trait SendObjectActionScalaSupport {
  implicit class SendObjectActionScalaSupport(that: SendObjectAction) {
    def request: InputPin = that.getRequest
    def request_=(value: InputPin): Unit = that.setRequest(value)
    def target: InputPin = that.getTarget
    def target_=(value: InputPin): Unit = that.setTarget(value)
  }
}

object SendObjectActionScalaSupport extends SendObjectActionScalaSupport
