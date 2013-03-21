package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.StartObjectBehaviorAction;

trait StartObjectBehaviorActionScalaSupport {
  implicit class StartObjectBehaviorActionScalaSupport(that: StartObjectBehaviorAction) {
    def `object`: InputPin = that.getObject
    def object_=(value: InputPin): Unit = that.setObject(value)
  }
}

object StartObjectBehaviorActionScalaSupport extends StartObjectBehaviorActionScalaSupport
