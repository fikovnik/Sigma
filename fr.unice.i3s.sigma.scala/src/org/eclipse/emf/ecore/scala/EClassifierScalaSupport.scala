package org.eclipse.emf.ecore.scala

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;

trait EClassifierScalaSupport {
  implicit class EClassifierScalaSupport(obj: EClassifier) {
    def instanceClassName: String = obj.getInstanceClassName
    def instanceClassName_=(value: String): Unit = obj.setInstanceClassName(value)
    def instanceClass: Class[_] = obj.getInstanceClass
    def defaultValue: Object = obj.getDefaultValue
    def instanceTypeName: String = obj.getInstanceTypeName
    def instanceTypeName_=(value: String): Unit = obj.setInstanceTypeName(value)
    def ePackage: EPackage = obj.getEPackage
    def eTypeParameters: EList[ETypeParameter] = obj.getETypeParameters
  }
}

object EClassifierScalaSupport extends EClassifierScalaSupport
