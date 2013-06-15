package uml.support

import org.eclipse.emf.common.util.EList;

import uml.PrimitiveType;
import uml.Stereotype;

trait PrimitiveTypeScalaSupport {
  type PrimitiveType = uml.PrimitiveType
  
  object PrimitiveType {
    def apply(name: String = null, stereotypes: EList[Stereotype] = null): PrimitiveType = {
      val instance = UmlPackageScalaSupport.builder.create[PrimitiveType]
      
      if (name != null) instance.setName(name)
      if (stereotypes != null) instance.getStereotypes.addAll(stereotypes)
      
      instance
    }
    
    def unapply(that: PrimitiveType): Option[(String,EList[Stereotype])] =
      Some((that.getName,that.getStereotypes))
  }
  
  implicit class PrimitiveTypeScalaSupport(that: PrimitiveType) {
    }
}

object PrimitiveTypeScalaSupport extends PrimitiveTypeScalaSupport
