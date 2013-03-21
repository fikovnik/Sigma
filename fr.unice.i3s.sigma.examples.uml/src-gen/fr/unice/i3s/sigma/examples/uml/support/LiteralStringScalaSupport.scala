package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.LiteralString;

trait LiteralStringScalaSupport {
  implicit class LiteralStringScalaSupport(that: LiteralString) {
    def value: String = that.getValue
    def value_=(value: String): Unit = that.setValue(value)
  }
}

object LiteralStringScalaSupport extends LiteralStringScalaSupport
