package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.TemplateableElement;

import scala.Option;

trait TemplateBindingScalaSupport extends EMFScalaSupport {
  type TemplateBinding = org.eclipse.uml2.uml.TemplateBinding
  
  protected implicit val _templatebindingProxyBuilder = new EMFProxyBuilder[TemplateBinding](UMLPackageScalaSupport._umlBuilder)
  
  object TemplateBinding {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, parameterSubstitution: EList[TemplateParameterSubstitution] = null, signature: TemplateSignature = null): TemplateBinding = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[TemplateBinding]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (parameterSubstitution != null) _instance.getParameterSubstitutions.addAll(parameterSubstitution)
      if (signature != null) _instance.setSignature(signature)
      
      _instance
    }
  }
  
  implicit class TemplateBindingScalaSupport(that: TemplateBinding) {
    def parameterSubstitution: EList[TemplateParameterSubstitution] = that.getParameterSubstitutions
    def signature: TemplateSignature = that.getSignature
    def signature_=(value: TemplateSignature): Unit = that.setSignature(value)
    def signature_=(value: ⇒ Option[TemplateSignature]): Unit =
      that.setSignature(UMLPackageScalaSupport._umlBuilder.ref(value))
    def boundElement: TemplateableElement = that.getBoundElement
    def boundElement_=(value: TemplateableElement): Unit = that.setBoundElement(value)
    def boundElement_=(value: ⇒ Option[TemplateableElement]): Unit =
      that.setBoundElement(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object TemplateBindingScalaSupport extends TemplateBindingScalaSupport
