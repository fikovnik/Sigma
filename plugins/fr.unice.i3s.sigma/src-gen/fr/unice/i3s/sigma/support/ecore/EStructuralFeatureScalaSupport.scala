package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.ecore.EStructuralFeature;

trait EStructuralFeatureScalaSupport extends EMFScalaSupport {
  type EStructuralFeature = org.eclipse.emf.ecore.EStructuralFeature
  
  object EStructuralFeature {
  }
}

object EStructuralFeatureScalaSupport extends EStructuralFeatureScalaSupport
