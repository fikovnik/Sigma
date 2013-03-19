package fr.unice.i3s.sigma.support.ecore

import org.eclipse.emf.ecore.ENamedElement;

trait ENamedElementScalaSupport {
  implicit class ENamedElementScalaSupport(that: ENamedElement) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
  }
}

object ENamedElementScalaSupport extends ENamedElementScalaSupport
