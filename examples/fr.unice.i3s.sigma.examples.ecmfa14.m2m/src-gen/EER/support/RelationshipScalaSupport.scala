package EER.support

import EER.Attribute;
import EER.Exclusion;
import EER.Inclusion;
import EER.Participant;
import EER.Relationship;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait RelationshipScalaSupport extends EMFScalaSupport {
  type Relationship = EER.Relationship
  
  object Relationship {
    def apply(name: String = null, attributes: EList[Attribute] = null, participants: EList[Participant] = null, exclusionConstraints: EList[Exclusion] = null, inclusionConstraints: EList[Inclusion] = null): Relationship = {
      val _instance = EER.EERFactory.eINSTANCE.createRelationship
      
      if (name != null) _instance.setName(name)
      if (attributes != null) _instance.getAttributes.addAll(attributes)
      if (participants != null) _instance.getParticipants.addAll(participants)
      if (exclusionConstraints != null) _instance.getExclusionConstraints.addAll(exclusionConstraints)
      if (inclusionConstraints != null) _instance.getInclusionConstraints.addAll(inclusionConstraints)
      
      _instance
    }
  }
}

object RelationshipScalaSupport extends RelationshipScalaSupport
