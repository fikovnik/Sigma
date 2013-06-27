package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait GeneralOrderingScalaSupport extends EMFScalaSupport {
  type GeneralOrdering = org.eclipse.uml2.uml.GeneralOrdering
  
  protected implicit val _generalorderingProxyBuilder = new EMFProxyBuilder[GeneralOrdering](UMLPackageScalaSupport._umlBuilder)
  
  object GeneralOrdering {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, after: OccurrenceSpecification = null, before: OccurrenceSpecification = null): GeneralOrdering = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[GeneralOrdering]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (after != null) _instance.setAfter(after)
      if (before != null) _instance.setBefore(before)
      
      _instance
    }
  }
  
  implicit class GeneralOrderingScalaSupport(that: GeneralOrdering) {
    def after: OccurrenceSpecification = that.getAfter
    def after_=(value: OccurrenceSpecification): Unit = that.setAfter(value)
    def after_=(value: ⇒ Option[OccurrenceSpecification]): Unit =
      that.setAfter(UMLPackageScalaSupport._umlBuilder.ref(value))
    def before: OccurrenceSpecification = that.getBefore
    def before_=(value: OccurrenceSpecification): Unit = that.setBefore(value)
    def before_=(value: ⇒ Option[OccurrenceSpecification]): Unit =
      that.setBefore(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object GeneralOrderingScalaSupport extends GeneralOrderingScalaSupport
