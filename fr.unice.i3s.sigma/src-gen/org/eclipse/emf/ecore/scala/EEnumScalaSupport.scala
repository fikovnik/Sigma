package org.eclipse.emf.ecore.scala

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

trait EEnumScalaSupport {
  implicit class EEnumScalaSupport(that: EEnum) {
    def eLiterals: EList[EEnumLiteral] = that.getELiterals
  }
}

object EEnumScalaSupport extends EEnumScalaSupport
