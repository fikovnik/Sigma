package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.CreateLinkObjectAction;
import org.eclipse.uml2.uml.OutputPin;

trait CreateLinkObjectActionScalaSupport {
  implicit class CreateLinkObjectActionScalaSupport(that: CreateLinkObjectAction) {
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
  }
}

object CreateLinkObjectActionScalaSupport extends CreateLinkObjectActionScalaSupport
