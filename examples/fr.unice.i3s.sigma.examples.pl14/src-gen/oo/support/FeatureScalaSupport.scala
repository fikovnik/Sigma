package oo.support

import fr.unice.i3s.sigma.support.EMFScalaSupport;

import oo.Feature;
import oo.ScopeKind;
import oo.Stereotype;

import org.eclipse.emf.common.util.EList;

trait FeatureScalaSupport extends EMFScalaSupport {
  type Feature = oo.Feature
  
  object Feature {
    def unapply(that: Feature): Option[(EList[Stereotype],String,ScopeKind)] =
      Some((that.getStereotypes,that.getName,that.getOwnerScope))
  }
  
  implicit class FeatureScalaSupport(that: Feature) {
    def ownerScope: ScopeKind = that.getOwnerScope
    def ownerScope_=(value: ScopeKind): Unit = that.setOwnerScope(value)
  }
}

object FeatureScalaSupport extends FeatureScalaSupport
