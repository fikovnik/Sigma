package oo.support
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import oo.ModelElement;
import oo.Stereotype;



trait ModelElementScalaSupport extends EMFScalaSupport {
  type ModelElement = oo.ModelElement
  
  object ModelElement {
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
