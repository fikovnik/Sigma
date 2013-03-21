package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.LiteralInteger;

trait LiteralIntegerScalaSupport {
  implicit class LiteralIntegerScalaSupport(that: LiteralInteger) {
    def value: Int = that.getValue
    def value_=(value: Int): Unit = that.setValue(value)
  }
}

object LiteralIntegerScalaSupport extends LiteralIntegerScalaSupport
