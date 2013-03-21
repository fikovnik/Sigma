package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActionInputPin;

trait ActionInputPinScalaSupport {
  implicit class ActionInputPinScalaSupport(that: ActionInputPin) {
    def fromAction: Action = that.getFromAction
    def fromAction_=(value: Action): Unit = that.setFromAction(value)
  }
}

object ActionInputPinScalaSupport extends ActionInputPinScalaSupport
