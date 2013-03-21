package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Type;

trait TypeScalaSupport {
  implicit class TypeScalaSupport(that: Type) {
    def `package`: org.eclipse.uml2.uml.Package = that.getPackage
    def package_=(value: org.eclipse.uml2.uml.Package): Unit = that.setPackage(value)
  }
}

object TypeScalaSupport extends TypeScalaSupport
