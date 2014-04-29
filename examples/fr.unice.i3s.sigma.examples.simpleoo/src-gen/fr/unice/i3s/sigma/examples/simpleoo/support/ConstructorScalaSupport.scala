package fr.unice.i3s.sigma.examples.simpleoo.support

import fr.unice.i3s.sigma.examples.simpleoo.Classifier;
import fr.unice.i3s.sigma.examples.simpleoo.Constructor;
import fr.unice.i3s.sigma.examples.simpleoo.ScopeKind;
import fr.unice.i3s.sigma.examples.simpleoo.Stereotype;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait ConstructorScalaSupport extends EMFScalaSupport {
  type Constructor = fr.unice.i3s.sigma.examples.simpleoo.Constructor
  
  protected implicit val _constructorProxyBuilder = new EMFProxyBuilder[Constructor](SimpleOO._simpleooBuilder)
  
  object Constructor {
    def apply(stereotypes: EList[Stereotype] = null, name: String = null, ownerScope: ScopeKind = ScopeKind.SK_INSTANCE, returnType: Classifier = null): Constructor = {
      val _instance = SimpleOO._simpleooBuilder.create[Constructor]
      
      if (stereotypes != null) _instance.getStereotypes.addAll(stereotypes)
      if (name != null) _instance.setName(name)
      if (ownerScope != ScopeKind.SK_INSTANCE) _instance.setOwnerScope(ownerScope)
      if (returnType != null) _instance.setReturnType(returnType)
      
      _instance
    }
  }
}

object ConstructorScalaSupport extends ConstructorScalaSupport
