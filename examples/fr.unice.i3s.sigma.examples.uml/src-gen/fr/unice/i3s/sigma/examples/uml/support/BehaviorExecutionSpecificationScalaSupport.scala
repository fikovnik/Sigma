package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait BehaviorExecutionSpecificationScalaSupport extends EMFScalaSupport {
  type BehaviorExecutionSpecification = org.eclipse.uml2.uml.BehaviorExecutionSpecification
  
  protected implicit val _behaviorexecutionspecificationProxyBuilder = new EMFProxyBuilder[BehaviorExecutionSpecification](UMLPackageScalaSupport._umlBuilder)
  
  object BehaviorExecutionSpecification {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, covered: EList[Lifeline] = null, generalOrdering: EList[GeneralOrdering] = null, finish: OccurrenceSpecification = null, start: OccurrenceSpecification = null, behavior: Behavior = null): BehaviorExecutionSpecification = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[BehaviorExecutionSpecification]
      
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
      if (behavior != null) _instance.setBehavior(behavior)
      
      _instance
    }
  }
  
  implicit class BehaviorExecutionSpecificationScalaSupport(that: BehaviorExecutionSpecification) {
    def behavior: Behavior = that.getBehavior
    def behavior_=(value: Behavior): Unit = that.setBehavior(value)
    def behavior_=(value: ⇒ Option[Behavior]): Unit =
      that.setBehavior(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object BehaviorExecutionSpecificationScalaSupport extends BehaviorExecutionSpecificationScalaSupport
