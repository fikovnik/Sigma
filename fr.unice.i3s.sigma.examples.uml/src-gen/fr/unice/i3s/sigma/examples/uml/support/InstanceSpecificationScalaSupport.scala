package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.ValueSpecification;

trait InstanceSpecificationScalaSupport {
  implicit class InstanceSpecificationScalaSupport(that: InstanceSpecification) {
    def classifier: EList[Classifier] = that.getClassifiers
    def slot: EList[Slot] = that.getSlots
    def specification: ValueSpecification = that.getSpecification
    def specification_=(value: ValueSpecification): Unit = that.setSpecification(value)
  }
}

object InstanceSpecificationScalaSupport extends InstanceSpecificationScalaSupport
