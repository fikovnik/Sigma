package EER.support

import EER.Generalization;
import EER.GeneralizationRelationship;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait GeneralizationRelationshipScalaSupport extends EMFScalaSupport {
  type GeneralizationRelationship = EER.GeneralizationRelationship
  
  protected implicit val _generalizationrelationshipProxyBuilder = new EMFProxyBuilder[GeneralizationRelationship](EERPackageScalaSupport._eerBuilder)
  
  object GeneralizationRelationship {
    def apply(relationship: Generalization = null): GeneralizationRelationship = {
      val _instance = EERPackageScalaSupport._eerBuilder.create[GeneralizationRelationship]
      
      if (relationship != null) _instance.setRelationship(relationship)
      
      _instance
    }
  }
}

object GeneralizationRelationshipScalaSupport extends GeneralizationRelationshipScalaSupport
