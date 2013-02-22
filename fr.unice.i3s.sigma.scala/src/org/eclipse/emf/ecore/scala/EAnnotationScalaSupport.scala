package org.eclipse.emf.ecore.scala

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

trait EAnnotationScalaSupport {
  implicit class EAnnotationScalaSupport(obj: EAnnotation) {
    def source: String = obj.getSource
    def source_=(value: String): Unit = obj.setSource(value)
    def details: EMap[String, String] = obj.getDetails
    def eModelElement: EModelElement = obj.getEModelElement
    def eModelElement_=(value: EModelElement): Unit = obj.setEModelElement(value)
    def contents: EList[EObject] = obj.getContents
    def references: EList[EObject] = obj.getReferences
  }
}

object EAnnotationScalaSupport extends EAnnotationScalaSupport
