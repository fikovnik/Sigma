package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;

import scala.Option;

trait TemplateParameterScalaSupport extends EMFScalaSupport {
  type TemplateParameter = org.eclipse.uml2.uml.TemplateParameter
  
  protected implicit val _templateparameterProxyBuilder = new EMFProxyBuilder[TemplateParameter](UMLPackageScalaSupport._umlBuilder)
  
  object TemplateParameter {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, default: ParameterableElement = null, ownedDefault: ParameterableElement = null, ownedParameteredElement: ParameterableElement = null, parameteredElement: ParameterableElement = null): TemplateParameter = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[TemplateParameter]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (default != null) _instance.setDefault(default)
      if (ownedDefault != null) _instance.setOwnedDefault(ownedDefault)
      if (ownedParameteredElement != null) _instance.setOwnedParameteredElement(ownedParameteredElement)
      if (parameteredElement != null) _instance.setParameteredElement(parameteredElement)
      
      _instance
    }
  }
  
  implicit class TemplateParameterScalaSupport(that: TemplateParameter) {
    def default: ParameterableElement = that.getDefault
    def default_=(value: ParameterableElement): Unit = that.setDefault(value)
    def default_=(value: ⇒ Option[ParameterableElement]): Unit =
      that.setDefault(UMLPackageScalaSupport._umlBuilder.ref(value))
    def ownedDefault: ParameterableElement = that.getOwnedDefault
    def ownedDefault_=(value: ParameterableElement): Unit = that.setOwnedDefault(value)
    def ownedParameteredElement: ParameterableElement = that.getOwnedParameteredElement
    def ownedParameteredElement_=(value: ParameterableElement): Unit = that.setOwnedParameteredElement(value)
    def parameteredElement: ParameterableElement = that.getParameteredElement
    def parameteredElement_=(value: ParameterableElement): Unit = that.setParameteredElement(value)
    def parameteredElement_=(value: ⇒ Option[ParameterableElement]): Unit =
      that.setParameteredElement(UMLPackageScalaSupport._umlBuilder.ref(value))
    def signature: TemplateSignature = that.getSignature
    def signature_=(value: TemplateSignature): Unit = that.setSignature(value)
    def signature_=(value: ⇒ Option[TemplateSignature]): Unit =
      that.setSignature(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object TemplateParameterScalaSupport extends TemplateParameterScalaSupport
