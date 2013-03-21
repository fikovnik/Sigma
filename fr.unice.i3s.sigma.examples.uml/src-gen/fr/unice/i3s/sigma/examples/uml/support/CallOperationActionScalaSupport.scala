package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.Operation;

trait CallOperationActionScalaSupport {
  implicit class CallOperationActionScalaSupport(that: CallOperationAction) {
    def operation: Operation = that.getOperation
    def operation_=(value: Operation): Unit = that.setOperation(value)
    def target: InputPin = that.getTarget
    def target_=(value: InputPin): Unit = that.setTarget(value)
  }
}

object CallOperationActionScalaSupport extends CallOperationActionScalaSupport
