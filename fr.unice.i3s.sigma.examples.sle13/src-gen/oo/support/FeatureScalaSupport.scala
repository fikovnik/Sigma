package oo.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import oo.Feature;
import oo.ScopeKind;
import oo.Stereotype;

import org.eclipse.emf.common.util.EList;

trait FeatureScalaSupport extends EMFScalaSupport {
  type Feature = oo.Feature
  
  protected implicit val _featureProxyBuilder = new EMFProxyBuilder[Feature](OOPackageScalaSupport._ooBuilder)
  
  object Feature {
    def apply(stereotypes: EList[Stereotype] = null, name: String = null, ownerScope: ScopeKind = ScopeKind.SK_INSTANCE): Feature = {
      val instance = OOPackageScalaSupport._ooBuilder.create[Feature]
      
      if (stereotypes != null) instance.getStereotypes.addAll(stereotypes)
      if (name != null) instance.setName(name)
      if (ownerScope != ScopeKind.SK_INSTANCE) instance.setOwnerScope(ownerScope)
      
      instance
    }
    
    def unapply(that: Feature): Option[(EList[Stereotype],String,ScopeKind)] =
      Some((that.getStereotypes,that.getName,that.getOwnerScope))
  }
  
  implicit class FeatureScalaSupport(that: Feature) {
    def ownerScope: ScopeKind = that.getOwnerScope
    def ownerScope_=(value: ScopeKind): Unit = that.setOwnerScope(value)
  }
}

object FeatureScalaSupport extends FeatureScalaSupport
