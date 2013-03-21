package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.ValueSpecification;

trait SlotScalaSupport {
  implicit class SlotScalaSupport(that: Slot) {
    def definingFeature: StructuralFeature = that.getDefiningFeature
    def definingFeature_=(value: StructuralFeature): Unit = that.setDefiningFeature(value)
    def value: EList[ValueSpecification] = that.getValues
    def owningInstance: InstanceSpecification = that.getOwningInstance
    def owningInstance_=(value: InstanceSpecification): Unit = that.setOwningInstance(value)
  }
}

object SlotScalaSupport extends SlotScalaSupport
