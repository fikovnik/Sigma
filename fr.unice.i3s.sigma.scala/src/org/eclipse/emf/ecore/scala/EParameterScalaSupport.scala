package org.eclipse.emf.ecore.scala

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;

trait EParameterScalaSupport {
  implicit class EParameterScalaSupport(obj: EParameter) {
    def eOperation: EOperation = obj.getEOperation
  }
}

object EParameterScalaSupport extends EParameterScalaSupport
