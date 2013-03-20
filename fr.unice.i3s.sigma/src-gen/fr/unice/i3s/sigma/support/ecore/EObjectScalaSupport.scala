package fr.unice.i3s.sigma.support.ecore

import org.eclipse.emf.ecore.EObject;

trait EObjectScalaSupport {
  implicit class EObjectScalaSupport(that: EObject) {
    
  }
}

object EObjectScalaSupport extends EObjectScalaSupport
