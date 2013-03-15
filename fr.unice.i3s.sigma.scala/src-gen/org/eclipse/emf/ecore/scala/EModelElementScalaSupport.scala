package org.eclipse.emf.ecore.scala

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;

trait EModelElementScalaSupport {
  implicit class EModelElementScalaSupport(that: EModelElement) {
    def eAnnotations: EList[EAnnotation] = that.getEAnnotations
  }
}

object EModelElementScalaSupport extends EModelElementScalaSupport
