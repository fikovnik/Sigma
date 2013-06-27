package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.ValueSpecification;

trait MultiplicityElementScalaSupport extends EMFScalaSupport {
  type MultiplicityElement = org.eclipse.uml2.uml.MultiplicityElement
  
  protected implicit val _multiplicityelementProxyBuilder = new EMFProxyBuilder[MultiplicityElement](UMLPackageScalaSupport._umlBuilder)
  
  object MultiplicityElement {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, isOrdered: Boolean = false, isUnique: Boolean = true, lowerValue: ValueSpecification = null, upperValue: ValueSpecification = null): MultiplicityElement = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[MultiplicityElement]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (isOrdered != false) _instance.setIsOrdered(isOrdered)
      if (isUnique != true) _instance.setIsUnique(isUnique)
      if (lowerValue != null) _instance.setLowerValue(lowerValue)
      if (upperValue != null) _instance.setUpperValue(upperValue)
      
      _instance
    }
  }
  
  implicit class MultiplicityElementScalaSupport(that: MultiplicityElement) {
    def isOrdered: Boolean = that.isOrdered
    def isOrdered_=(value: Boolean): Unit = that.setIsOrdered(value)
    def isUnique: Boolean = that.isUnique
    def isUnique_=(value: Boolean): Unit = that.setIsUnique(value)
    def lower: Int = that.getLower
    def lower_=(value: Int): Unit = that.setLower(value)
    def lowerValue: ValueSpecification = that.getLowerValue
    def lowerValue_=(value: ValueSpecification): Unit = that.setLowerValue(value)
    def upper: Int = that.getUpper
    def upper_=(value: Int): Unit = that.setUpper(value)
    def upperValue: ValueSpecification = that.getUpperValue
    def upperValue_=(value: ValueSpecification): Unit = that.setUpperValue(value)
  }
}

object MultiplicityElementScalaSupport extends MultiplicityElementScalaSupport
