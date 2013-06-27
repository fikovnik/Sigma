package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait PseudostateScalaSupport extends EMFScalaSupport {
  type Pseudostate = org.eclipse.uml2.uml.Pseudostate
  
  protected implicit val _pseudostateProxyBuilder = new EMFProxyBuilder[Pseudostate](UMLPackageScalaSupport._umlBuilder)
  
  object Pseudostate {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, kind: PseudostateKind = PseudostateKind.INITIAL_LITERAL): Pseudostate = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Pseudostate]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (kind != PseudostateKind.INITIAL_LITERAL) _instance.setKind(kind)
      
      _instance
    }
  }
  
  implicit class PseudostateScalaSupport(that: Pseudostate) {
    def state: State = that.getState
    def state_=(value: State): Unit = that.setState(value)
    def state_=(value: ⇒ Option[State]): Unit =
      that.setState(UMLPackageScalaSupport._umlBuilder.ref(value))
    def kind: PseudostateKind = that.getKind
    def kind_=(value: PseudostateKind): Unit = that.setKind(value)
    def stateMachine: StateMachine = that.getStateMachine
    def stateMachine_=(value: StateMachine): Unit = that.setStateMachine(value)
    def stateMachine_=(value: ⇒ Option[StateMachine]): Unit =
      that.setStateMachine(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object PseudostateScalaSupport extends PseudostateScalaSupport
