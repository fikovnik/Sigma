package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.StartClassifierBehaviorAction;

trait StartClassifierBehaviorActionScalaSupport {
  implicit class StartClassifierBehaviorActionScalaSupport(that: StartClassifierBehaviorAction) {
    def `object`: InputPin = that.getObject
    def object_=(value: InputPin): Unit = that.setObject(value)
  }
}

object StartClassifierBehaviorActionScalaSupport extends StartClassifierBehaviorActionScalaSupport
