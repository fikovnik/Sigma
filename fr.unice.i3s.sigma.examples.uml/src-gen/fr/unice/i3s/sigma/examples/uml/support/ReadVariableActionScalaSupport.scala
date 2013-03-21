package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.ReadVariableAction;

trait ReadVariableActionScalaSupport {
  implicit class ReadVariableActionScalaSupport(that: ReadVariableAction) {
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
  }
}

object ReadVariableActionScalaSupport extends ReadVariableActionScalaSupport
