package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.LiteralBoolean;

trait LiteralBooleanScalaSupport {
  implicit class LiteralBooleanScalaSupport(that: LiteralBoolean) {
    def value: Boolean = that.isValue
    def value_=(value: Boolean): Unit = that.setValue(value)
  }
}

object LiteralBooleanScalaSupport extends LiteralBooleanScalaSupport
