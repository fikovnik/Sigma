package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActionExecutionSpecification;

trait ActionExecutionSpecificationScalaSupport {
  implicit class ActionExecutionSpecificationScalaSupport(that: ActionExecutionSpecification) {
    def action: Action = that.getAction
    def action_=(value: Action): Unit = that.setAction(value)
  }
}

object ActionExecutionSpecificationScalaSupport extends ActionExecutionSpecificationScalaSupport
