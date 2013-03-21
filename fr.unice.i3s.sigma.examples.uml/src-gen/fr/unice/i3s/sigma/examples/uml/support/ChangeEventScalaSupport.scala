package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.ValueSpecification;

trait ChangeEventScalaSupport {
  implicit class ChangeEventScalaSupport(that: ChangeEvent) {
    def changeExpression: ValueSpecification = that.getChangeExpression
    def changeExpression_=(value: ValueSpecification): Unit = that.setChangeExpression(value)
  }
}

object ChangeEventScalaSupport extends ChangeEventScalaSupport
