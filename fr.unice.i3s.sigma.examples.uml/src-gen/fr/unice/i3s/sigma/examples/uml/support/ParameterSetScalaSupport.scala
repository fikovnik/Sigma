package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;

trait ParameterSetScalaSupport {
  implicit class ParameterSetScalaSupport(that: ParameterSet) {
    def condition: EList[Constraint] = that.getConditions
    def parameter: EList[Parameter] = that.getParameters
  }
}

object ParameterSetScalaSupport extends ParameterSetScalaSupport
