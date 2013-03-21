package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

trait RegionScalaSupport {
  implicit class RegionScalaSupport(that: Region) {
    def extendedRegion: Region = that.getExtendedRegion
    def extendedRegion_=(value: Region): Unit = that.setExtendedRegion(value)
    def state: State = that.getState
    def state_=(value: State): Unit = that.setState(value)
    def stateMachine: StateMachine = that.getStateMachine
    def stateMachine_=(value: StateMachine): Unit = that.setStateMachine(value)
    def transition: EList[Transition] = that.getTransitions
    def subvertex: EList[Vertex] = that.getSubvertices
  }
}

object RegionScalaSupport extends RegionScalaSupport
