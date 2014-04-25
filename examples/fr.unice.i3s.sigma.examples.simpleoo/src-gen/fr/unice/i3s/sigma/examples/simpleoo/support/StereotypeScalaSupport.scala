package fr.unice.i3s.sigma.examples.simpleoo.support

import fr.unice.i3s.sigma.examples.simpleoo.Stereotype;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait StereotypeScalaSupport extends EMFScalaSupport {
  type Stereotype = fr.unice.i3s.sigma.examples.simpleoo.Stereotype
  
  protected implicit val _stereotypeProxyBuilder = new EMFProxyBuilder[Stereotype](SimpleooPackageScalaSupport._simpleooBuilder)
  
  object Stereotype {
    def apply(name: String = null): Stereotype = {
      val _instance = SimpleooPackageScalaSupport._simpleooBuilder.create[Stereotype]
      
      if (name != null) _instance.setName(name)
      
      _instance
    }
  }
}

object StereotypeScalaSupport extends StereotypeScalaSupport
