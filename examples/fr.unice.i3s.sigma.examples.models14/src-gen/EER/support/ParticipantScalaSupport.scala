package EER.support

import EER.Entity;
import EER.Exclusive;
import EER.Inclusiveness;
import EER.Participant;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait ParticipantScalaSupport extends EMFScalaSupport {
  type Participant = EER.Participant
  
  protected implicit val _participantProxyBuilder = new EMFProxyBuilder[Participant](EERPackageScalaSupport._eerBuilder)
  
  object Participant {
    def apply(role: String = null, lowerBound: Int = 0, upperBound: Int = 0, target: Entity = null, exclusiveConstraint: EList[Exclusive] = null, inclusivenessConstraint: EList[Inclusiveness] = null): Participant = {
      val _instance = EERPackageScalaSupport._eerBuilder.create[Participant]
      
      if (role != null) _instance.setRole(role)
      if (lowerBound != 0) _instance.setLowerBound(lowerBound)
      if (upperBound != 0) _instance.setUpperBound(upperBound)
      if (target != null) _instance.setTarget(target)
      if (exclusiveConstraint != null) _instance.getExclusiveConstraint.addAll(exclusiveConstraint)
      if (inclusivenessConstraint != null) _instance.getInclusivenessConstraint.addAll(inclusivenessConstraint)
      
      _instance
    }
  }
}

object ParticipantScalaSupport extends ParticipantScalaSupport
