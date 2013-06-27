package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.VisibilityKind;

trait ConnectableElementScalaSupport extends EMFScalaSupport {
  type ConnectableElement = org.eclipse.uml2.uml.ConnectableElement
  
  protected implicit val _connectableelementProxyBuilder = new EMFProxyBuilder[ConnectableElement](UMLPackageScalaSupport._umlBuilder)
  
  object ConnectableElement {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, type_ : Type = null, templateParameter: TemplateParameter = null): ConnectableElement = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ConnectableElement]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (type_  != null) _instance.setType(type_ )
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      
      _instance
    }
  }
  
  implicit class ConnectableElementScalaSupport(that: ConnectableElement) {
    def end: EList[ConnectorEnd] = that.getEnds
  }
}

object ConnectableElementScalaSupport extends ConnectableElementScalaSupport
