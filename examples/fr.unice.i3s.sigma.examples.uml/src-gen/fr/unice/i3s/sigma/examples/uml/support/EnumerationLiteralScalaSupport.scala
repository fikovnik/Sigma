package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait EnumerationLiteralScalaSupport extends EMFScalaSupport {
  type EnumerationLiteral = org.eclipse.uml2.uml.EnumerationLiteral
  
  protected implicit val _enumerationliteralProxyBuilder = new EMFProxyBuilder[EnumerationLiteral](UMLPackageScalaSupport._umlBuilder)
  
  object EnumerationLiteral {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, deployment: EList[Deployment] = null, templateParameter: TemplateParameter = null, classifier: EList[Classifier] = null, slot: EList[Slot] = null, specification: ValueSpecification = null): EnumerationLiteral = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[EnumerationLiteral]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (deployment != null) _instance.getDeployments.addAll(deployment)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (classifier != null) _instance.getClassifiers.addAll(classifier)
      if (slot != null) _instance.getSlots.addAll(slot)
      if (specification != null) _instance.setSpecification(specification)
      
      _instance
    }
  }
  
  implicit class EnumerationLiteralScalaSupport(that: EnumerationLiteral) {
    def enumeration: Enumeration = that.getEnumeration
    def enumeration_=(value: Enumeration): Unit = that.setEnumeration(value)
    def enumeration_=(value: ⇒ Option[Enumeration]): Unit =
      that.setEnumeration(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object EnumerationLiteralScalaSupport extends EnumerationLiteralScalaSupport
