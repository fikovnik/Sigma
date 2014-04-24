package fr.inria.spirals.sigma.ttc14.fixml.xmlmm.support

import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLAttribute;
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLMMPackage;
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.XMLNode;

import fr.unice.i3s.sigma.support.EMFBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;
import fr.unice.i3s.sigma.support.SigmaEcorePackage;

import org.eclipse.emf.common.util.EList;


trait XMLMM
  extends EMFScalaSupport {
    
    implicit class XMLNode2Sigma(that: XMLNode) {
      def tag: String = that.getTag
      def tag_=(value: String): Unit = that.setTag(value)
      def subnodes: EList[XMLNode] = that.getSubnodes
      def attributes: EList[XMLAttribute] = that.getAttributes
    }
    
    implicit class XMLAttribute2Sigma(that: XMLAttribute) {
      def name: String = that.getName
      def name_=(value: String): Unit = that.setName(value)
      def value: String = that.getValue
      def value_=(value: String): Unit = that.setValue(value)
    }
    
    
    object _xmlmm extends SigmaEcorePackage[XMLMMPackage] with
      XMLNodeScalaSupport with
      XMLAttributeScalaSupport {
      
      val ePackage = XMLMMPackage.eINSTANCE
    }
  }

object XMLMM extends XMLMM {
  private[this] val ePackage = XMLMMPackage.eINSTANCE
  
  protected[support] val _xmlmmBuilder = new EMFBuilder(ePackage)
}
