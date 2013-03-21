package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.State;

trait ConnectionPointReferenceScalaSupport {
  implicit class ConnectionPointReferenceScalaSupport(that: ConnectionPointReference) {
    def entry: EList[Pseudostate] = that.getEntries
    def exit: EList[Pseudostate] = that.getExits
    def state: State = that.getState
    def state_=(value: State): Unit = that.setState(value)
  }
}

object ConnectionPointReferenceScalaSupport extends ConnectionPointReferenceScalaSupport
