package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait InstanceValueScalaSupport extends EMFScalaSupport {
  type InstanceValue = org.eclipse.uml2.uml.InstanceValue
  
  protected implicit val _instancevalueProxyBuilder = new EMFProxyBuilder[InstanceValue](UMLPackageScalaSupport._umlBuilder)
  
  object InstanceValue {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, type_ : Type = null, instance: InstanceSpecification = null): InstanceValue = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[InstanceValue]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (type_  != null) _instance.setType(type_ )
      if (instance != null) _instance.setInstance(instance)
      
      _instance
    }
  }
  
  implicit class InstanceValueScalaSupport(that: InstanceValue) {
    def instance: InstanceSpecification = that.getInstance
    def instance_=(value: InstanceSpecification): Unit = that.setInstance(value)
    def instance_=(value: ⇒ Option[InstanceSpecification]): Unit =
      that.setInstance(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object InstanceValueScalaSupport extends InstanceValueScalaSupport
