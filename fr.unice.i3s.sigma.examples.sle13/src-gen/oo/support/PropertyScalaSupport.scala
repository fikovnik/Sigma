package oo.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import oo.Classifier;
import oo.Property;
import oo.ScopeKind;
import oo.Stereotype;

import org.eclipse.emf.common.util.EList;

import scala.Option;

trait PropertyScalaSupport extends EMFScalaSupport {
  type Property = oo.Property
  
  protected implicit val _propertyProxyBuilder = new EMFProxyBuilder[Property](OOPackageScalaSupport._ooBuilder)
  
  object Property {
    def apply(stereotypes: EList[Stereotype] = null, name: String = null, ownerScope: ScopeKind = ScopeKind.SK_INSTANCE, type_ : Classifier = null, multi: Boolean = false): Property = {
      val instance = OOPackageScalaSupport._ooBuilder.create[Property]
      
      if (stereotypes != null) instance.getStereotypes.addAll(stereotypes)
      if (name != null) instance.setName(name)
      if (ownerScope != ScopeKind.SK_INSTANCE) instance.setOwnerScope(ownerScope)
      if (type_  != null) instance.setType(type_ )
      if (multi != false) instance.setMulti(multi)
      
      instance
    }
    
    def unapply(that: Property): Option[(EList[Stereotype],String,ScopeKind,Classifier,Boolean)] =
      Some((that.getStereotypes,that.getName,that.getOwnerScope,that.getType,that.isMulti))
  }
  
  implicit class PropertyScalaSupport(that: Property) {
    def type_ : Classifier = that.getType
    def type__=(value: Classifier): Unit = that.setType(value)
    def type__=(value: ⇒ Option[Classifier]): Unit =
      that.setType(OOPackageScalaSupport._ooBuilder.ref(value))
    def multi: Boolean = that.isMulti
    def multi_=(value: Boolean): Unit = that.setMulti(value)
  }
}

object PropertyScalaSupport extends PropertyScalaSupport
