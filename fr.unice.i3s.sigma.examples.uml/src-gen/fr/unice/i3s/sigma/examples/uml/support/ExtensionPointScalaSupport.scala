package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.UseCase;

trait ExtensionPointScalaSupport {
  implicit class ExtensionPointScalaSupport(that: ExtensionPoint) {
    def useCase: UseCase = that.getUseCase
    def useCase_=(value: UseCase): Unit = that.setUseCase(value)
  }
}

object ExtensionPointScalaSupport extends ExtensionPointScalaSupport
