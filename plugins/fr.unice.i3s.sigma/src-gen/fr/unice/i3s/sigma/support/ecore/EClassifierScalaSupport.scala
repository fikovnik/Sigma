package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.ecore.EClassifier;

trait EClassifierScalaSupport extends EMFScalaSupport {
  type EClassifier = org.eclipse.emf.ecore.EClassifier
  
  object EClassifier {
  }
}

object EClassifierScalaSupport extends EClassifierScalaSupport
