package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.RemoveVariableValueAction;

trait RemoveVariableValueActionScalaSupport {
  implicit class RemoveVariableValueActionScalaSupport(that: RemoveVariableValueAction) {
    def isRemoveDuplicates: Boolean = that.isRemoveDuplicates
    def isRemoveDuplicates_=(value: Boolean): Unit = that.setIsRemoveDuplicates(value)
    def removeAt: InputPin = that.getRemoveAt
    def removeAt_=(value: InputPin): Unit = that.setRemoveAt(value)
  }
}

object RemoveVariableValueActionScalaSupport extends RemoveVariableValueActionScalaSupport
