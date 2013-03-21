package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.ObjectNode;

trait ExceptionHandlerScalaSupport {
  implicit class ExceptionHandlerScalaSupport(that: ExceptionHandler) {
    def exceptionInput: ObjectNode = that.getExceptionInput
    def exceptionInput_=(value: ObjectNode): Unit = that.setExceptionInput(value)
    def exceptionType: EList[Classifier] = that.getExceptionTypes
    def handlerBody: ExecutableNode = that.getHandlerBody
    def handlerBody_=(value: ExecutableNode): Unit = that.setHandlerBody(value)
    def protectedNode: ExecutableNode = that.getProtectedNode
    def protectedNode_=(value: ExecutableNode): Unit = that.setProtectedNode(value)
  }
}

object ExceptionHandlerScalaSupport extends ExceptionHandlerScalaSupport
