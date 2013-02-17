package fr.unice.i3s.sigma.scala.utils.ecore

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypedElement;

trait ETypedElementScalaSupport {
  implicit class ETypedElementScalaSupport(obj: ETypedElement) {
    def ordered: Boolean = obj.isOrdered
    def ordered_=(value: Boolean): Unit = obj.setOrdered(value)
    def unique: Boolean = obj.isUnique
    def unique_=(value: Boolean): Unit = obj.setUnique(value)
    def lowerBound: Int = obj.getLowerBound
    def lowerBound_=(value: Int): Unit = obj.setLowerBound(value)
    def upperBound: Int = obj.getUpperBound
    def upperBound_=(value: Int): Unit = obj.setUpperBound(value)
    def many: Boolean = obj.isMany
    def required: Boolean = obj.isRequired
    def eType: EClassifier = obj.getEType
    def eType_=(value: EClassifier): Unit = obj.setEType(value)
    def eGenericType: EGenericType = obj.getEGenericType
    def eGenericType_=(value: EGenericType): Unit = obj.setEGenericType(value)
  }
}

object ETypedElementScalaSupport extends ETypedElementScalaSupport
