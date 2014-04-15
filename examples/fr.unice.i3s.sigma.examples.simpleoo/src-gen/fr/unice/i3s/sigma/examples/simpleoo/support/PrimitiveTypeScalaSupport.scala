package fr.unice.i3s.sigma.examples.simpleoo.support

import fr.unice.i3s.sigma.examples.simpleoo.PrimitiveType;
import fr.unice.i3s.sigma.examples.simpleoo.Stereotype;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait PrimitiveTypeScalaSupport extends EMFScalaSupport {
  type PrimitiveType = fr.unice.i3s.sigma.examples.simpleoo.PrimitiveType
  
  protected implicit val _primitivetypeProxyBuilder = new EMFProxyBuilder[PrimitiveType](SimpleooPackageScalaSupport._simpleooBuilder)
  
  object PrimitiveType {
    def apply(stereotypes: EList[Stereotype] = null, name: String = null): PrimitiveType = {
      val _instance = SimpleooPackageScalaSupport._simpleooBuilder.create[PrimitiveType]
      
      if (stereotypes != null) _instance.getStereotypes.addAll(stereotypes)
      if (name != null) _instance.setName(name)
      
      _instance
    }
  }
}

object PrimitiveTypeScalaSupport extends PrimitiveTypeScalaSupport
