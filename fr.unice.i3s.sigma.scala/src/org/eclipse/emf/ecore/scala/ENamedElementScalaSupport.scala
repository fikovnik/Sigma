package org.eclipse.emf.ecore.scala

import org.eclipse.emf.ecore.ENamedElement;

trait ENamedElementScalaSupport {
  implicit class ENamedElementScalaSupport(obj: ENamedElement) {
    def name: String = obj.getName
    def name_=(value: String): Unit = obj.setName(value)
  }
}

object ENamedElementScalaSupport extends ENamedElementScalaSupport
