package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.ReadLinkAction;

trait ReadLinkActionScalaSupport {
  implicit class ReadLinkActionScalaSupport(that: ReadLinkAction) {
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
  }
}

object ReadLinkActionScalaSupport extends ReadLinkActionScalaSupport
