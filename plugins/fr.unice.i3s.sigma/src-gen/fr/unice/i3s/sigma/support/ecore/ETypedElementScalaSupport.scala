package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypedElement;

import scala.Option;

trait ETypedElementScalaSupport extends EMFScalaSupport {
  type ETypedElement = org.eclipse.emf.ecore.ETypedElement
  
  protected implicit val _etypedelementProxyBuilder = new EMFProxyBuilder[ETypedElement](EcorePackageScalaSupport._ecoreBuilder)
  
  object ETypedElement {
    def apply(eAnnotations: EList[EAnnotation] = null, name: String = null, ordered: Boolean = true, unique: Boolean = true, lowerBound: Int = 0, upperBound: Int = 1, eType: EClassifier = null, eGenericType: EGenericType = null): ETypedElement = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[ETypedElement]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (name != null) _instance.setName(name)
      if (ordered != true) _instance.setOrdered(ordered)
      if (unique != true) _instance.setUnique(unique)
      if (lowerBound != 0) _instance.setLowerBound(lowerBound)
      if (upperBound != 1) _instance.setUpperBound(upperBound)
      if (eType != null) _instance.setEType(eType)
      if (eGenericType != null) _instance.setEGenericType(eGenericType)
      
      _instance
    }
  }
  
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
    def eType_=(value: => Option[EClassifier]): Unit =
      that.setEType(EcorePackageScalaSupport._ecoreBuilder.ref(value))
    def eGenericType: EGenericType = that.getEGenericType
    def eGenericType_=(value: EGenericType): Unit = that.setEGenericType(value)
  }
}

object ETypedElementScalaSupport extends ETypedElementScalaSupport
