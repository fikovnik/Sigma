package EER.support

import EER.Attribute;
import EER.Generalization;
import EER.GeneralizationRelationship;
import EER.GeneralizationType;
import EER.SpecializationRelationship;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait GeneralizationScalaSupport extends EMFScalaSupport {
  type Generalization = EER.Generalization
  
  protected implicit val _generalizationProxyBuilder = new EMFProxyBuilder[Generalization](EERPackageScalaSupport._eerBuilder)
  
  object Generalization {
    def apply(name: String = null, parent: SpecializationRelationship = null, childs: EList[GeneralizationRelationship] = null, attribute: Attribute = null, type_ : GeneralizationType = GeneralizationType.TOTAL_OVERLAPPING): Generalization = {
      val _instance = EERPackageScalaSupport._eerBuilder.create[Generalization]
      
      if (name != null) _instance.setName(name)
      if (parent != null) _instance.setParent(parent)
      if (childs != null) _instance.getChilds.addAll(childs)
      if (attribute != null) _instance.setAttribute(attribute)
      if (type_  != GeneralizationType.TOTAL_OVERLAPPING) _instance.setType(type_ )
      
      _instance
    }
  }
}

object GeneralizationScalaSupport extends GeneralizationScalaSupport
