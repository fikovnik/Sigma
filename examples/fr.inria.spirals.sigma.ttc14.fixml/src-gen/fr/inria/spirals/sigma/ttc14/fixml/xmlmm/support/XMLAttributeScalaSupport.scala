package fr.inria.spirals.sigma.ttc14.fixml.xmlmm.support

import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLAttribute;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait XMLAttributeScalaSupport extends EMFScalaSupport {
  type XMLAttribute = fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLAttribute
  
  protected implicit val _xmlattributeProxyBuilder = new EMFProxyBuilder[XMLAttribute](XMLMM._xmlmmBuilder)
  
  object XMLAttribute {
    def apply(name: String = null, value: String = null): XMLAttribute = {
      val _instance = XMLMM._xmlmmBuilder.create[XMLAttribute]
      
      if (name != null) _instance.setName(name)
      if (value != null) _instance.setValue(value)
      
      _instance
    }
    
    def unapply(that: XMLAttribute): Option[(String,String)] =
      Some((that.getName,that.getValue))
  }
}

object XMLAttributeScalaSupport extends XMLAttributeScalaSupport
