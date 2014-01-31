package EER.support

import EER.Attribute;
import EER.CandidateKey;
import EER.DependencyRelationship;
import EER.Entity;
import EER.GeneralizationRelationship;
import EER.SpecializationRelationship;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait EntityScalaSupport extends EMFScalaSupport {
  type Entity = EER.Entity
  
  object Entity {
    def apply(name: String = null, attributes: EList[Attribute] = null, primaryKey: CandidateKey = null, candidateKey: EList[CandidateKey] = null, dependencyRelationships: EList[DependencyRelationship] = null, isSpecializedBy: EList[SpecializationRelationship] = null, specializes: EList[GeneralizationRelationship] = null): Entity = {
      val _instance = EER.EERFactory.eINSTANCE.createEntity
      
      if (name != null) _instance.setName(name)
      if (attributes != null) _instance.getAttributes.addAll(attributes)
      if (primaryKey != null) _instance.setPrimaryKey(primaryKey)
      if (candidateKey != null) _instance.getCandidateKey.addAll(candidateKey)
      if (dependencyRelationships != null) _instance.getDependencyRelationships.addAll(dependencyRelationships)
      if (isSpecializedBy != null) _instance.getIsSpecializedBy.addAll(isSpecializedBy)
      if (specializes != null) _instance.getSpecializes.addAll(specializes)
      
      _instance
    }
  }
}

object EntityScalaSupport extends EntityScalaSupport
