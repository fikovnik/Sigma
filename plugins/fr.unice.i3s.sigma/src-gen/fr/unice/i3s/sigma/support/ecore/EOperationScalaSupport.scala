package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.ETypeParameter;

trait EOperationScalaSupport extends EMFScalaSupport {
  type EOperation = org.eclipse.emf.ecore.EOperation
  
  protected implicit val _eoperationProxyBuilder = new EMFProxyBuilder[EOperation](EcorePackageScalaSupport._ecoreBuilder)
  
  object EOperation {
    def apply(eAnnotations: EList[EAnnotation] = null, name: String = null, ordered: Boolean = true, unique: Boolean = true, lowerBound: Int = 0, upperBound: Int = 1, eType: EClassifier = null, eGenericType: EGenericType = null, eTypeParameters: EList[ETypeParameter] = null, eParameters: EList[EParameter] = null, eExceptions: EList[EClassifier] = null, eGenericExceptions: EList[EGenericType] = null): EOperation = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[EOperation]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (name != null) _instance.setName(name)
      if (ordered != true) _instance.setOrdered(ordered)
      if (unique != true) _instance.setUnique(unique)
      if (lowerBound != 0) _instance.setLowerBound(lowerBound)
      if (upperBound != 1) _instance.setUpperBound(upperBound)
      if (eType != null) _instance.setEType(eType)
      if (eGenericType != null) _instance.setEGenericType(eGenericType)
      if (eTypeParameters != null) _instance.getETypeParameters.addAll(eTypeParameters)
      if (eParameters != null) _instance.getEParameters.addAll(eParameters)
      if (eExceptions != null) _instance.getEExceptions.addAll(eExceptions)
      if (eGenericExceptions != null) _instance.getEGenericExceptions.addAll(eGenericExceptions)
      
      _instance
    }
  }
  
  implicit class EOperationScalaSupport(that: EOperation) {
    def eContainingClass: EClass = that.getEContainingClass
    def eTypeParameters: EList[ETypeParameter] = that.getETypeParameters
    def eParameters: EList[EParameter] = that.getEParameters
    def eExceptions: EList[EClassifier] = that.getEExceptions
    def eGenericExceptions: EList[EGenericType] = that.getEGenericExceptions
  }
}

object EOperationScalaSupport extends EOperationScalaSupport
