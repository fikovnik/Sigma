package fr.unice.i3s.sigma.support

import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.EObject

class PostponedInitizationAdapter[T <: EObject](val fun: T ⇒ Any) extends AdapterImpl {
  def initialize {
    fun(getTarget.asInstanceOf[T])
    getTarget.eAdapters.remove(this)
  }

  override def isAdapterForType(`type`: Object): Boolean = {
    `type` == classOf[PostponedInitizationAdapter[_]]
  }

}