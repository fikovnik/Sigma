package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypeParameter;

trait EGenericTypeScalaSupport extends EMFScalaSupport {
  type EGenericType = org.eclipse.emf.ecore.EGenericType
  
  protected implicit val _egenerictypeProxyBuilder = new EMFProxyBuilder[EGenericType](EcorePackageScalaSupport._ecoreBuilder)
  
  object EGenericType {
    def apply(eUpperBound: EGenericType = null, eTypeArguments: EList[EGenericType] = null, eLowerBound: EGenericType = null, eTypeParameter: ETypeParameter = null, eClassifier: EClassifier = null): EGenericType = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[EGenericType]
      
      if (eUpperBound != null) _instance.setEUpperBound(eUpperBound)
      if (eTypeArguments != null) _instance.getETypeArguments.addAll(eTypeArguments)
      if (eLowerBound != null) _instance.setELowerBound(eLowerBound)
      if (eTypeParameter != null) _instance.setETypeParameter(eTypeParameter)
      if (eClassifier != null) _instance.setEClassifier(eClassifier)
      
      _instance
    }
  }
}

object EGenericTypeScalaSupport extends EGenericTypeScalaSupport
