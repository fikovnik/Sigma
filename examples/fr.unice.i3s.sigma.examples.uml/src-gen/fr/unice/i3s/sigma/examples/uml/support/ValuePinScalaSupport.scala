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
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValuePin;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

trait ValuePinScalaSupport extends EMFScalaSupport {
  type ValuePin = org.eclipse.uml2.uml.ValuePin
  
  protected implicit val _valuepinProxyBuilder = new EMFProxyBuilder[ValuePin](UMLPackageScalaSupport._umlBuilder)
  
  object ValuePin {
    def apply(): ValuePin = {
      UMLPackageScalaSupport._umlBuilder.create[ValuePin]
    }
  }
  
  implicit class ValuePinScalaSupport(that: ValuePin) {
    def value: ValueSpecification = that.getValue
    def value_=(value: ValueSpecification): Unit = that.setValue(value)
  }
}

object ValuePinScalaSupport extends ValuePinScalaSupport
