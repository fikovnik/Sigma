package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Interval;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait IntervalScalaSupport extends EMFScalaSupport {
  type Interval = org.eclipse.uml2.uml.Interval
  
  protected implicit val _intervalProxyBuilder = new EMFProxyBuilder[Interval](UMLPackageScalaSupport._umlBuilder)
  
  object Interval {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, type_ : Type = null, max: ValueSpecification = null, min: ValueSpecification = null): Interval = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Interval]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (type_  != null) _instance.setType(type_ )
      if (max != null) _instance.setMax(max)
      if (min != null) _instance.setMin(min)
      
      _instance
    }
  }
  
  implicit class IntervalScalaSupport(that: Interval) {
    def max: ValueSpecification = that.getMax
    def max_=(value: ValueSpecification): Unit = that.setMax(value)
    def max_=(value: ⇒ Option[ValueSpecification]): Unit =
      that.setMax(UMLPackageScalaSupport._umlBuilder.ref(value))
    def min: ValueSpecification = that.getMin
    def min_=(value: ValueSpecification): Unit = that.setMin(value)
    def min_=(value: ⇒ Option[ValueSpecification]): Unit =
      that.setMin(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object IntervalScalaSupport extends IntervalScalaSupport
