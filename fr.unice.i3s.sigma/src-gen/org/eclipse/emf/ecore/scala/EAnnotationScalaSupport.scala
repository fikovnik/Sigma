package org.eclipse.emf.ecore.scala

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

trait EAnnotationScalaSupport {
  implicit class EAnnotationScalaSupport(that: EAnnotation) {
    def source: String = that.getSource
    def source_=(value: String): Unit = that.setSource(value)
    def details: EMap[String, String] = that.getDetails
    def eModelElement: EModelElement = that.getEModelElement
    def eModelElement_=(value: EModelElement): Unit = that.setEModelElement(value)
    def contents: EList[EObject] = that.getContents
    def references: EList[EObject] = that.getReferences
  }
}

object EAnnotationScalaSupport extends EAnnotationScalaSupport
