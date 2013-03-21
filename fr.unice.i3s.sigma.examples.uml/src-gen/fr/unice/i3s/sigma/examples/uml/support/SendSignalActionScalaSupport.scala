package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.Signal;

trait SendSignalActionScalaSupport {
  implicit class SendSignalActionScalaSupport(that: SendSignalAction) {
    def signal: Signal = that.getSignal
    def signal_=(value: Signal): Unit = that.setSignal(value)
    def target: InputPin = that.getTarget
    def target_=(value: InputPin): Unit = that.setTarget(value)
  }
}

object SendSignalActionScalaSupport extends SendSignalActionScalaSupport
