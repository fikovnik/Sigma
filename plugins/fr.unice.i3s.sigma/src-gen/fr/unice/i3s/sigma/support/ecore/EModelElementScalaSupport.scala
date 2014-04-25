package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.ecore.EModelElement;

trait EModelElementScalaSupport extends EMFScalaSupport {
  type EModelElement = org.eclipse.emf.ecore.EModelElement
  
  object EModelElement {
  }
}

object EModelElementScalaSupport extends EModelElementScalaSupport
