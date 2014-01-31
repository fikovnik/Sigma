package EER.support

import EER.Exclusive;
import EER.Participant;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ExclusiveScalaSupport extends EMFScalaSupport {
  type Exclusive = EER.Exclusive
  
  object Exclusive {
    def apply(name: String = null, target: Participant = null): Exclusive = {
      val _instance = EER.EERFactory.eINSTANCE.createExclusive
      
      if (name != null) _instance.setName(name)
      if (target != null) _instance.setTarget(target)
      
      _instance
    }
  }
}

object ExclusiveScalaSupport extends ExclusiveScalaSupport
