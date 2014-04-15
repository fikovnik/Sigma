package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;

trait EPackageScalaSupport extends EMFScalaSupport {
  type EPackage = org.eclipse.emf.ecore.EPackage
  
  protected implicit val _epackageProxyBuilder = new EMFProxyBuilder[EPackage](EcorePackageScalaSupport._ecoreBuilder)
  
  object EPackage {
    def apply(eAnnotations: EList[EAnnotation] = null, name: String = null, nsURI: String = null, nsPrefix: String = null, eFactoryInstance: EFactory = null, eClassifiers: EList[EClassifier] = null, eSubpackages: EList[EPackage] = null): EPackage = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[EPackage]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (name != null) _instance.setName(name)
      if (nsURI != null) _instance.setNsURI(nsURI)
      if (nsPrefix != null) _instance.setNsPrefix(nsPrefix)
      if (eFactoryInstance != null) _instance.setEFactoryInstance(eFactoryInstance)
      if (eClassifiers != null) _instance.getEClassifiers.addAll(eClassifiers)
      if (eSubpackages != null) _instance.getESubpackages.addAll(eSubpackages)
      
      _instance
    }
  }
}

object EPackageScalaSupport extends EPackageScalaSupport
