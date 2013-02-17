package fr.unice.i3s.sigma.scala.utils.ecore

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

trait EStructuralFeatureScalaSupport {
  implicit class EStructuralFeatureScalaSupport(obj: EStructuralFeature) {
    def changeable: Boolean = obj.isChangeable
    def changeable_=(value: Boolean): Unit = obj.setChangeable(value)
    def volatile: Boolean = obj.isVolatile
    def volatile_=(value: Boolean): Unit = obj.setVolatile(value)
    def transient: Boolean = obj.isTransient
    def transient_=(value: Boolean): Unit = obj.setTransient(value)
    def defaultValueLiteral: String = obj.getDefaultValueLiteral
    def defaultValueLiteral_=(value: String): Unit = obj.setDefaultValueLiteral(value)
    def defaultValue: Object = obj.getDefaultValue
    def unsettable: Boolean = obj.isUnsettable
    def unsettable_=(value: Boolean): Unit = obj.setUnsettable(value)
    def derived: Boolean = obj.isDerived
    def derived_=(value: Boolean): Unit = obj.setDerived(value)
    def eContainingClass: EClass = obj.getEContainingClass
  }
}

object EStructuralFeatureScalaSupport extends EStructuralFeatureScalaSupport
