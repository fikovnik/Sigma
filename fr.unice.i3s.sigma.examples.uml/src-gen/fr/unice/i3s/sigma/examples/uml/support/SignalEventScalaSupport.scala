package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;

trait SignalEventScalaSupport {
  implicit class SignalEventScalaSupport(that: SignalEvent) {
    def signal: Signal = that.getSignal
    def signal_=(value: Signal): Unit = that.setSignal(value)
  }
}

object SignalEventScalaSupport extends SignalEventScalaSupport
