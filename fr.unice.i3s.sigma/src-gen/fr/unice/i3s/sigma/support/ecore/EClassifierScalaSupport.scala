package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypeParameter;

trait EClassifierScalaSupport extends EMFScalaSupport {
  type EClassifier = org.eclipse.emf.ecore.EClassifier
  
  protected implicit val _eclassifierProxyBuilder = new EMFProxyBuilder[EClassifier](EcorePackageScalaSupport._ecoreBuilder)
  
  object EClassifier {
    def apply(name: String = null, instanceClassName: String = null, instanceTypeName: String = null): EClassifier = {
      val instance = EcorePackageScalaSupport._ecoreBuilder.create[EClassifier]
      
      if (name != null) instance.setName(name)
      if (instanceClassName != null) instance.setInstanceClassName(instanceClassName)
      if (instanceTypeName != null) instance.setInstanceTypeName(instanceTypeName)
      
      instance
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
