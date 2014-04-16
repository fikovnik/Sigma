package fr.unice.i3s.sigma.m2m

import scala.reflect.ClassTag
import org.eclipse.emf.ecore.EObject

trait Transformable {
  def transform[A <: EObject : ClassTag]: Option[A] 
}