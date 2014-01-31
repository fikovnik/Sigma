package EER.support

import EER.Inclusiveness;
import EER.Participant;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait InclusivenessScalaSupport extends EMFScalaSupport {
  type Inclusiveness = EER.Inclusiveness
  
  object Inclusiveness {
    def apply(name: String = null, target: Participant = null, lowerBound: Int = 0, upperBound: Int = 0): Inclusiveness = {
      val _instance = EER.EERFactory.eINSTANCE.createInclusiveness
      
      if (name != null) _instance.setName(name)
      if (target != null) _instance.setTarget(target)
      if (lowerBound != 0) _instance.setLowerBound(lowerBound)
      if (upperBound != 0) _instance.setUpperBound(upperBound)
      
      _instance
    }
  }
}

object InclusivenessScalaSupport extends InclusivenessScalaSupport
