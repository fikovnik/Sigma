package org.eclipse.emf.ecore.scala

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

trait EStructuralFeatureScalaSupport {
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
