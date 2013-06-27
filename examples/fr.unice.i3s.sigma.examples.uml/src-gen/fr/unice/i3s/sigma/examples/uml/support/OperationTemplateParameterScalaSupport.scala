package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.OperationTemplateParameter;
import org.eclipse.uml2.uml.ParameterableElement;

trait OperationTemplateParameterScalaSupport extends EMFScalaSupport {
  type OperationTemplateParameter = org.eclipse.uml2.uml.OperationTemplateParameter
  
  protected implicit val _operationtemplateparameterProxyBuilder = new EMFProxyBuilder[OperationTemplateParameter](UMLPackageScalaSupport._umlBuilder)
  
  object OperationTemplateParameter {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, default: ParameterableElement = null, ownedDefault: ParameterableElement = null, ownedParameteredElement: ParameterableElement = null, parameteredElement: ParameterableElement = null): OperationTemplateParameter = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[OperationTemplateParameter]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (default != null) _instance.setDefault(default)
      if (ownedDefault != null) _instance.setOwnedDefault(ownedDefault)
      if (ownedParameteredElement != null) _instance.setOwnedParameteredElement(ownedParameteredElement)
      if (parameteredElement != null) _instance.setParameteredElement(parameteredElement)
      
      _instance
    }
  }
}

object OperationTemplateParameterScalaSupport extends OperationTemplateParameterScalaSupport
