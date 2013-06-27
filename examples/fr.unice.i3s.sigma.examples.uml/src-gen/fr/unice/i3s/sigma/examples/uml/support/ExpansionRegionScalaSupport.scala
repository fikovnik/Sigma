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
import org.eclipse.uml2.uml.ExpansionKind;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.ExpansionRegion;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.VisibilityKind;

trait ExpansionRegionScalaSupport extends EMFScalaSupport {
  type ExpansionRegion = org.eclipse.uml2.uml.ExpansionRegion
  
  protected implicit val _expansionregionProxyBuilder = new EMFProxyBuilder[ExpansionRegion](UMLPackageScalaSupport._umlBuilder)
  
  object ExpansionRegion {
    def apply(): ExpansionRegion = {
      UMLPackageScalaSupport._umlBuilder.create[ExpansionRegion]
    }
  }
  
  implicit class ExpansionRegionScalaSupport(that: ExpansionRegion) {
    def mode: ExpansionKind = that.getMode
    def mode_=(value: ExpansionKind): Unit = that.setMode(value)
    def outputElement: EList[ExpansionNode] = that.getOutputElements
    def inputElement: EList[ExpansionNode] = that.getInputElements
  }
}

object ExpansionRegionScalaSupport extends ExpansionRegionScalaSupport
