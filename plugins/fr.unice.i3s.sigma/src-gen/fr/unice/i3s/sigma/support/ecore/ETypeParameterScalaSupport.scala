package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypeParameter;

trait ETypeParameterScalaSupport extends EMFScalaSupport {
  type ETypeParameter = org.eclipse.emf.ecore.ETypeParameter
  
  protected implicit val _etypeparameterProxyBuilder = new EMFProxyBuilder[ETypeParameter](EcorePackageScalaSupport._ecoreBuilder)
  
  object ETypeParameter {
  
  }
  
  implicit class ETypeParameterScalaSupport(that: ETypeParameter) {
    def eBounds: EList[EGenericType] = that.getEBounds
  }
}

object ETypeParameterScalaSupport extends ETypeParameterScalaSupport
