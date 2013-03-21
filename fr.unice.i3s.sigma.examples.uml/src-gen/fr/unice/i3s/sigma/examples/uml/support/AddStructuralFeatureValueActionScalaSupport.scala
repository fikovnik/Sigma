package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
import org.eclipse.uml2.uml.InputPin;

trait AddStructuralFeatureValueActionScalaSupport {
  implicit class AddStructuralFeatureValueActionScalaSupport(that: AddStructuralFeatureValueAction) {
    def insertAt: InputPin = that.getInsertAt
    def insertAt_=(value: InputPin): Unit = that.setInsertAt(value)
    def isReplaceAll: Boolean = that.isReplaceAll
    def isReplaceAll_=(value: Boolean): Unit = that.setIsReplaceAll(value)
  }
}

object AddStructuralFeatureValueActionScalaSupport extends AddStructuralFeatureValueActionScalaSupport
