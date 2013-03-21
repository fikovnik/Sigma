package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.ValueSpecification;

trait MultiplicityElementScalaSupport {
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
