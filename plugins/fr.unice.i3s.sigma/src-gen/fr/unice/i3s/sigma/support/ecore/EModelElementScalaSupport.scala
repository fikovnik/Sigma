package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;

trait EModelElementScalaSupport extends EMFScalaSupport {
  type EModelElement = org.eclipse.emf.ecore.EModelElement
  
  protected implicit val _emodelelementProxyBuilder = new EMFProxyBuilder[EModelElement](EcorePackageScalaSupport._ecoreBuilder)
  
  object EModelElement {
  
  }
  
  implicit class EModelElementScalaSupport(that: EModelElement) {
    def eAnnotations: EList[EAnnotation] = that.getEAnnotations
  }
}

object EModelElementScalaSupport extends EModelElementScalaSupport
