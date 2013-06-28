package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EStructuralFeature;

trait EStructuralFeatureScalaSupport extends EMFScalaSupport {
  type EStructuralFeature = org.eclipse.emf.ecore.EStructuralFeature
  
  protected implicit val _estructuralfeatureProxyBuilder = new EMFProxyBuilder[EStructuralFeature](EcorePackageScalaSupport._ecoreBuilder)
  
  object EStructuralFeature {
    def apply(eAnnotations: EList[EAnnotation] = null, name: String = null, ordered: Boolean = true, unique: Boolean = true, lowerBound: Int = 0, upperBound: Int = 1, eType: EClassifier = null, eGenericType: EGenericType = null, changeable: Boolean = true, volatile: Boolean = false, transient: Boolean = false, defaultValueLiteral: String = null, unsettable: Boolean = false, derived: Boolean = false): EStructuralFeature = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[EStructuralFeature]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (name != null) _instance.setName(name)
      if (ordered != true) _instance.setOrdered(ordered)
      if (unique != true) _instance.setUnique(unique)
      if (lowerBound != 0) _instance.setLowerBound(lowerBound)
      if (upperBound != 1) _instance.setUpperBound(upperBound)
      if (eType != null) _instance.setEType(eType)
      if (eGenericType != null) _instance.setEGenericType(eGenericType)
      if (changeable != true) _instance.setChangeable(changeable)
      if (volatile != false) _instance.setVolatile(volatile)
      if (transient != false) _instance.setTransient(transient)
      if (defaultValueLiteral != null) _instance.setDefaultValueLiteral(defaultValueLiteral)
      if (unsettable != false) _instance.setUnsettable(unsettable)
      if (derived != false) _instance.setDerived(derived)
      
      _instance
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
