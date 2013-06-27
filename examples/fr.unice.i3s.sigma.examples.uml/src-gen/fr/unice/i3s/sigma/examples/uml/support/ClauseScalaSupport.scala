package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Clause;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.OutputPin;

import scala.Option;

trait ClauseScalaSupport extends EMFScalaSupport {
  type Clause = org.eclipse.uml2.uml.Clause
  
  protected implicit val _clauseProxyBuilder = new EMFProxyBuilder[Clause](UMLPackageScalaSupport._umlBuilder)
  
  object Clause {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, body: EList[ExecutableNode] = null, bodyOutput: EList[OutputPin] = null, decider: OutputPin = null, predecessorClause: EList[Clause] = null, successorClause: EList[Clause] = null, test: EList[ExecutableNode] = null): Clause = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Clause]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (body != null) _instance.getBodies.addAll(body)
      if (bodyOutput != null) _instance.getBodyOutputs.addAll(bodyOutput)
      if (decider != null) _instance.setDecider(decider)
      if (predecessorClause != null) _instance.getPredecessorClauses.addAll(predecessorClause)
      if (successorClause != null) _instance.getSuccessorClauses.addAll(successorClause)
      if (test != null) _instance.getTests.addAll(test)
      
      _instance
    }
  }
  
  implicit class ClauseScalaSupport(that: Clause) {
    def body: EList[ExecutableNode] = that.getBodies
    def bodyOutput: EList[OutputPin] = that.getBodyOutputs
    def decider: OutputPin = that.getDecider
    def decider_=(value: OutputPin): Unit = that.setDecider(value)
    def decider_=(value: ⇒ Option[OutputPin]): Unit =
      that.setDecider(UMLPackageScalaSupport._umlBuilder.ref(value))
    def predecessorClause: EList[Clause] = that.getPredecessorClauses
    def successorClause: EList[Clause] = that.getSuccessorClauses
    def test: EList[ExecutableNode] = that.getTests
  }
}

object ClauseScalaSupport extends ClauseScalaSupport
