package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

import scala.Option;

trait EAnnotationScalaSupport extends EMFScalaSupport {
  type EAnnotation = org.eclipse.emf.ecore.EAnnotation
  
  protected implicit val _eannotationProxyBuilder = new EMFProxyBuilder[EAnnotation](EcorePackageScalaSupport._ecoreBuilder)
  
  object EAnnotation {
  
  }
  
  implicit class EAnnotationScalaSupport(that: EAnnotation) {
    def source: String = that.getSource
    def source_=(value: String): Unit = that.setSource(value)
    def details: EMap[String, String] = that.getDetails
    def eModelElement: EModelElement = that.getEModelElement
    def eModelElement_=(value: EModelElement): Unit = that.setEModelElement(value)
    def eModelElement_=(value: ⇒ Option[EModelElement]): Unit =
      that.setEModelElement(EcorePackageScalaSupport._ecoreBuilder.ref(value))
    def contents: EList[EObject] = that.getContents
    def references: EList[EObject] = that.getReferences
  }
}

object EAnnotationScalaSupport extends EAnnotationScalaSupport
