package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.ReadSelfAction;

trait ReadSelfActionScalaSupport {
  implicit class ReadSelfActionScalaSupport(that: ReadSelfAction) {
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
  }
}

object ReadSelfActionScalaSupport extends ReadSelfActionScalaSupport
