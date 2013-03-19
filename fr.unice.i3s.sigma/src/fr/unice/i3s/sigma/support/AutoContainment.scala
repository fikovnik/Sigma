package fr.unice.i3s.sigma.support

import scala.collection.JavaConversions._
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import fr.unice.i3s.sigma.internal.DynamicContainer
import scala.reflect.runtime.universe.TypeTag

object AutoContainment {

  private[this] val container = new DynamicContainer

  implicit class InitializableEList[T <: EObject: TypeTag](val that: EList[T]) {
    def apply(fun: ⇒ Unit): EList[T] = {
      container.withValue(that) { fun }
      that
    }
  }

  /**
   * Sets the containment in the current container if it has the correct type
   */
  protected[support] def contained[T <: EObject: TypeTag](instance: T): T = {
    if (container.isCompatible[T]) {
      container += instance
    }

    instance
  }

}