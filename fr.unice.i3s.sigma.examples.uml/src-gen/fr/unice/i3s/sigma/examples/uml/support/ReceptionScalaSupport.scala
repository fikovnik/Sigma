package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;

trait ReceptionScalaSupport {
  implicit class ReceptionScalaSupport(that: Reception) {
    def signal: Signal = that.getSignal
    def signal_=(value: Signal): Unit = that.setSignal(value)
  }
}

object ReceptionScalaSupport extends ReceptionScalaSupport
