package org.eclipse.emf.ecore.scala

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;

trait EParameterScalaSupport {
  implicit class EParameterScalaSupport(that: EParameter) {
    def eOperation: EOperation = that.getEOperation
  }
}

object EParameterScalaSupport extends EParameterScalaSupport
