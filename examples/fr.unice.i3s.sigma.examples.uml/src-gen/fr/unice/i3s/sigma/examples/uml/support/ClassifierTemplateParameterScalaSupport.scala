package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ParameterableElement;

trait ClassifierTemplateParameterScalaSupport extends EMFScalaSupport {
  type ClassifierTemplateParameter = org.eclipse.uml2.uml.ClassifierTemplateParameter
  
  protected implicit val _classifiertemplateparameterProxyBuilder = new EMFProxyBuilder[ClassifierTemplateParameter](UMLPackageScalaSupport._umlBuilder)
  
  object ClassifierTemplateParameter {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, default: ParameterableElement = null, ownedDefault: ParameterableElement = null, ownedParameteredElement: ParameterableElement = null, parameteredElement: ParameterableElement = null, allowSubstitutable: Boolean = true, constrainingClassifier: EList[Classifier] = null): ClassifierTemplateParameter = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ClassifierTemplateParameter]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (default != null) _instance.setDefault(default)
      if (ownedDefault != null) _instance.setOwnedDefault(ownedDefault)
      if (ownedParameteredElement != null) _instance.setOwnedParameteredElement(ownedParameteredElement)
      if (parameteredElement != null) _instance.setParameteredElement(parameteredElement)
      if (allowSubstitutable != true) _instance.setAllowSubstitutable(allowSubstitutable)
      if (constrainingClassifier != null) _instance.getConstrainingClassifiers.addAll(constrainingClassifier)
      
      _instance
    }
  }
  
  implicit class ClassifierTemplateParameterScalaSupport(that: ClassifierTemplateParameter) {
    def allowSubstitutable: Boolean = that.isAllowSubstitutable
    def allowSubstitutable_=(value: Boolean): Unit = that.setAllowSubstitutable(value)
    def constrainingClassifier: EList[Classifier] = that.getConstrainingClassifiers
  }
}

object ClassifierTemplateParameterScalaSupport extends ClassifierTemplateParameterScalaSupport
