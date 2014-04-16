package EER.support

import EER.AggregationParticipant;
import EER.Node;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait AggregationParticipantScalaSupport extends EMFScalaSupport {
  type AggregationParticipant = EER.AggregationParticipant
  
  protected implicit val _aggregationparticipantProxyBuilder = new EMFProxyBuilder[AggregationParticipant](EERPackageScalaSupport._eerBuilder)
  
  object AggregationParticipant {
    def apply(role: String = null, lowerBound: Int = 0, upperBound: Int = 0, target: Node = null): AggregationParticipant = {
      val _instance = EERPackageScalaSupport._eerBuilder.create[AggregationParticipant]
      
      if (role != null) _instance.setRole(role)
      if (lowerBound != 0) _instance.setLowerBound(lowerBound)
      if (upperBound != 0) _instance.setUpperBound(upperBound)
      if (target != null) _instance.setTarget(target)
      
      _instance
    }
  }
}

object AggregationParticipantScalaSupport extends AggregationParticipantScalaSupport
