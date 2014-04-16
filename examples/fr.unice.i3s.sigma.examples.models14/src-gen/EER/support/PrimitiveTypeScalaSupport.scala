package EER.support

import EER.PrimitiveType;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait PrimitiveTypeScalaSupport extends EMFScalaSupport {
  type PrimitiveType = EER.PrimitiveType
  
  protected implicit val _primitivetypeProxyBuilder = new EMFProxyBuilder[PrimitiveType](EERPackageScalaSupport._eerBuilder)
  
  object PrimitiveType {
    def apply(name: String = null): PrimitiveType = {
      val _instance = EERPackageScalaSupport._eerBuilder.create[PrimitiveType]
      
      if (name != null) _instance.setName(name)
      
      _instance
    }
  }
}

object PrimitiveTypeScalaSupport extends PrimitiveTypeScalaSupport
