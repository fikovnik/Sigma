package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;

trait BehaviorExecutionSpecificationScalaSupport {
  implicit class BehaviorExecutionSpecificationScalaSupport(that: BehaviorExecutionSpecification) {
    def behavior: Behavior = that.getBehavior
    def behavior_=(value: Behavior): Unit = that.setBehavior(value)
  }
}

object BehaviorExecutionSpecificationScalaSupport extends BehaviorExecutionSpecificationScalaSupport
