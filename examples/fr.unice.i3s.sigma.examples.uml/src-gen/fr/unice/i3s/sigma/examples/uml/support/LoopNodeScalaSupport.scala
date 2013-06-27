package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait LoopNodeScalaSupport extends EMFScalaSupport {
  type LoopNode = org.eclipse.uml2.uml.LoopNode
  
  protected implicit val _loopnodeProxyBuilder = new EMFProxyBuilder[LoopNode](UMLPackageScalaSupport._umlBuilder)
  
  object LoopNode {
    def apply(): LoopNode = {
      UMLPackageScalaSupport._umlBuilder.create[LoopNode]
    }
  }
  
  implicit class LoopNodeScalaSupport(that: LoopNode) {
    def bodyOutput: EList[OutputPin] = that.getBodyOutputs
    def bodyPart: EList[ExecutableNode] = that.getBodyParts
    def decider: OutputPin = that.getDecider
    def decider_=(value: OutputPin): Unit = that.setDecider(value)
    def decider_=(value: ⇒ Option[OutputPin]): Unit =
      that.setDecider(UMLPackageScalaSupport._umlBuilder.ref(value))
    def isTestedFirst: Boolean = that.isTestedFirst
    def isTestedFirst_=(value: Boolean): Unit = that.setIsTestedFirst(value)
    def loopVariable: EList[OutputPin] = that.getLoopVariables
    def loopVariableInput: EList[InputPin] = that.getLoopVariableInputs
    def result: EList[OutputPin] = that.getResults
    def setupPart: EList[ExecutableNode] = that.getSetupParts
    def test: EList[ExecutableNode] = that.getTests
  }
}

object LoopNodeScalaSupport extends LoopNodeScalaSupport
