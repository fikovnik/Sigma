package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.WriteVariableAction;

trait WriteVariableActionScalaSupport {
  implicit class WriteVariableActionScalaSupport(that: WriteVariableAction) {
    def value: InputPin = that.getValue
    def value_=(value: InputPin): Unit = that.setValue(value)
  }
}

object WriteVariableActionScalaSupport extends WriteVariableActionScalaSupport
