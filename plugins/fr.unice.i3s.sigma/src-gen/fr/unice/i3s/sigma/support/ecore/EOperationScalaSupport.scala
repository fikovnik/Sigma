package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

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
    def apply(name: String = null, ordered: Boolean = true, unique: Boolean = true, lowerBound: Int = 0, upperBound: Int = 1): EOperation = {
      val instance = EcorePackageScalaSupport._ecoreBuilder.create[EOperation]
      
      if (name != null) instance.setName(name)
      if (ordered != true) instance.setOrdered(ordered)
      if (unique != true) instance.setUnique(unique)
      if (lowerBound != 0) instance.setLowerBound(lowerBound)
      if (upperBound != 1) instance.setUpperBound(upperBound)
      
      instance
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
