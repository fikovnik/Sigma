package org.eclipse.emf.ecore.scala

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypeParameter;

trait EGenericTypeScalaSupport {
  implicit class EGenericTypeScalaSupport(that: EGenericType) {
    def eUpperBound: EGenericType = that.getEUpperBound
    def eUpperBound_=(value: EGenericType): Unit = that.setEUpperBound(value)
    def eTypeArguments: EList[EGenericType] = that.getETypeArguments
    def eRawType: EClassifier = that.getERawType
    def eLowerBound: EGenericType = that.getELowerBound
    def eLowerBound_=(value: EGenericType): Unit = that.setELowerBound(value)
    def eTypeParameter: ETypeParameter = that.getETypeParameter
    def eTypeParameter_=(value: ETypeParameter): Unit = that.setETypeParameter(value)
    def eClassifier: EClassifier = that.getEClassifier
    def eClassifier_=(value: EClassifier): Unit = that.setEClassifier(value)
  }
}

object EGenericTypeScalaSupport extends EGenericTypeScalaSupport
