package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.VariableAction;

trait VariableActionScalaSupport {
  implicit class VariableActionScalaSupport(that: VariableAction) {
    def variable: Variable = that.getVariable
    def variable_=(value: Variable): Unit = that.setVariable(value)
  }
}

object VariableActionScalaSupport extends VariableActionScalaSupport
