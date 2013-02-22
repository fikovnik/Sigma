package org.eclipse.emf.ecore.scala

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypeParameter;

trait ETypeParameterScalaSupport {
  implicit class ETypeParameterScalaSupport(obj: ETypeParameter) {
    def eBounds: EList[EGenericType] = obj.getEBounds
  }
}

object ETypeParameterScalaSupport extends ETypeParameterScalaSupport
