package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ExpressionScalaSupport extends EMFScalaSupport {
  type Expression = fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression
  
  object Expression {
  }
}

object ExpressionScalaSupport extends ExpressionScalaSupport
