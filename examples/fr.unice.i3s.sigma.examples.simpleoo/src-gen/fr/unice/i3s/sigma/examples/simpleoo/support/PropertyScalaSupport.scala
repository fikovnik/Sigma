package fr.unice.i3s.sigma.examples.simpleoo.support

import fr.unice.i3s.sigma.examples.simpleoo.Classifier;
import fr.unice.i3s.sigma.examples.simpleoo.Property;
import fr.unice.i3s.sigma.examples.simpleoo.ScopeKind;
import fr.unice.i3s.sigma.examples.simpleoo.Stereotype;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait PropertyScalaSupport extends EMFScalaSupport {
  type Property = fr.unice.i3s.sigma.examples.simpleoo.Property
  
  protected implicit val _propertyProxyBuilder = new EMFProxyBuilder[Property](SimpleOO._simpleooBuilder)
  
  object Property {
    def apply(stereotypes: EList[Stereotype] = null, name: String = null, ownerScope: ScopeKind = ScopeKind.SK_INSTANCE, type_ : Classifier = null, multi: Boolean = false): Property = {
      val _instance = SimpleOO._simpleooBuilder.create[Property]
      
      if (stereotypes != null) _instance.getStereotypes.addAll(stereotypes)
      if (name != null) _instance.setName(name)
      if (ownerScope != ScopeKind.SK_INSTANCE) _instance.setOwnerScope(ownerScope)
      if (type_  != null) _instance.setType(type_ )
      if (multi != false) _instance.setMulti(multi)
      
      _instance
    }
  }
}

object PropertyScalaSupport extends PropertyScalaSupport
