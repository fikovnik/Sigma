package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.LiteralNull;

trait LiteralNullScalaSupport {
  implicit class LiteralNullScalaSupport(that: LiteralNull) {
    
  }
}

object LiteralNullScalaSupport extends LiteralNullScalaSupport
