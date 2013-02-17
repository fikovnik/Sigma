package fr.unice.i3s.sigma.scala.utils.ecore

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypeParameter;

trait EGenericTypeScalaSupport {
  implicit class EGenericTypeScalaSupport(obj: EGenericType) {
    def eUpperBound: EGenericType = obj.getEUpperBound
    def eUpperBound_=(value: EGenericType): Unit = obj.setEUpperBound(value)
    def eTypeArguments: EList[EGenericType] = obj.getETypeArguments
    def eRawType: EClassifier = obj.getERawType
    def eLowerBound: EGenericType = obj.getELowerBound
    def eLowerBound_=(value: EGenericType): Unit = obj.setELowerBound(value)
    def eTypeParameter: ETypeParameter = obj.getETypeParameter
    def eTypeParameter_=(value: ETypeParameter): Unit = obj.setETypeParameter(value)
    def eClassifier: EClassifier = obj.getEClassifier
    def eClassifier_=(value: EClassifier): Unit = obj.setEClassifier(value)
  }
}

object EGenericTypeScalaSupport extends EGenericTypeScalaSupport
