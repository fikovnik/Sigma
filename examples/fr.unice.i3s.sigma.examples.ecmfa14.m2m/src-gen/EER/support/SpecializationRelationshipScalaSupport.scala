package EER.support

import EER.Generalization;
import EER.SpecializationRelationship;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait SpecializationRelationshipScalaSupport extends EMFScalaSupport {
  type SpecializationRelationship = EER.SpecializationRelationship
  
  object SpecializationRelationship {
    def apply(relationship: Generalization = null): SpecializationRelationship = {
      val _instance = EER.EERFactory.eINSTANCE.createSpecializationRelationship
      
      if (relationship != null) _instance.setRelationship(relationship)
      
      _instance
    }
  }
}

object SpecializationRelationshipScalaSupport extends SpecializationRelationshipScalaSupport
