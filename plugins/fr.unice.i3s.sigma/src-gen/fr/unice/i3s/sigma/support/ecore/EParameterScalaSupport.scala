package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;

trait EParameterScalaSupport extends EMFScalaSupport {
  type EParameter = org.eclipse.emf.ecore.EParameter
  
  protected implicit val _eparameterProxyBuilder = new EMFProxyBuilder[EParameter](EcorePackageScalaSupport._ecoreBuilder)
  
  object EParameter {
    def apply(eAnnotations: EList[EAnnotation] = null, name: String = null, ordered: Boolean = true, unique: Boolean = true, lowerBound: Int = 0, upperBound: Int = 1, eType: EClassifier = null, eGenericType: EGenericType = null): EParameter = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[EParameter]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (name != null) _instance.setName(name)
      if (ordered != true) _instance.setOrdered(ordered)
      if (unique != true) _instance.setUnique(unique)
      if (lowerBound != 0) _instance.setLowerBound(lowerBound)
      if (upperBound != 1) _instance.setUpperBound(upperBound)
      if (eType != null) _instance.setEType(eType)
      if (eGenericType != null) _instance.setEGenericType(eGenericType)
      
      _instance
    }
  }
  
  implicit class EParameterScalaSupport(that: EParameter) {
    def eOperation: EOperation = that.getEOperation
  }
}

object EParameterScalaSupport extends EParameterScalaSupport
