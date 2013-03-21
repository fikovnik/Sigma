package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.AddVariableValueAction;
import org.eclipse.uml2.uml.InputPin;

trait AddVariableValueActionScalaSupport {
  implicit class AddVariableValueActionScalaSupport(that: AddVariableValueAction) {
    def insertAt: InputPin = that.getInsertAt
    def insertAt_=(value: InputPin): Unit = that.setInsertAt(value)
    def isReplaceAll: Boolean = that.isReplaceAll
    def isReplaceAll_=(value: Boolean): Unit = that.setIsReplaceAll(value)
  }
}

object AddVariableValueActionScalaSupport extends AddVariableValueActionScalaSupport
