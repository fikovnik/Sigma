package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;

trait TypedElementScalaSupport {
  implicit class TypedElementScalaSupport(that: TypedElement) {
    def `type`: Type = that.getType
    def type_=(value: Type): Unit = that.setType(value)
  }
}

object TypedElementScalaSupport extends TypedElementScalaSupport
