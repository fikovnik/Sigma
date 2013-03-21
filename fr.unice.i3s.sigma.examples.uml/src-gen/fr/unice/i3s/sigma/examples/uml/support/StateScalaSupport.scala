package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Trigger;

trait StateScalaSupport {
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
    def stateInvariant: Constraint = that.getStateInvariant
    def stateInvariant_=(value: Constraint): Unit = that.setStateInvariant(value)
    def submachine: StateMachine = that.getSubmachine
    def submachine_=(value: StateMachine): Unit = that.setSubmachine(value)
    def region: EList[Region] = that.getRegions
  }
}

object StateScalaSupport extends StateScalaSupport
