package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

trait EStructuralFeatureScalaSupport extends EMFScalaSupport {
  type EStructuralFeature = org.eclipse.emf.ecore.EStructuralFeature
  
  protected implicit val _estructuralfeatureProxyBuilder = new EMFProxyBuilder[EStructuralFeature](EcorePackageScalaSupport._ecoreBuilder)
  
  object EStructuralFeature {
    def apply(name: String = null, ordered: Boolean = true, unique: Boolean = true, lowerBound: Int = 0, upperBound: Int = 1, changeable: Boolean = true, volatile: Boolean = false, transient: Boolean = false, defaultValueLiteral: String = null, unsettable: Boolean = false, derived: Boolean = false): EStructuralFeature = {
      val instance = EcorePackageScalaSupport._ecoreBuilder.create[EStructuralFeature]
      
      if (name != null) instance.setName(name)
      if (ordered != true) instance.setOrdered(ordered)
      if (unique != true) instance.setUnique(unique)
      if (lowerBound != 0) instance.setLowerBound(lowerBound)
      if (upperBound != 1) instance.setUpperBound(upperBound)
      if (changeable != true) instance.setChangeable(changeable)
      if (volatile != false) instance.setVolatile(volatile)
      if (transient != false) instance.setTransient(transient)
      if (defaultValueLiteral != null) instance.setDefaultValueLiteral(defaultValueLiteral)
      if (unsettable != false) instance.setUnsettable(unsettable)
      if (derived != false) instance.setDerived(derived)
      
      instance
    }
  }
  
  implicit class EStructuralFeatureScalaSupport(that: EStructuralFeature) {
    def changeable: Boolean = that.isChangeable
    def changeable_=(value: Boolean): Unit = that.setChangeable(value)
    def volatile: Boolean = that.isVolatile
    def volatile_=(value: Boolean): Unit = that.setVolatile(value)
    def transient: Boolean = that.isTransient
    def transient_=(value: Boolean): Unit = that.setTransient(value)
    def defaultValueLiteral: String = that.getDefaultValueLiteral
    def defaultValueLiteral_=(value: String): Unit = that.setDefaultValueLiteral(value)
    def defaultValue: Object = that.getDefaultValue
    def unsettable: Boolean = that.isUnsettable
    def unsettable_=(value: Boolean): Unit = that.setUnsettable(value)
    def derived: Boolean = that.isDerived
    def derived_=(value: Boolean): Unit = that.setDerived(value)
    def eContainingClass: EClass = that.getEContainingClass
  }
}

object EStructuralFeatureScalaSupport extends EStructuralFeatureScalaSupport
