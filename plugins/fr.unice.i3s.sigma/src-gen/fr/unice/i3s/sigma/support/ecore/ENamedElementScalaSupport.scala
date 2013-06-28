package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.ENamedElement;

trait ENamedElementScalaSupport extends EMFScalaSupport {
  type ENamedElement = org.eclipse.emf.ecore.ENamedElement
  
  protected implicit val _enamedelementProxyBuilder = new EMFProxyBuilder[ENamedElement](EcorePackageScalaSupport._ecoreBuilder)
  
  object ENamedElement {
    def apply(eAnnotations: EList[EAnnotation] = null, name: String = null): ENamedElement = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[ENamedElement]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (name != null) _instance.setName(name)
      
      _instance
    }
  }
  
  implicit class ENamedElementScalaSupport(that: ENamedElement) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
  }
}

object ENamedElementScalaSupport extends ENamedElementScalaSupport
