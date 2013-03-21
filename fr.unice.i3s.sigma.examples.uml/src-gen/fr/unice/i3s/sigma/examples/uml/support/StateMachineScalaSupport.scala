package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;

trait StateMachineScalaSupport {
  implicit class StateMachineScalaSupport(that: StateMachine) {
    def connectionPoint: EList[Pseudostate] = that.getConnectionPoints
    def submachineState: EList[State] = that.getSubmachineStates
    def region: EList[Region] = that.getRegions
    def extendedStateMachine: EList[StateMachine] = that.getExtendedStateMachines
  }
}

object StateMachineScalaSupport extends StateMachineScalaSupport
