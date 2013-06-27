package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait SignalEventScalaSupport extends EMFScalaSupport {
  type SignalEvent = org.eclipse.uml2.uml.SignalEvent
  
  protected implicit val _signaleventProxyBuilder = new EMFProxyBuilder[SignalEvent](UMLPackageScalaSupport._umlBuilder)
  
  object SignalEvent {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, signal: Signal = null): SignalEvent = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[SignalEvent]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (signal != null) _instance.setSignal(signal)
      
      _instance
    }
  }
  
  implicit class SignalEventScalaSupport(that: SignalEvent) {
    def signal: Signal = that.getSignal
    def signal_=(value: Signal): Unit = that.setSignal(value)
    def signal_=(value: ⇒ Option[Signal]): Unit =
      that.setSignal(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object SignalEventScalaSupport extends SignalEventScalaSupport
