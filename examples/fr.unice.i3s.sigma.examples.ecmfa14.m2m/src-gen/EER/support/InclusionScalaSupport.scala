package EER.support

import EER.Inclusion;
import EER.Relationship;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait InclusionScalaSupport extends EMFScalaSupport {
  type Inclusion = EER.Inclusion
  
  object Inclusion {
    def apply(name: String = null, target: Relationship = null): Inclusion = {
      val _instance = EER.EERFactory.eINSTANCE.createInclusion
      
      if (name != null) _instance.setName(name)
      if (target != null) _instance.setTarget(target)
      
      _instance
    }
  }
}

object InclusionScalaSupport extends InclusionScalaSupport
