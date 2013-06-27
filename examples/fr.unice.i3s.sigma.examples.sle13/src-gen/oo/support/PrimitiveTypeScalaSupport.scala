package oo.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import oo.PrimitiveType;
import oo.Stereotype;

import org.eclipse.emf.common.util.EList;

trait PrimitiveTypeScalaSupport extends EMFScalaSupport {
  type PrimitiveType = oo.PrimitiveType
  
  protected implicit val _primitivetypeProxyBuilder = new EMFProxyBuilder[PrimitiveType](OOPackageScalaSupport._ooBuilder)
  
  object PrimitiveType {
    def apply(stereotypes: EList[Stereotype] = null, name: String = null): PrimitiveType = {
      val instance = OOPackageScalaSupport._ooBuilder.create[PrimitiveType]
      
      if (stereotypes != null) instance.getStereotypes.addAll(stereotypes)
      if (name != null) instance.setName(name)
      
      instance
    }
    
    def unapply(that: PrimitiveType): Option[(EList[Stereotype],String)] =
      Some((that.getStereotypes,that.getName))
  }
}

object PrimitiveTypeScalaSupport extends PrimitiveTypeScalaSupport
