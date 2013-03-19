package fr.unice.i3s.sigma.support.ecore

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypeParameter;

trait ETypeParameterScalaSupport {
  implicit class ETypeParameterScalaSupport(that: ETypeParameter) {
    def eBounds: EList[EGenericType] = that.getEBounds
  }
}

object ETypeParameterScalaSupport extends ETypeParameterScalaSupport
