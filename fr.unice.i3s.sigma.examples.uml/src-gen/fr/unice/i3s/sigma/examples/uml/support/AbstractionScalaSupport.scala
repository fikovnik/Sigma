package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.OpaqueExpression;

trait AbstractionScalaSupport {
  implicit class AbstractionScalaSupport(that: Abstraction) {
    def mapping: OpaqueExpression = that.getMapping
    def mapping_=(value: OpaqueExpression): Unit = that.setMapping(value)
  }
}

object AbstractionScalaSupport extends AbstractionScalaSupport
