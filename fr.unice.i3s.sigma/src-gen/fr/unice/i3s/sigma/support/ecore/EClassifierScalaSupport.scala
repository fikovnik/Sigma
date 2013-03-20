package fr.unice.i3s.sigma.support.ecore

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;

trait EClassifierScalaSupport {
  implicit class EClassifierScalaSupport(that: EClassifier) {
    def instanceClassName: String = that.getInstanceClassName
    def instanceClassName_=(value: String): Unit = that.setInstanceClassName(value)
    def instanceClass: Class[_] = that.getInstanceClass
    def defaultValue: Object = that.getDefaultValue
    def instanceTypeName: String = that.getInstanceTypeName
    def instanceTypeName_=(value: String): Unit = that.setInstanceTypeName(value)
    def ePackage: EPackage = that.getEPackage
    def eTypeParameters: EList[ETypeParameter] = that.getETypeParameters
  }
}

object EClassifierScalaSupport extends EClassifierScalaSupport
