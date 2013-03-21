package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.LiteralUnlimitedNatural;

trait LiteralUnlimitedNaturalScalaSupport {
  implicit class LiteralUnlimitedNaturalScalaSupport(that: LiteralUnlimitedNatural) {
    def value: Int = that.getValue
    def value_=(value: Int): Unit = that.setValue(value)
  }
}

object LiteralUnlimitedNaturalScalaSupport extends LiteralUnlimitedNaturalScalaSupport
