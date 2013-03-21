package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ExecutableNode;

trait ExecutableNodeScalaSupport {
  implicit class ExecutableNodeScalaSupport(that: ExecutableNode) {
    def handler: EList[ExceptionHandler] = that.getHandlers
  }
}

object ExecutableNodeScalaSupport extends ExecutableNodeScalaSupport
