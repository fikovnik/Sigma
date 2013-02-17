package fr.unice.i3s.sigma.scala.utils.ecore

import org.eclipse.emf.ecore.ENamedElement;

trait ENamedElementScalaSupport {
  implicit class ENamedElementScalaSupport(obj: ENamedElement) {
    def name: String = obj.getName
    def name_=(value: String): Unit = obj.setName(value)
  }
}

object ENamedElementScalaSupport extends ENamedElementScalaSupport
