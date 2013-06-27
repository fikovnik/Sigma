package fr.unice.i3s.sigma.support

import scala.reflect.ClassTag
import org.eclipse.emf.ecore.EObject
import scala.annotation.implicitNotFound

// TODO: make this type safe
@implicitNotFound("No ${T} EMF proxy builder available")
class EMFProxyBuilder[T <: EObject : ClassTag](builder: EMFBuilder[_]) {
  
  def apply(proxy: => Option[T]) = builder.ref(proxy)
  
}