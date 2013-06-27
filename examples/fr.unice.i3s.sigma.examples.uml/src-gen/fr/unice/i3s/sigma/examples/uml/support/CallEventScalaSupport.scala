package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait CallEventScalaSupport extends EMFScalaSupport {
  type CallEvent = org.eclipse.uml2.uml.CallEvent
  
  protected implicit val _calleventProxyBuilder = new EMFProxyBuilder[CallEvent](UMLPackageScalaSupport._umlBuilder)
  
  object CallEvent {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, operation: Operation = null): CallEvent = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[CallEvent]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (operation != null) _instance.setOperation(operation)
      
      _instance
    }
  }
  
  implicit class CallEventScalaSupport(that: CallEvent) {
    def operation: Operation = that.getOperation
    def operation_=(value: Operation): Unit = that.setOperation(value)
    def operation_=(value: ⇒ Option[Operation]): Unit =
      that.setOperation(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object CallEventScalaSupport extends CallEventScalaSupport
