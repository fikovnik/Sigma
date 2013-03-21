package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.ValueSpecification;

trait ExpressionScalaSupport {
  implicit class ExpressionScalaSupport(that: Expression) {
    def operand: EList[ValueSpecification] = that.getOperands
    def symbol: String = that.getSymbol
    def symbol_=(value: String): Unit = that.setSymbol(value)
  }
}

object ExpressionScalaSupport extends ExpressionScalaSupport
