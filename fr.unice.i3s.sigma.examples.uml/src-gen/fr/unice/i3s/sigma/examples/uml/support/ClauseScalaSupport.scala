package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Clause;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.OutputPin;

trait ClauseScalaSupport {
  implicit class ClauseScalaSupport(that: Clause) {
    def body: EList[ExecutableNode] = that.getBodies
    def bodyOutput: EList[OutputPin] = that.getBodyOutputs
    def decider: OutputPin = that.getDecider
    def decider_=(value: OutputPin): Unit = that.setDecider(value)
    def predecessorClause: EList[Clause] = that.getPredecessorClauses
    def successorClause: EList[Clause] = that.getSuccessorClauses
    def test: EList[ExecutableNode] = that.getTests
  }
}

object ClauseScalaSupport extends ClauseScalaSupport
