package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Observation;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.ValueSpecification;

trait TimeExpressionScalaSupport {
  implicit class TimeExpressionScalaSupport(that: TimeExpression) {
    def expr: ValueSpecification = that.getExpr
    def expr_=(value: ValueSpecification): Unit = that.setExpr(value)
    def observation: EList[Observation] = that.getObservations
  }
}

object TimeExpressionScalaSupport extends TimeExpressionScalaSupport
