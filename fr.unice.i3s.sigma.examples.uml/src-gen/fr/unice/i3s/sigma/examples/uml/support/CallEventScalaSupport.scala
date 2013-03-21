package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Operation;

trait CallEventScalaSupport {
  implicit class CallEventScalaSupport(that: CallEvent) {
    def operation: Operation = that.getOperation
    def operation_=(value: Operation): Unit = that.setOperation(value)
  }
}

object CallEventScalaSupport extends CallEventScalaSupport
