package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Duration;
import org.eclipse.uml2.uml.Observation;
import org.eclipse.uml2.uml.ValueSpecification;

trait DurationScalaSupport {
  implicit class DurationScalaSupport(that: Duration) {
    def expr: ValueSpecification = that.getExpr
    def expr_=(value: ValueSpecification): Unit = that.setExpr(value)
    def observation: EList[Observation] = that.getObservations
  }
}

object DurationScalaSupport extends DurationScalaSupport
