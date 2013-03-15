package org.eclipse.emf.ecore.scala

import org.eclipse.emf.ecore.EObject;

trait EObjectScalaSupport {
  implicit class EObjectScalaSupport(that: EObject) {
    
  }
}

object EObjectScalaSupport extends EObjectScalaSupport
