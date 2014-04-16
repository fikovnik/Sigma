package EER.support

import EER.Aggregation;
import EER.AggregationParticipant;
import EER.Entity;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait AggregationScalaSupport extends EMFScalaSupport {
  type Aggregation = EER.Aggregation
  
  protected implicit val _aggregationProxyBuilder = new EMFProxyBuilder[Aggregation](EERPackageScalaSupport._eerBuilder)
  
  object Aggregation {
    def apply(name: String = null, source: Entity = null, participants: EList[AggregationParticipant] = null): Aggregation = {
      val _instance = EERPackageScalaSupport._eerBuilder.create[Aggregation]
      
      if (name != null) _instance.setName(name)
      if (source != null) _instance.setSource(source)
      if (participants != null) _instance.getParticipants.addAll(participants)
      
      _instance
    }
  }
}

object AggregationScalaSupport extends AggregationScalaSupport
