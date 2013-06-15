package uml.support

import org.eclipse.emf.common.util.EList;

import uml.ModelElement;
import uml.Stereotype;

trait ModelElementScalaSupport {
  type ModelElement = uml.ModelElement
  
  object ModelElement {
    def apply(name: String = null, stereotypes: EList[Stereotype] = null): ModelElement = {
      val instance = UmlPackageScalaSupport.builder.create[ModelElement]
      
      if (name != null) instance.setName(name)
      if (stereotypes != null) instance.getStereotypes.addAll(stereotypes)
      
      instance
    }
    
    def unapply(that: ModelElement): Option[(String,EList[Stereotype])] =
      Some((that.getName,that.getStereotypes))
  }
  
  implicit class ModelElementScalaSupport(that: ModelElement) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
    def stereotypes: EList[Stereotype] = that.getStereotypes
  }
}

object ModelElementScalaSupport extends ModelElementScalaSupport
