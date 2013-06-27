package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

trait InteractionOperandScalaSupport extends EMFScalaSupport {
  type InteractionOperand = org.eclipse.uml2.uml.InteractionOperand
  
  protected implicit val _interactionoperandProxyBuilder = new EMFProxyBuilder[InteractionOperand](UMLPackageScalaSupport._umlBuilder)
  
  object InteractionOperand {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, elementImport: EList[ElementImport] = null, packageImport: EList[PackageImport] = null, ownedRule: EList[Constraint] = null, covered: EList[Lifeline] = null, generalOrdering: EList[GeneralOrdering] = null, guard: InteractionConstraint = null, fragment: EList[InteractionFragment] = null): InteractionOperand = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[InteractionOperand]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (elementImport != null) _instance.getElementImports.addAll(elementImport)
      if (packageImport != null) _instance.getPackageImports.addAll(packageImport)
      if (ownedRule != null) _instance.getOwnedRules.addAll(ownedRule)
      if (covered != null) _instance.getCovereds.addAll(covered)
      if (generalOrdering != null) _instance.getGeneralOrderings.addAll(generalOrdering)
      if (guard != null) _instance.setGuard(guard)
      if (fragment != null) _instance.getFragments.addAll(fragment)
      
      _instance
    }
  }
  
  implicit class InteractionOperandScalaSupport(that: InteractionOperand) {
    def guard: InteractionConstraint = that.getGuard
    def guard_=(value: InteractionConstraint): Unit = that.setGuard(value)
    def fragment: EList[InteractionFragment] = that.getFragments
  }
}

object InteractionOperandScalaSupport extends InteractionOperandScalaSupport
