package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;

trait EClassifierScalaSupport extends EMFScalaSupport {
  type EClassifier = org.eclipse.emf.ecore.EClassifier
  
  protected implicit val _eclassifierProxyBuilder = new EMFProxyBuilder[EClassifier](EcorePackageScalaSupport._ecoreBuilder)
  
  object EClassifier {
    def apply(eAnnotations: EList[EAnnotation] = null, name: String = null, instanceClassName: String = null, instanceTypeName: String = null, eTypeParameters: EList[ETypeParameter] = null): EClassifier = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[EClassifier]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (name != null) _instance.setName(name)
      if (instanceClassName != null) _instance.setInstanceClassName(instanceClassName)
      if (instanceTypeName != null) _instance.setInstanceTypeName(instanceTypeName)
      if (eTypeParameters != null) _instance.getETypeParameters.addAll(eTypeParameters)
      
      _instance
    }
  }
  
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
