package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;

trait EFactoryScalaSupport extends EMFScalaSupport {
  type EFactory = org.eclipse.emf.ecore.EFactory
  
  protected implicit val _efactoryProxyBuilder = new EMFProxyBuilder[EFactory](EcorePackageScalaSupport._ecoreBuilder)
  
  object EFactory {
    def apply(eAnnotations: EList[EAnnotation] = null, ePackage: EPackage = null): EFactory = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[EFactory]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ePackage != null) _instance.setEPackage(ePackage)
      
      _instance
    }
  }
}

object EFactoryScalaSupport extends EFactoryScalaSupport
