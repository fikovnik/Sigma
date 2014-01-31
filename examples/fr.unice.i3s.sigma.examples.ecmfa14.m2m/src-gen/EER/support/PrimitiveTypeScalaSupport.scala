package EER.support

import EER.PrimitiveType;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait PrimitiveTypeScalaSupport extends EMFScalaSupport {
  type PrimitiveType = EER.PrimitiveType
  
  object PrimitiveType {
    def apply(name: String = null): PrimitiveType = {
      val _instance = EER.EERFactory.eINSTANCE.createPrimitiveType
      
      if (name != null) _instance.setName(name)
      
      _instance
    }
  }
}

object PrimitiveTypeScalaSupport extends PrimitiveTypeScalaSupport
