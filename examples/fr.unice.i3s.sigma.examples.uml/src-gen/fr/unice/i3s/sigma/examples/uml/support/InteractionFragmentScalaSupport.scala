package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait InteractionFragmentScalaSupport extends EMFScalaSupport {
  type InteractionFragment = org.eclipse.uml2.uml.InteractionFragment
  
  protected implicit val _interactionfragmentProxyBuilder = new EMFProxyBuilder[InteractionFragment](UMLPackageScalaSupport._umlBuilder)
  
  object InteractionFragment {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, covered: EList[Lifeline] = null, generalOrdering: EList[GeneralOrdering] = null): InteractionFragment = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[InteractionFragment]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (covered != null) _instance.getCovereds.addAll(covered)
      if (generalOrdering != null) _instance.getGeneralOrderings.addAll(generalOrdering)
      
      _instance
    }
  }
  
  implicit class InteractionFragmentScalaSupport(that: InteractionFragment) {
    def covered: EList[Lifeline] = that.getCovereds
    def enclosingInteraction: Interaction = that.getEnclosingInteraction
    def enclosingInteraction_=(value: Interaction): Unit = that.setEnclosingInteraction(value)
    def enclosingInteraction_=(value: ⇒ Option[Interaction]): Unit =
      that.setEnclosingInteraction(UMLPackageScalaSupport._umlBuilder.ref(value))
    def enclosingOperand: InteractionOperand = that.getEnclosingOperand
    def enclosingOperand_=(value: InteractionOperand): Unit = that.setEnclosingOperand(value)
    def enclosingOperand_=(value: ⇒ Option[InteractionOperand]): Unit =
      that.setEnclosingOperand(UMLPackageScalaSupport._umlBuilder.ref(value))
    def generalOrdering: EList[GeneralOrdering] = that.getGeneralOrderings
  }
}

object InteractionFragmentScalaSupport extends InteractionFragmentScalaSupport
