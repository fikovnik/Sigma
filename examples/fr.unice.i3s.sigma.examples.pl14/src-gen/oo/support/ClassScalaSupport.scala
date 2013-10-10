package oo.support
import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import oo.Feature;
import oo.Operation;
import oo.Property;
import oo.Stereotype;



trait ClassScalaSupport extends EMFScalaSupport {
  type Class = oo.Class
  
  protected implicit val _classProxyBuilder = new EMFProxyBuilder[Class](OOPackageScalaSupport._ooBuilder)
  
  object Class {
    def apply(stereotypes: EList[Stereotype] = null, name: String = null, abstract_ : Boolean = false, features: EList[Feature] = null): Class = {
      val _instance = OOPackageScalaSupport._ooBuilder.create[Class]
      
      if (stereotypes != null) _instance.getStereotypes.addAll(stereotypes)
      if (name != null) _instance.setName(name)
      if (abstract_  != false) _instance.setAbstract(abstract_ )
      if (features != null) _instance.getFeatures.addAll(features)
      
      _instance
    }
    
    def unapply(that: Class): Option[(EList[Stereotype],String,Boolean,EList[Property],EList[Operation],EList[Feature])] =
      Some((that.getStereotypes,that.getName,that.isAbstract,that.getProperties,that.getOperations,that.getFeatures))
  }
  
  implicit class ClassScalaSupport(that: oo.Class) {
    def abstract_ : Boolean = that.isAbstract
    def abstract__=(value: Boolean): Unit = that.setAbstract(value)
    def properties: EList[Property] = that.getProperties
    def operations: EList[Operation] = that.getOperations
    def features: EList[Feature] = that.getFeatures
  }
}

object ClassScalaSupport extends ClassScalaSupport
