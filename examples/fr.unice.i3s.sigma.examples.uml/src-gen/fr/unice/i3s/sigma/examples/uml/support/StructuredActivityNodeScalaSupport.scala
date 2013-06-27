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
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.VisibilityKind;

trait StructuredActivityNodeScalaSupport extends EMFScalaSupport {
  type StructuredActivityNode = org.eclipse.uml2.uml.StructuredActivityNode
  
  protected implicit val _structuredactivitynodeProxyBuilder = new EMFProxyBuilder[StructuredActivityNode](UMLPackageScalaSupport._umlBuilder)
  
  object StructuredActivityNode {
    def apply(): StructuredActivityNode = {
      UMLPackageScalaSupport._umlBuilder.create[StructuredActivityNode]
    }
  }
  
  implicit class StructuredActivityNodeScalaSupport(that: StructuredActivityNode) {
    def mustIsolate: Boolean = that.isMustIsolate
    def mustIsolate_=(value: Boolean): Unit = that.setMustIsolate(value)
    def node: EList[ActivityNode] = that.getNodes
    def structuredNodeInput: EList[InputPin] = that.getStructuredNodeInputs
    def structuredNodeOutput: EList[OutputPin] = that.getStructuredNodeOutputs
    def variable: EList[Variable] = that.getVariables
    def edge: EList[ActivityEdge] = that.getEdges
  }
}

object StructuredActivityNodeScalaSupport extends StructuredActivityNodeScalaSupport
