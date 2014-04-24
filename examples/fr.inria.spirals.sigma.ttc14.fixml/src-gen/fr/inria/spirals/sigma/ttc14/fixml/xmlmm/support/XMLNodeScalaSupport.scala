package fr.inria.spirals.sigma.ttc14.fixml.xmlmm.support

import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLAttribute;
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait XMLNodeScalaSupport extends EMFScalaSupport {
  type XMLNode = fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode
  
  protected implicit val _xmlnodeProxyBuilder = new EMFProxyBuilder[XMLNode](XMLMM._xmlmmBuilder)
  
  object XMLNode {
    def apply(tag: String = null, subnodes: EList[XMLNode] = null, attributes: EList[XMLAttribute] = null): XMLNode = {
      val _instance = XMLMM._xmlmmBuilder.create[XMLNode]
      
      if (tag != null) _instance.setTag(tag)
      if (subnodes != null) _instance.getSubnodes.addAll(subnodes)
      if (attributes != null) _instance.getAttributes.addAll(attributes)
      
      _instance
    }
    
    def unapply(that: XMLNode): Option[(String,EList[XMLNode],EList[XMLAttribute])] =
      Some((that.getTag,that.getSubnodes,that.getAttributes))
  }
}

object XMLNodeScalaSupport extends XMLNodeScalaSupport
