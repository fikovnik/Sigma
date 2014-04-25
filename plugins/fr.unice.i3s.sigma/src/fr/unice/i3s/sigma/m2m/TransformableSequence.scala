package fr.unice.i3s.sigma.m2m

import org.eclipse.emf.ecore.EObject
import scala.reflect.ClassTag

trait TransformableSequence {
  def transform[A <: EObject : ClassTag]: Traversable[A]
}