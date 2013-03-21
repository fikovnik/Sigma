package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.BroadcastSignalAction;
import org.eclipse.uml2.uml.Signal;

trait BroadcastSignalActionScalaSupport {
  implicit class BroadcastSignalActionScalaSupport(that: BroadcastSignalAction) {
    def signal: Signal = that.getSignal
    def signal_=(value: Signal): Unit = that.setSignal(value)
  }
}

object BroadcastSignalActionScalaSupport extends BroadcastSignalActionScalaSupport
