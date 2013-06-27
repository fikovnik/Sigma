package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;

import scala.Option;

trait TemplateParameterSubstitutionScalaSupport extends EMFScalaSupport {
  type TemplateParameterSubstitution = org.eclipse.uml2.uml.TemplateParameterSubstitution
  
  protected implicit val _templateparametersubstitutionProxyBuilder = new EMFProxyBuilder[TemplateParameterSubstitution](UMLPackageScalaSupport._umlBuilder)
  
  object TemplateParameterSubstitution {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, actual: ParameterableElement = null, formal: TemplateParameter = null, ownedActual: ParameterableElement = null): TemplateParameterSubstitution = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[TemplateParameterSubstitution]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (actual != null) _instance.setActual(actual)
      if (formal != null) _instance.setFormal(formal)
      if (ownedActual != null) _instance.setOwnedActual(ownedActual)
      
      _instance
    }
  }
  
  implicit class TemplateParameterSubstitutionScalaSupport(that: TemplateParameterSubstitution) {
    def actual: ParameterableElement = that.getActual
    def actual_=(value: ParameterableElement): Unit = that.setActual(value)
    def actual_=(value: ⇒ Option[ParameterableElement]): Unit =
      that.setActual(UMLPackageScalaSupport._umlBuilder.ref(value))
    def formal: TemplateParameter = that.getFormal
    def formal_=(value: TemplateParameter): Unit = that.setFormal(value)
    def formal_=(value: ⇒ Option[TemplateParameter]): Unit =
      that.setFormal(UMLPackageScalaSupport._umlBuilder.ref(value))
    def ownedActual: ParameterableElement = that.getOwnedActual
    def ownedActual_=(value: ParameterableElement): Unit = that.setOwnedActual(value)
    def templateBinding: TemplateBinding = that.getTemplateBinding
    def templateBinding_=(value: TemplateBinding): Unit = that.setTemplateBinding(value)
    def templateBinding_=(value: ⇒ Option[TemplateBinding]): Unit =
      that.setTemplateBinding(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object TemplateParameterSubstitutionScalaSupport extends TemplateParameterSubstitutionScalaSupport
