package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

trait EClassScalaSupport extends EMFScalaSupport {
  type EClass = org.eclipse.emf.ecore.EClass
  
  protected implicit val _eclassProxyBuilder = new EMFProxyBuilder[EClass](EcorePackageScalaSupport._ecoreBuilder)
  
  object EClass {
    def apply(name: String = null, instanceClassName: String = null, instanceTypeName: String = null, abstract_ : Boolean = false, interface: Boolean = false): EClass = {
      val instance = EcorePackageScalaSupport._ecoreBuilder.create[EClass]
      
      if (name != null) instance.setName(name)
      if (instanceClassName != null) instance.setInstanceClassName(instanceClassName)
      if (instanceTypeName != null) instance.setInstanceTypeName(instanceTypeName)
      if (abstract_  != false) instance.setAbstract(abstract_ )
      if (interface != false) instance.setInterface(interface)
      
      instance
    }
  }
  
  implicit class EClassScalaSupport(that: EClass) {
    def abstract_ : Boolean = that.isAbstract
    def abstract__=(value: Boolean): Unit = that.setAbstract(value)
    def interface: Boolean = that.isInterface
    def interface_=(value: Boolean): Unit = that.setInterface(value)
    def eSuperTypes: EList[EClass] = that.getESuperTypes
    def eOperations: EList[EOperation] = that.getEOperations
    def eAllAttributes: EList[EAttribute] = that.getEAllAttributes
    def eAllReferences: EList[EReference] = that.getEAllReferences
    def eReferences: EList[EReference] = that.getEReferences
    def eAttributes: EList[EAttribute] = that.getEAttributes
    def eAllContainments: EList[EReference] = that.getEAllContainments
    def eAllOperations: EList[EOperation] = that.getEAllOperations
    def eAllStructuralFeatures: EList[EStructuralFeature] = that.getEAllStructuralFeatures
    def eAllSuperTypes: EList[EClass] = that.getEAllSuperTypes
    def eIDAttribute: EAttribute = that.getEIDAttribute
    def eStructuralFeatures: EList[EStructuralFeature] = that.getEStructuralFeatures
    def eGenericSuperTypes: EList[EGenericType] = that.getEGenericSuperTypes
    def eAllGenericSuperTypes: EList[EGenericType] = that.getEAllGenericSuperTypes
  }
}

object EClassScalaSupport extends EClassScalaSupport
