package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;

trait EClassScalaSupport extends EMFScalaSupport {
  type EClass = org.eclipse.emf.ecore.EClass
  
  protected implicit val _eclassProxyBuilder = new EMFProxyBuilder[EClass](EcorePackageScalaSupport._ecoreBuilder)
  
  object EClass {
    def apply(eAnnotations: EList[EAnnotation] = null, name: String = null, instanceClassName: String = null, instanceTypeName: String = null, eTypeParameters: EList[ETypeParameter] = null, abstract_ : Boolean = false, interface: Boolean = false, eSuperTypes: EList[EClass] = null, eOperations: EList[EOperation] = null, eStructuralFeatures: EList[EStructuralFeature] = null, eGenericSuperTypes: EList[EGenericType] = null): EClass = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[EClass]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (name != null) _instance.setName(name)
      if (instanceClassName != null) _instance.setInstanceClassName(instanceClassName)
      if (instanceTypeName != null) _instance.setInstanceTypeName(instanceTypeName)
      if (eTypeParameters != null) _instance.getETypeParameters.addAll(eTypeParameters)
      if (abstract_  != false) _instance.setAbstract(abstract_ )
      if (interface != false) _instance.setInterface(interface)
      if (eSuperTypes != null) _instance.getESuperTypes.addAll(eSuperTypes)
      if (eOperations != null) _instance.getEOperations.addAll(eOperations)
      if (eStructuralFeatures != null) _instance.getEStructuralFeatures.addAll(eStructuralFeatures)
      if (eGenericSuperTypes != null) _instance.getEGenericSuperTypes.addAll(eGenericSuperTypes)
      
      _instance
    }
  }
}

object EClassScalaSupport extends EClassScalaSupport
