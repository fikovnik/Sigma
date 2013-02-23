package org.eclipse.emf.ecore.scala

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypedElement;

trait ETypedElementScalaSupport {
  implicit class ETypedElementScalaSupport(that: ETypedElement) {
    def ordered: Boolean = that.isOrdered
    def ordered_=(value: Boolean): Unit = that.setOrdered(value)
    def unique: Boolean = that.isUnique
    def unique_=(value: Boolean): Unit = that.setUnique(value)
    def lowerBound: Int = that.getLowerBound
    def lowerBound_=(value: Int): Unit = that.setLowerBound(value)
    def upperBound: Int = that.getUpperBound
    def upperBound_=(value: Int): Unit = that.setUpperBound(value)
    def many: Boolean = that.isMany
    def required: Boolean = that.isRequired
    def eType: EClassifier = that.getEType
    def eType_=(value: EClassifier): Unit = that.setEType(value)
    def eGenericType: EGenericType = that.getEGenericType
    def eGenericType_=(value: EGenericType): Unit = that.setEGenericType(value)
  }
}

object ETypedElementScalaSupport extends ETypedElementScalaSupport
