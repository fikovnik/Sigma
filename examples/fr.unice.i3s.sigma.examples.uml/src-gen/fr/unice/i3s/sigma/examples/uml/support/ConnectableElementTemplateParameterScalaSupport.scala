package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectableElementTemplateParameter;
import org.eclipse.uml2.uml.ParameterableElement;

trait ConnectableElementTemplateParameterScalaSupport extends EMFScalaSupport {
  type ConnectableElementTemplateParameter = org.eclipse.uml2.uml.ConnectableElementTemplateParameter
  
  protected implicit val _connectableelementtemplateparameterProxyBuilder = new EMFProxyBuilder[ConnectableElementTemplateParameter](UMLPackageScalaSupport._umlBuilder)
  
  object ConnectableElementTemplateParameter {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, default: ParameterableElement = null, ownedDefault: ParameterableElement = null, ownedParameteredElement: ParameterableElement = null, parameteredElement: ParameterableElement = null): ConnectableElementTemplateParameter = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ConnectableElementTemplateParameter]
      
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

object ConnectableElementTemplateParameterScalaSupport extends ConnectableElementTemplateParameterScalaSupport
