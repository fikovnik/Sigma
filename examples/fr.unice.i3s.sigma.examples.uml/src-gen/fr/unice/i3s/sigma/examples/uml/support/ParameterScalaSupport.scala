package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.ParameterEffectKind;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

trait ParameterScalaSupport extends EMFScalaSupport {
  type Parameter = org.eclipse.uml2.uml.Parameter
  
  protected implicit val _parameterProxyBuilder = new EMFProxyBuilder[Parameter](UMLPackageScalaSupport._umlBuilder)
  
  object Parameter {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, type_ : Type = null, templateParameter: TemplateParameter = null, isOrdered: Boolean = false, isUnique: Boolean = true, lowerValue: ValueSpecification = null, upperValue: ValueSpecification = null, defaultValue: ValueSpecification = null, direction: ParameterDirectionKind = ParameterDirectionKind.IN_LITERAL, effect: ParameterEffectKind = ParameterEffectKind.CREATE_LITERAL, isException: Boolean = false, isStream: Boolean = false, parameterSet: EList[ParameterSet] = null): Parameter = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Parameter]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (type_  != null) _instance.setType(type_ )
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (isOrdered != false) _instance.setIsOrdered(isOrdered)
      if (isUnique != true) _instance.setIsUnique(isUnique)
      if (lowerValue != null) _instance.setLowerValue(lowerValue)
      if (upperValue != null) _instance.setUpperValue(upperValue)
      if (defaultValue != null) _instance.setDefaultValue(defaultValue)
      if (direction != ParameterDirectionKind.IN_LITERAL) _instance.setDirection(direction)
      if (effect != ParameterEffectKind.CREATE_LITERAL) _instance.setEffect(effect)
      if (isException != false) _instance.setIsException(isException)
      if (isStream != false) _instance.setIsStream(isStream)
      if (parameterSet != null) _instance.getParameterSets.addAll(parameterSet)
      
      _instance
    }
  }
  
  implicit class ParameterScalaSupport(that: Parameter) {
    def default: String = that.getDefault
    def default_=(value: String): Unit = that.setDefault(value)
    def defaultValue: ValueSpecification = that.getDefaultValue
    def defaultValue_=(value: ValueSpecification): Unit = that.setDefaultValue(value)
    def direction: ParameterDirectionKind = that.getDirection
    def direction_=(value: ParameterDirectionKind): Unit = that.setDirection(value)
    def effect: ParameterEffectKind = that.getEffect
    def effect_=(value: ParameterEffectKind): Unit = that.setEffect(value)
    def isException: Boolean = that.isException
    def isException_=(value: Boolean): Unit = that.setIsException(value)
    def isStream: Boolean = that.isStream
    def isStream_=(value: Boolean): Unit = that.setIsStream(value)
    def operation: Operation = that.getOperation
    def parameterSet: EList[ParameterSet] = that.getParameterSets
  }
}

object ParameterScalaSupport extends ParameterScalaSupport
