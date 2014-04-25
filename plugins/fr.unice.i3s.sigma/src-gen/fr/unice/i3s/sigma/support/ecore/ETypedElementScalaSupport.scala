package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.ecore.ETypedElement;

trait ETypedElementScalaSupport extends EMFScalaSupport {
  type ETypedElement = org.eclipse.emf.ecore.ETypedElement
  
  object ETypedElement {
  }
}

object ETypedElementScalaSupport extends ETypedElementScalaSupport
