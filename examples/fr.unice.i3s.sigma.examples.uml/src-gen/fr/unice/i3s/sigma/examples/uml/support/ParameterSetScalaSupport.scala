package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

trait ParameterSetScalaSupport extends EMFScalaSupport {
  type ParameterSet = org.eclipse.uml2.uml.ParameterSet
  
  protected implicit val _parametersetProxyBuilder = new EMFProxyBuilder[ParameterSet](UMLPackageScalaSupport._umlBuilder)
  
  object ParameterSet {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, condition: EList[Constraint] = null, parameter: EList[Parameter] = null): ParameterSet = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ParameterSet]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (condition != null) _instance.getConditions.addAll(condition)
      if (parameter != null) _instance.getParameters.addAll(parameter)
      
      _instance
    }
  }
  
  implicit class ParameterSetScalaSupport(that: ParameterSet) {
    def condition: EList[Constraint] = that.getConditions
    def parameter: EList[Parameter] = that.getParameters
  }
}

object ParameterSetScalaSupport extends ParameterSetScalaSupport
