package uml.support

import org.eclipse.emf.common.util.EList;

import uml.Feature;
import uml.ScopeKind;
import uml.Stereotype;

trait FeatureScalaSupport {
  type Feature = uml.Feature
  
  object Feature {
    def apply(name: String = null, stereotypes: EList[Stereotype] = null, ownerScope: ScopeKind = ScopeKind.SK_INSTANCE): Feature = {
      val instance = UmlPackageScalaSupport.builder.create[Feature]
      
      if (name != null) instance.setName(name)
      if (stereotypes != null) instance.getStereotypes.addAll(stereotypes)
      if (ownerScope != ScopeKind.SK_INSTANCE) instance.setOwnerScope(ownerScope)
      
      instance
    }
    
    def unapply(that: Feature): Option[(String,EList[Stereotype],ScopeKind)] =
      Some((that.getName,that.getStereotypes,that.getOwnerScope))
  }
  
  implicit class FeatureScalaSupport(that: Feature) {
    def ownerScope: ScopeKind = that.getOwnerScope
    def ownerScope_=(value: ScopeKind): Unit = that.setOwnerScope(value)
  }
}

object FeatureScalaSupport extends FeatureScalaSupport
