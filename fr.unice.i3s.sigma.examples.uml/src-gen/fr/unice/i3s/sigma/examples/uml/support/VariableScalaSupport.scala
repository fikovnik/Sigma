package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.Variable;

trait VariableScalaSupport {
  implicit class VariableScalaSupport(that: Variable) {
    def activityScope: Activity = that.getActivityScope
    def activityScope_=(value: Activity): Unit = that.setActivityScope(value)
    def scope: StructuredActivityNode = that.getScope
    def scope_=(value: StructuredActivityNode): Unit = that.setScope(value)
  }
}

object VariableScalaSupport extends VariableScalaSupport
