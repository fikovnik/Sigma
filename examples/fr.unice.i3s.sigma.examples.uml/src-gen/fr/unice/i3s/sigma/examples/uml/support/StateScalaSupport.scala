package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait StateScalaSupport extends EMFScalaSupport {
  type State = org.eclipse.uml2.uml.State
  
  protected implicit val _stateProxyBuilder = new EMFProxyBuilder[State](UMLPackageScalaSupport._umlBuilder)
  
  object State {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, elementImport: EList[ElementImport] = null, packageImport: EList[PackageImport] = null, ownedRule: EList[Constraint] = null, isLeaf: Boolean = false, connection: EList[ConnectionPointReference] = null, connectionPoint: EList[Pseudostate] = null, deferrableTrigger: EList[Trigger] = null, doActivity: Behavior = null, entry: Behavior = null, exit: Behavior = null, redefinedState: State = null, stateInvariant: Constraint = null, submachine: StateMachine = null, region: EList[Region] = null): State = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[State]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (elementImport != null) _instance.getElementImports.addAll(elementImport)
      if (packageImport != null) _instance.getPackageImports.addAll(packageImport)
      if (ownedRule != null) _instance.getOwnedRules.addAll(ownedRule)
      if (isLeaf != false) _instance.setIsLeaf(isLeaf)
      if (connection != null) _instance.getConnections.addAll(connection)
      if (connectionPoint != null) _instance.getConnectionPoints.addAll(connectionPoint)
      if (deferrableTrigger != null) _instance.getDeferrableTriggers.addAll(deferrableTrigger)
      if (doActivity != null) _instance.setDoActivity(doActivity)
      if (entry != null) _instance.setEntry(entry)
      if (exit != null) _instance.setExit(exit)
      if (redefinedState != null) _instance.setRedefinedState(redefinedState)
      if (stateInvariant != null) _instance.setStateInvariant(stateInvariant)
      if (submachine != null) _instance.setSubmachine(submachine)
      if (region != null) _instance.getRegions.addAll(region)
      
      _instance
    }
  }
  
  implicit class StateScalaSupport(that: State) {
    def connection: EList[ConnectionPointReference] = that.getConnections
    def connectionPoint: EList[Pseudostate] = that.getConnectionPoints
    def deferrableTrigger: EList[Trigger] = that.getDeferrableTriggers
    def doActivity: Behavior = that.getDoActivity
    def doActivity_=(value: Behavior): Unit = that.setDoActivity(value)
    def entry: Behavior = that.getEntry
    def entry_=(value: Behavior): Unit = that.setEntry(value)
    def exit: Behavior = that.getExit
    def exit_=(value: Behavior): Unit = that.setExit(value)
    def isComposite: Boolean = that.isComposite
    def isOrthogonal: Boolean = that.isOrthogonal
    def isSimple: Boolean = that.isSimple
    def isSubmachineState: Boolean = that.isSubmachineState
    def redefinedState: State = that.getRedefinedState
    def redefinedState_=(value: State): Unit = that.setRedefinedState(value)
    def redefinedState_=(value: ⇒ Option[State]): Unit =
      that.setRedefinedState(UMLPackageScalaSupport._umlBuilder.ref(value))
    def stateInvariant: Constraint = that.getStateInvariant
    def stateInvariant_=(value: Constraint): Unit = that.setStateInvariant(value)
    def stateInvariant_=(value: ⇒ Option[Constraint]): Unit =
      that.setStateInvariant(UMLPackageScalaSupport._umlBuilder.ref(value))
    def submachine: StateMachine = that.getSubmachine
    def submachine_=(value: StateMachine): Unit = that.setSubmachine(value)
    def submachine_=(value: ⇒ Option[StateMachine]): Unit =
      that.setSubmachine(UMLPackageScalaSupport._umlBuilder.ref(value))
    def region: EList[Region] = that.getRegions
  }
}

object StateScalaSupport extends StateScalaSupport
