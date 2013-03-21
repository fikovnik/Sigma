package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;

trait PseudostateScalaSupport {
  implicit class PseudostateScalaSupport(that: Pseudostate) {
    def state: State = that.getState
    def state_=(value: State): Unit = that.setState(value)
    def kind: PseudostateKind = that.getKind
    def kind_=(value: PseudostateKind): Unit = that.setKind(value)
    def stateMachine: StateMachine = that.getStateMachine
    def stateMachine_=(value: StateMachine): Unit = that.setStateMachine(value)
  }
}

object PseudostateScalaSupport extends PseudostateScalaSupport
