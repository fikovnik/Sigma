package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.TemplateableElement;

trait TemplateableElementScalaSupport extends EMFScalaSupport {
  type TemplateableElement = org.eclipse.uml2.uml.TemplateableElement
  
  protected implicit val _templateableelementProxyBuilder = new EMFProxyBuilder[TemplateableElement](UMLPackageScalaSupport._umlBuilder)
  
  object TemplateableElement {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, ownedTemplateSignature: TemplateSignature = null, templateBinding: EList[TemplateBinding] = null): TemplateableElement = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[TemplateableElement]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (ownedTemplateSignature != null) _instance.setOwnedTemplateSignature(ownedTemplateSignature)
      if (templateBinding != null) _instance.getTemplateBindings.addAll(templateBinding)
      
      _instance
    }
  }
  
  implicit class TemplateableElementScalaSupport(that: TemplateableElement) {
    def ownedTemplateSignature: TemplateSignature = that.getOwnedTemplateSignature
    def ownedTemplateSignature_=(value: TemplateSignature): Unit = that.setOwnedTemplateSignature(value)
    def templateBinding: EList[TemplateBinding] = that.getTemplateBindings
  }
}

object TemplateableElementScalaSupport extends TemplateableElementScalaSupport
