package fr.unice.i3s.sigma.support

import org.eclipse.emf.ecore.EPackage

trait SigmaEcorePackage[T <: EPackage] {

  def ePackage: T
  
}