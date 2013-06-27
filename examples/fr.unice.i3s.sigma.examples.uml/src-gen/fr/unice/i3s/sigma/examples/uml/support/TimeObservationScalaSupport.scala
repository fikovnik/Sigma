package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait TimeObservationScalaSupport extends EMFScalaSupport {
  type TimeObservation = org.eclipse.uml2.uml.TimeObservation
  
  protected implicit val _timeobservationProxyBuilder = new EMFProxyBuilder[TimeObservation](UMLPackageScalaSupport._umlBuilder)
  
  object TimeObservation {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, event: NamedElement = null, firstEvent: Boolean = true): TimeObservation = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[TimeObservation]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (event != null) _instance.setEvent(event)
      if (firstEvent != true) _instance.setFirstEvent(firstEvent)
      
      _instance
    }
  }
  
  implicit class TimeObservationScalaSupport(that: TimeObservation) {
    def event: NamedElement = that.getEvent
    def event_=(value: NamedElement): Unit = that.setEvent(value)
    def event_=(value: ⇒ Option[NamedElement]): Unit =
      that.setEvent(UMLPackageScalaSupport._umlBuilder.ref(value))
    def firstEvent: Boolean = that.isFirstEvent
    def firstEvent_=(value: Boolean): Unit = that.setFirstEvent(value)
  }
}

object TimeObservationScalaSupport extends TimeObservationScalaSupport
