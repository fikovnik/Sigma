package EER.support

import EER.Domain;
import EER.SingleAttribute;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait SingleAttributeScalaSupport extends EMFScalaSupport {
  type SingleAttribute = EER.SingleAttribute
  
  protected implicit val _singleattributeProxyBuilder = new EMFProxyBuilder[SingleAttribute](EERPackageScalaSupport._eerBuilder)
  
  object SingleAttribute {
    def apply(name: String = null, nullable: Boolean = false, derivate: Boolean = false, domain: Domain = null, multiplicity: Int = 1): SingleAttribute = {
      val _instance = EERPackageScalaSupport._eerBuilder.create[SingleAttribute]
      
      if (name != null) _instance.setName(name)
      if (nullable != false) _instance.setNullable(nullable)
      if (derivate != false) _instance.setDerivate(derivate)
      if (domain != null) _instance.setDomain(domain)
      if (multiplicity != 1) _instance.setMultiplicity(multiplicity)
      
      _instance
    }
  }
}

object SingleAttributeScalaSupport extends SingleAttributeScalaSupport
