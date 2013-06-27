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
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.SequenceNode;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.VisibilityKind;

trait SequenceNodeScalaSupport extends EMFScalaSupport {
  type SequenceNode = org.eclipse.uml2.uml.SequenceNode
  
  protected implicit val _sequencenodeProxyBuilder = new EMFProxyBuilder[SequenceNode](UMLPackageScalaSupport._umlBuilder)
  
  object SequenceNode {
    def apply(): SequenceNode = {
      UMLPackageScalaSupport._umlBuilder.create[SequenceNode]
    }
  }
  
  implicit class SequenceNodeScalaSupport(that: SequenceNode) {
    def executableNode: EList[ExecutableNode] = that.getExecutableNodes
  }
}

object SequenceNodeScalaSupport extends SequenceNodeScalaSupport
