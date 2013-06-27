package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Clause;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConditionalNode;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.VisibilityKind;

trait ConditionalNodeScalaSupport extends EMFScalaSupport {
  type ConditionalNode = org.eclipse.uml2.uml.ConditionalNode
  
  protected implicit val _conditionalnodeProxyBuilder = new EMFProxyBuilder[ConditionalNode](UMLPackageScalaSupport._umlBuilder)
  
  object ConditionalNode {
    def apply(): ConditionalNode = {
      UMLPackageScalaSupport._umlBuilder.create[ConditionalNode]
    }
  }
  
  implicit class ConditionalNodeScalaSupport(that: ConditionalNode) {
    def clause: EList[Clause] = that.getClauses
    def isAssured: Boolean = that.isAssured
    def isAssured_=(value: Boolean): Unit = that.setIsAssured(value)
    def isDeterminate: Boolean = that.isDeterminate
    def isDeterminate_=(value: Boolean): Unit = that.setIsDeterminate(value)
    def result: EList[OutputPin] = that.getResults
  }
}

object ConditionalNodeScalaSupport extends ConditionalNodeScalaSupport
