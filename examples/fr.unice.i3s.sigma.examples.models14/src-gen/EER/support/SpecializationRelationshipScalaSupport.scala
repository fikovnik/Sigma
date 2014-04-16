package EER.support

import EER.Generalization;
import EER.SpecializationRelationship;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait SpecializationRelationshipScalaSupport extends EMFScalaSupport {
  type SpecializationRelationship = EER.SpecializationRelationship
  
  protected implicit val _specializationrelationshipProxyBuilder = new EMFProxyBuilder[SpecializationRelationship](EERPackageScalaSupport._eerBuilder)
  
  object SpecializationRelationship {
    def apply(relationship: Generalization = null): SpecializationRelationship = {
      val _instance = EERPackageScalaSupport._eerBuilder.create[SpecializationRelationship]
      
      if (relationship != null) _instance.setRelationship(relationship)
      
      _instance
    }
  }
}

object SpecializationRelationshipScalaSupport extends SpecializationRelationshipScalaSupport
