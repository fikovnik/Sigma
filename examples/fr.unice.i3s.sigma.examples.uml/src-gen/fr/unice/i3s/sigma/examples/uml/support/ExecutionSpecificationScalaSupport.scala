package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ExecutionSpecificationScalaSupport extends EMFScalaSupport {
  type ExecutionSpecification = org.eclipse.uml2.uml.ExecutionSpecification
  
  protected implicit val _executionspecificationProxyBuilder = new EMFProxyBuilder[ExecutionSpecification](UMLPackageScalaSupport._umlBuilder)
  
  object ExecutionSpecification {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, covered: EList[Lifeline] = null, generalOrdering: EList[GeneralOrdering] = null, finish: OccurrenceSpecification = null, start: OccurrenceSpecification = null): ExecutionSpecification = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ExecutionSpecification]
      
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
      
      _instance
    }
  }
  
  implicit class ExecutionSpecificationScalaSupport(that: ExecutionSpecification) {
    def finish: OccurrenceSpecification = that.getFinish
    def finish_=(value: OccurrenceSpecification): Unit = that.setFinish(value)
    def finish_=(value: ⇒ Option[OccurrenceSpecification]): Unit =
      that.setFinish(UMLPackageScalaSupport._umlBuilder.ref(value))
    def start: OccurrenceSpecification = that.getStart
    def start_=(value: OccurrenceSpecification): Unit = that.setStart(value)
    def start_=(value: ⇒ Option[OccurrenceSpecification]): Unit =
      that.setStart(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object ExecutionSpecificationScalaSupport extends ExecutionSpecificationScalaSupport
