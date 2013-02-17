package fr.unice.i3s.sigma.scala.utils.ecore

import org.eclipse.emf.ecore.EObject;

trait EObjectScalaSupport {
  implicit class EObjectScalaSupport(obj: EObject) {
  }
}

object EObjectScalaSupport extends EObjectScalaSupport
