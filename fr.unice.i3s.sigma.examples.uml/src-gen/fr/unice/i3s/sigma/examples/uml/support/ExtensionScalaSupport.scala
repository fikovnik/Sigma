package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Extension;

trait ExtensionScalaSupport {
  implicit class ExtensionScalaSupport(that: Extension) {
    def isRequired: Boolean = that.isRequired
    def metaclass: org.eclipse.uml2.uml.Class = that.getMetaclass
  }
}

object ExtensionScalaSupport extends ExtensionScalaSupport
