package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.StringExpression;

trait StringExpressionScalaSupport {
  implicit class StringExpressionScalaSupport(that: StringExpression) {
    def owningExpression: StringExpression = that.getOwningExpression
    def owningExpression_=(value: StringExpression): Unit = that.setOwningExpression(value)
    def subExpression: EList[StringExpression] = that.getSubExpressions
  }
}

object StringExpressionScalaSupport extends StringExpressionScalaSupport
