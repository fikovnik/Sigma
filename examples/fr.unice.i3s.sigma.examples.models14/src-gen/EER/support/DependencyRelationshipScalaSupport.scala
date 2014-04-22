package EER.support

import EER.Attribute;
import EER.DependencyRelationship;
import EER.DependencyType;
import EER.Participant;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait DependencyRelationshipScalaSupport extends EMFScalaSupport {
  type DependencyRelationship = EER.DependencyRelationship
  
  protected implicit val _dependencyrelationshipProxyBuilder = new EMFProxyBuilder[DependencyRelationship](EERPackageScalaSupport._eerBuilder)
  
  object DependencyRelationship {
    def apply(name: String = null, attributes: EList[Attribute] = null, participants: EList[Participant] = null, type_ : DependencyType = DependencyType.ID): DependencyRelationship = {
      val _instance = EERPackageScalaSupport._eerBuilder.create[DependencyRelationship]
      
      if (name != null) _instance.setName(name)
      if (attributes != null) _instance.getAttributes.addAll(attributes)
      if (participants != null) _instance.getParticipants.addAll(participants)
      if (type_  != DependencyType.ID) _instance.setType(type_ )
      
      _instance
    }
  }
}

object DependencyRelationshipScalaSupport extends DependencyRelationshipScalaSupport