package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.ecore.ENamedElement;

trait ENamedElementScalaSupport extends EMFScalaSupport {
  type ENamedElement = org.eclipse.emf.ecore.ENamedElement
  
  object ENamedElement {
  }
}

object ENamedElementScalaSupport extends ENamedElementScalaSupport
