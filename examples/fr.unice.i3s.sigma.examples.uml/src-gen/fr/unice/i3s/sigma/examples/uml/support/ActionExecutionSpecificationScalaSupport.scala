package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ActionExecutionSpecificationScalaSupport extends EMFScalaSupport {
  type ActionExecutionSpecification = org.eclipse.uml2.uml.ActionExecutionSpecification
  
  protected implicit val _actionexecutionspecificationProxyBuilder = new EMFProxyBuilder[ActionExecutionSpecification](UMLPackageScalaSupport._umlBuilder)
  
  object ActionExecutionSpecification {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, covered: EList[Lifeline] = null, generalOrdering: EList[GeneralOrdering] = null, finish: OccurrenceSpecification = null, start: OccurrenceSpecification = null, action: Action = null): ActionExecutionSpecification = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ActionExecutionSpecification]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (covered != null) _instance.getCovereds.addAll(covered)
      if (generalOrdering != null) _instance.getGeneralOrderings.addAll(generalOrdering)
      if (finish != null) _instance.setFinish(finish)
      if (start != null) _instance.setStart(start)
      if (action != null) _instance.setAction(action)
      
      _instance
    }
  }
  
  implicit class ActionExecutionSpecificationScalaSupport(that: ActionExecutionSpecification) {
    def action: Action = that.getAction
    def action_=(value: Action): Unit = that.setAction(value)
    def action_=(value: ⇒ Option[Action]): Unit =
      that.setAction(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object ActionExecutionSpecificationScalaSupport extends ActionExecutionSpecificationScalaSupport
