package fr.inria.spirals.sigma.ttc14.fixml.xmlmm.impl

import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.support.XMLMM
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLAttribute

class XMLAttributeImplDelegate extends XMLAttributeImpl with XMLAttributeDelegate

trait XMLAttributeDelegate extends XMLAttribute with XMLMM {

  override def toString = this.name + "=" + this.value
  
}