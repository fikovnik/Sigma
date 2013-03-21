package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.OutputPin;

trait AcceptCallActionScalaSupport {
  implicit class AcceptCallActionScalaSupport(that: AcceptCallAction) {
    def returnInformation: OutputPin = that.getReturnInformation
    def returnInformation_=(value: OutputPin): Unit = that.setReturnInformation(value)
  }
}

object AcceptCallActionScalaSupport extends AcceptCallActionScalaSupport
