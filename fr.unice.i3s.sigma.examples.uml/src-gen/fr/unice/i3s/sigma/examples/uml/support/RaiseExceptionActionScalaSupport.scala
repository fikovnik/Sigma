package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.RaiseExceptionAction;

trait RaiseExceptionActionScalaSupport {
  implicit class RaiseExceptionActionScalaSupport(that: RaiseExceptionAction) {
    def exception: InputPin = that.getException
    def exception_=(value: InputPin): Unit = that.setException(value)
  }
}

object RaiseExceptionActionScalaSupport extends RaiseExceptionActionScalaSupport
