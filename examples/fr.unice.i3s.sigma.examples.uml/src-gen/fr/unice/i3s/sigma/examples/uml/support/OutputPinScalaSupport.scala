package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.ObjectNodeOrderingKind;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

trait OutputPinScalaSupport extends EMFScalaSupport {
  type OutputPin = org.eclipse.uml2.uml.OutputPin
  
  protected implicit val _outputpinProxyBuilder = new EMFProxyBuilder[OutputPin](UMLPackageScalaSupport._umlBuilder)
  
  object OutputPin {
    def apply(): OutputPin = {
      UMLPackageScalaSupport._umlBuilder.create[OutputPin]
    }
  }
}

object OutputPinScalaSupport extends OutputPinScalaSupport
