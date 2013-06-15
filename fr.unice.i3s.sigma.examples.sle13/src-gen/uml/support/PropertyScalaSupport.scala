package uml.support

import org.eclipse.emf.common.util.EList;

import scala.Option;

import uml.Classifier;
import uml.Property;
import uml.ScopeKind;
import uml.Stereotype;

trait PropertyScalaSupport {
  type Property = uml.Property
  
  object Property {
    def apply(name: String = null, stereotypes: EList[Stereotype] = null, ownerScope: ScopeKind = ScopeKind.SK_INSTANCE, `type`: Classifier = null, multi: Boolean = false): Property = {
      val instance = UmlPackageScalaSupport.builder.create[Property]
      
      if (name != null) instance.setName(name)
      if (stereotypes != null) instance.getStereotypes.addAll(stereotypes)
      if (ownerScope != ScopeKind.SK_INSTANCE) instance.setOwnerScope(ownerScope)
      if (`type` != null) instance.setType(`type`)
      if (multi != false) instance.setMulti(multi)
      
      instance
    }
    
    def unapply(that: Property): Option[(String,EList[Stereotype],ScopeKind,Classifier,Boolean)] =
      Some((that.getName,that.getStereotypes,that.getOwnerScope,that.getType,that.isMulti))
  }
  
  implicit class PropertyScalaSupport(that: Property) {
    def `type`: Classifier = that.getType
    def type_=(value: Classifier): Unit = that.setType(value)
    def type_=(value: ⇒ Option[Classifier]): Unit =
      that.setType(UmlPackageScalaSupport.builder.ref(value))
    def multi: Boolean = that.isMulti
    def multi_=(value: Boolean): Unit = that.setMulti(value)
  }
}

object PropertyScalaSupport extends PropertyScalaSupport
