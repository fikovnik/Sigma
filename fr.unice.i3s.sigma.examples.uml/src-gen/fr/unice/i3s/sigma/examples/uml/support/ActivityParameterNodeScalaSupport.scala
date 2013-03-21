package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.Parameter;

trait ActivityParameterNodeScalaSupport {
  implicit class ActivityParameterNodeScalaSupport(that: ActivityParameterNode) {
    def parameter: Parameter = that.getParameter
    def parameter_=(value: Parameter): Unit = that.setParameter(value)
  }
}

object ActivityParameterNodeScalaSupport extends ActivityParameterNodeScalaSupport
