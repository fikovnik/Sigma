package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;

trait CallBehaviorActionScalaSupport {
  implicit class CallBehaviorActionScalaSupport(that: CallBehaviorAction) {
    def behavior: Behavior = that.getBehavior
    def behavior_=(value: Behavior): Unit = that.setBehavior(value)
  }
}

object CallBehaviorActionScalaSupport extends CallBehaviorActionScalaSupport
