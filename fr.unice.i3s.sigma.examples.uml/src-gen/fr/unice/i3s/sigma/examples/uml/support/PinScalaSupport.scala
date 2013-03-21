package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Pin;

trait PinScalaSupport {
  implicit class PinScalaSupport(that: Pin) {
    def isControl: Boolean = that.isControl
    def isControl_=(value: Boolean): Unit = that.setIsControl(value)
  }
}

object PinScalaSupport extends PinScalaSupport
