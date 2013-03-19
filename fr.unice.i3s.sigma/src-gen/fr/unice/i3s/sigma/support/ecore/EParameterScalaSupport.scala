package fr.unice.i3s.sigma.support.ecore

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;

trait EParameterScalaSupport {
  implicit class EParameterScalaSupport(that: EParameter) {
    def eOperation: EOperation = that.getEOperation
  }
}

object EParameterScalaSupport extends EParameterScalaSupport
