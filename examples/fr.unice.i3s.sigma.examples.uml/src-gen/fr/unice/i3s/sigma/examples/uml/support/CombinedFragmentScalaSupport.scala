package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

trait CombinedFragmentScalaSupport extends EMFScalaSupport {
  type CombinedFragment = org.eclipse.uml2.uml.CombinedFragment
  
  protected implicit val _combinedfragmentProxyBuilder = new EMFProxyBuilder[CombinedFragment](UMLPackageScalaSupport._umlBuilder)
  
  object CombinedFragment {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, covered: EList[Lifeline] = null, generalOrdering: EList[GeneralOrdering] = null, cfragmentGate: EList[Gate] = null, interactionOperator: InteractionOperatorKind = InteractionOperatorKind.SEQ_LITERAL, operand: EList[InteractionOperand] = null): CombinedFragment = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[CombinedFragment]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (covered != null) _instance.getCovereds.addAll(covered)
      if (generalOrdering != null) _instance.getGeneralOrderings.addAll(generalOrdering)
      if (cfragmentGate != null) _instance.getCfragmentGates.addAll(cfragmentGate)
      if (interactionOperator != InteractionOperatorKind.SEQ_LITERAL) _instance.setInteractionOperator(interactionOperator)
      if (operand != null) _instance.getOperands.addAll(operand)
      
      _instance
    }
  }
  
  implicit class CombinedFragmentScalaSupport(that: CombinedFragment) {
    def cfragmentGate: EList[Gate] = that.getCfragmentGates
    def interactionOperator: InteractionOperatorKind = that.getInteractionOperator
    def interactionOperator_=(value: InteractionOperatorKind): Unit = that.setInteractionOperator(value)
    def operand: EList[InteractionOperand] = that.getOperands
  }
}

object CombinedFragmentScalaSupport extends CombinedFragmentScalaSupport
