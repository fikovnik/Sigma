package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;

trait EParameterScalaSupport extends EMFScalaSupport {
  type EParameter = org.eclipse.emf.ecore.EParameter
  
  protected implicit val _eparameterProxyBuilder = new EMFProxyBuilder[EParameter](EcorePackageScalaSupport._ecoreBuilder)
  
  object EParameter {
    def apply(name: String = null, ordered: Boolean = true, unique: Boolean = true, lowerBound: Int = 0, upperBound: Int = 1): EParameter = {
      val instance = EcorePackageScalaSupport._ecoreBuilder.create[EParameter]
      
      if (name != null) instance.setName(name)
      if (ordered != true) instance.setOrdered(ordered)
      if (unique != true) instance.setUnique(unique)
      if (lowerBound != 0) instance.setLowerBound(lowerBound)
      if (upperBound != 1) instance.setUpperBound(upperBound)
      
      instance
    }
  }
  
  implicit class EParameterScalaSupport(that: EParameter) {
    def eOperation: EOperation = that.getEOperation
  }
}

object EParameterScalaSupport extends EParameterScalaSupport
