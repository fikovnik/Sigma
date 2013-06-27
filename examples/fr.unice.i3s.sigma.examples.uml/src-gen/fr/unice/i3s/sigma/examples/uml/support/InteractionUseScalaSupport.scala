package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait InteractionUseScalaSupport extends EMFScalaSupport {
  type InteractionUse = org.eclipse.uml2.uml.InteractionUse
  
  protected implicit val _interactionuseProxyBuilder = new EMFProxyBuilder[InteractionUse](UMLPackageScalaSupport._umlBuilder)
  
  object InteractionUse {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, covered: EList[Lifeline] = null, generalOrdering: EList[GeneralOrdering] = null, actualGate: EList[Gate] = null, argument: EList[ValueSpecification] = null, refersTo: Interaction = null, returnValue: ValueSpecification = null, returnValueRecipient: Property = null): InteractionUse = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[InteractionUse]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (covered != null) _instance.getCovereds.addAll(covered)
      if (generalOrdering != null) _instance.getGeneralOrderings.addAll(generalOrdering)
      if (actualGate != null) _instance.getActualGates.addAll(actualGate)
      if (argument != null) _instance.getArguments.addAll(argument)
      if (refersTo != null) _instance.setRefersTo(refersTo)
      if (returnValue != null) _instance.setReturnValue(returnValue)
      if (returnValueRecipient != null) _instance.setReturnValueRecipient(returnValueRecipient)
      
      _instance
    }
  }
  
  implicit class InteractionUseScalaSupport(that: InteractionUse) {
    def actualGate: EList[Gate] = that.getActualGates
    def argument: EList[ValueSpecification] = that.getArguments
    def refersTo: Interaction = that.getRefersTo
    def refersTo_=(value: Interaction): Unit = that.setRefersTo(value)
    def refersTo_=(value: ⇒ Option[Interaction]): Unit =
      that.setRefersTo(UMLPackageScalaSupport._umlBuilder.ref(value))
    def returnValue: ValueSpecification = that.getReturnValue
    def returnValue_=(value: ValueSpecification): Unit = that.setReturnValue(value)
    def returnValueRecipient: Property = that.getReturnValueRecipient
    def returnValueRecipient_=(value: Property): Unit = that.setReturnValueRecipient(value)
    def returnValueRecipient_=(value: ⇒ Option[Property]): Unit =
      that.setReturnValueRecipient(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object InteractionUseScalaSupport extends InteractionUseScalaSupport
