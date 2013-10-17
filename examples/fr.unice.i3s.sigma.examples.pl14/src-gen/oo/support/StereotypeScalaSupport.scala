package oo.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import oo.Stereotype;

trait StereotypeScalaSupport extends EMFScalaSupport {
  type Stereotype = oo.Stereotype
  
  protected implicit val _stereotypeProxyBuilder = new EMFProxyBuilder[Stereotype](OOPackageScalaSupport._ooBuilder)
  
  object Stereotype {
    def apply(name: String = null): Stereotype = {
      val _instance = OOPackageScalaSupport._ooBuilder.create[Stereotype]
      
      if (name != null) _instance.setName(name)
      
      _instance
    }
    
    def unapply(that: Stereotype): Option[(String)] =
      Some((that.getName))
  }
  
  implicit class StereotypeScalaSupport(that: Stereotype) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
  }
}

object StereotypeScalaSupport extends StereotypeScalaSupport
