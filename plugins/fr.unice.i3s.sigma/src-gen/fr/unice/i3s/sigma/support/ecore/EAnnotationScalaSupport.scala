package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;

trait EAnnotationScalaSupport extends EMFScalaSupport {
  type EAnnotation = org.eclipse.emf.ecore.EAnnotation
  
  protected implicit val _eannotationProxyBuilder = new EMFProxyBuilder[EAnnotation](EcorePackageScalaSupport._ecoreBuilder)
  
  object EAnnotation {
    def apply(eAnnotations: EList[EAnnotation] = null, source: String = null, details: EMap[String, String] = null, contents: EList[EObject] = null, references: EList[EObject] = null): EAnnotation = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[EAnnotation]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (source != null) _instance.setSource(source)
      if (details != null) _instance.getDetails.addAll(details)
      if (contents != null) _instance.getContents.addAll(contents)
      if (references != null) _instance.getReferences.addAll(references)
      
      _instance
    }
  }
}

object EAnnotationScalaSupport extends EAnnotationScalaSupport
