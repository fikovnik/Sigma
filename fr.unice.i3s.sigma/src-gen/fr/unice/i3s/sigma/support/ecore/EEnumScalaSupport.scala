package fr.unice.i3s.sigma.support.ecore

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

trait EEnumScalaSupport {
  implicit class EEnumScalaSupport(that: EEnum) {
    def eLiterals: EList[EEnumLiteral] = that.getELiterals
  }
}

object EEnumScalaSupport extends EEnumScalaSupport
