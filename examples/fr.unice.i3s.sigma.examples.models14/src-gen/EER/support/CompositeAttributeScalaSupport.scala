package EER.support

import EER.Attribute;
import EER.CompositeAttribute;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait CompositeAttributeScalaSupport extends EMFScalaSupport {
  type CompositeAttribute = EER.CompositeAttribute
  
  protected implicit val _compositeattributeProxyBuilder = new EMFProxyBuilder[CompositeAttribute](EERPackageScalaSupport._eerBuilder)
  
  object CompositeAttribute {
    def apply(name: String = null, nullable: Boolean = false, singlesAttributes: EList[Attribute] = null): CompositeAttribute = {
      val _instance = EERPackageScalaSupport._eerBuilder.create[CompositeAttribute]
      
      if (name != null) _instance.setName(name)
      if (nullable != false) _instance.setNullable(nullable)
      if (singlesAttributes != null) _instance.getSinglesAttributes.addAll(singlesAttributes)
      
      _instance
    }
  }
}

object CompositeAttributeScalaSupport extends CompositeAttributeScalaSupport
