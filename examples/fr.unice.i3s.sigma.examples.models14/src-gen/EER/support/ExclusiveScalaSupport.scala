package EER.support

import EER.Exclusive;
import EER.Participant;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ExclusiveScalaSupport extends EMFScalaSupport {
  type Exclusive = EER.Exclusive
  
  protected implicit val _exclusiveProxyBuilder = new EMFProxyBuilder[Exclusive](EERPackageScalaSupport._eerBuilder)
  
  object Exclusive {
    def apply(name: String = null, target: Participant = null): Exclusive = {
      val _instance = EERPackageScalaSupport._eerBuilder.create[Exclusive]
      
      if (name != null) _instance.setName(name)
      if (target != null) _instance.setTarget(target)
      
      _instance
    }
  }
}

object ExclusiveScalaSupport extends ExclusiveScalaSupport
