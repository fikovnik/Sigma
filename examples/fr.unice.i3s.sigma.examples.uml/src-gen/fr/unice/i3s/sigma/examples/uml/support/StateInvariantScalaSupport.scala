package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

trait StateInvariantScalaSupport extends EMFScalaSupport {
  type StateInvariant = org.eclipse.uml2.uml.StateInvariant
  
  protected implicit val _stateinvariantProxyBuilder = new EMFProxyBuilder[StateInvariant](UMLPackageScalaSupport._umlBuilder)
  
  object StateInvariant {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, covered: EList[Lifeline] = null, generalOrdering: EList[GeneralOrdering] = null, invariant: Constraint = null): StateInvariant = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[StateInvariant]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (covered != null) _instance.getCovereds.addAll(covered)
      if (generalOrdering != null) _instance.getGeneralOrderings.addAll(generalOrdering)
      if (invariant != null) _instance.setInvariant(invariant)
      
      _instance
    }
  }
  
  implicit class StateInvariantScalaSupport(that: StateInvariant) {
    def invariant: Constraint = that.getInvariant
    def invariant_=(value: Constraint): Unit = that.setInvariant(value)
  }
}

object StateInvariantScalaSupport extends StateInvariantScalaSupport
