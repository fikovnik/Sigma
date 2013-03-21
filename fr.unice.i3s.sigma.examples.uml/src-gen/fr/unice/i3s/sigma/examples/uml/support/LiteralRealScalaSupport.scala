package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.LiteralReal;

trait LiteralRealScalaSupport {
  implicit class LiteralRealScalaSupport(that: LiteralReal) {
    def value: Double = that.getValue
    def value_=(value: Double): Unit = that.setValue(value)
  }
}

object LiteralRealScalaSupport extends LiteralRealScalaSupport
