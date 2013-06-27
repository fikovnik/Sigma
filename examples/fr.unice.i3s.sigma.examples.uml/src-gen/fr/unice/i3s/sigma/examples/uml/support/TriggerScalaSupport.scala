package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait TriggerScalaSupport extends EMFScalaSupport {
  type Trigger = org.eclipse.uml2.uml.Trigger
  
  protected implicit val _triggerProxyBuilder = new EMFProxyBuilder[Trigger](UMLPackageScalaSupport._umlBuilder)
  
  object Trigger {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, event: Event = null, port: EList[Port] = null): Trigger = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Trigger]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (event != null) _instance.setEvent(event)
      if (port != null) _instance.getPorts.addAll(port)
      
      _instance
    }
  }
  
  implicit class TriggerScalaSupport(that: Trigger) {
    def event: Event = that.getEvent
    def event_=(value: Event): Unit = that.setEvent(value)
    def event_=(value: ⇒ Option[Event]): Unit =
      that.setEvent(UMLPackageScalaSupport._umlBuilder.ref(value))
    def port: EList[Port] = that.getPorts
  }
}

object TriggerScalaSupport extends TriggerScalaSupport
