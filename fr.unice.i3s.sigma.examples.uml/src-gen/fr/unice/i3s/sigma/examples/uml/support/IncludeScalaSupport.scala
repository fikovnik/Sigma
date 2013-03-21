package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.UseCase;

trait IncludeScalaSupport {
  implicit class IncludeScalaSupport(that: Include) {
    def addition: UseCase = that.getAddition
    def addition_=(value: UseCase): Unit = that.setAddition(value)
    def includingCase: UseCase = that.getIncludingCase
    def includingCase_=(value: UseCase): Unit = that.setIncludingCase(value)
  }
}

object IncludeScalaSupport extends IncludeScalaSupport
