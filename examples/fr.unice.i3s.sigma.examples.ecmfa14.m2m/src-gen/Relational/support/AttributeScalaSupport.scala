package Relational.support

import Relational.Attribute;
import Relational.AttributeType;
import Relational.Domain;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait AttributeScalaSupport extends EMFScalaSupport {
  type Attribute = Relational.Attribute
  
  object Attribute {
    def apply(name: String = null, type_ : AttributeType = AttributeType.SIMPLE, nullable: Boolean = false, domain: Domain = null, multiplicity: Int = 1): Attribute = {
      val _instance = Relational.RelationalFactory.eINSTANCE.createAttribute
      
      if (name != null) _instance.setName(name)
      if (type_  != AttributeType.SIMPLE) _instance.setType(type_ )
      if (nullable != false) _instance.setNullable(nullable)
      if (domain != null) _instance.setDomain(domain)
      if (multiplicity != 1) _instance.setMultiplicity(multiplicity)
      
      _instance
    }
  }
}

object AttributeScalaSupport extends AttributeScalaSupport
