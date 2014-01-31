package EER.support

import EER.Generalization;
import EER.GeneralizationRelationship;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait GeneralizationRelationshipScalaSupport extends EMFScalaSupport {
  type GeneralizationRelationship = EER.GeneralizationRelationship
  
  object GeneralizationRelationship {
    def apply(relationship: Generalization = null): GeneralizationRelationship = {
      val _instance = EER.EERFactory.eINSTANCE.createGeneralizationRelationship
      
      if (relationship != null) _instance.setRelationship(relationship)
      
      _instance
    }
  }
}

object GeneralizationRelationshipScalaSupport extends GeneralizationRelationshipScalaSupport
