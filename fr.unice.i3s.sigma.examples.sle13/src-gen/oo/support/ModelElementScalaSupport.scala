package oo.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import oo.ModelElement;
import oo.Stereotype;

import org.eclipse.emf.common.util.EList;

trait ModelElementScalaSupport extends EMFScalaSupport {
  type ModelElement = oo.ModelElement
  
  protected implicit val _modelelementProxyBuilder = new EMFProxyBuilder[ModelElement](OOPackageScalaSupport._ooBuilder)
  
  object ModelElement {
    def apply(stereotypes: EList[Stereotype] = null, name: String = null): ModelElement = {
      val instance = OOPackageScalaSupport._ooBuilder.create[ModelElement]
      
      if (stereotypes != null) instance.getStereotypes.addAll(stereotypes)
      if (name != null) instance.setName(name)
      
      instance
    }
    
    def unapply(that: ModelElement): Option[(EList[Stereotype],String)] =
      Some((that.getStereotypes,that.getName))
  }
  
  implicit class ModelElementScalaSupport(that: ModelElement) {
    def stereotypes: EList[Stereotype] = that.getStereotypes
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
  }
}

object ModelElementScalaSupport extends ModelElementScalaSupport
