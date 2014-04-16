package EER.support

import EER.Exclusion;
import EER.Relationship;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ExclusionScalaSupport extends EMFScalaSupport {
  type Exclusion = EER.Exclusion
  
  protected implicit val _exclusionProxyBuilder = new EMFProxyBuilder[Exclusion](EERPackageScalaSupport._eerBuilder)
  
  object Exclusion {
    def apply(name: String = null, target: Relationship = null): Exclusion = {
      val _instance = EERPackageScalaSupport._eerBuilder.create[Exclusion]
      
      if (name != null) _instance.setName(name)
      if (target != null) _instance.setTarget(target)
      
      _instance
    }
  }
}

object ExclusionScalaSupport extends ExclusionScalaSupport
