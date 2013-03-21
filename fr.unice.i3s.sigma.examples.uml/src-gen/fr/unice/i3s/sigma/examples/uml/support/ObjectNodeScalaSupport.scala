package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.ObjectNodeOrderingKind;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.ValueSpecification;

trait ObjectNodeScalaSupport {
  implicit class ObjectNodeScalaSupport(that: ObjectNode) {
    def inState: EList[State] = that.getInStates
    def isControlType: Boolean = that.isControlType
    def isControlType_=(value: Boolean): Unit = that.setIsControlType(value)
    def ordering: ObjectNodeOrderingKind = that.getOrdering
    def ordering_=(value: ObjectNodeOrderingKind): Unit = that.setOrdering(value)
    def selection: Behavior = that.getSelection
    def selection_=(value: Behavior): Unit = that.setSelection(value)
    def upperBound: ValueSpecification = that.getUpperBound
    def upperBound_=(value: ValueSpecification): Unit = that.setUpperBound(value)
  }
}

object ObjectNodeScalaSupport extends ObjectNodeScalaSupport
