package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActionInputPin;
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
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

trait ActionInputPinScalaSupport extends EMFScalaSupport {
  type ActionInputPin = org.eclipse.uml2.uml.ActionInputPin
  
  protected implicit val _actioninputpinProxyBuilder = new EMFProxyBuilder[ActionInputPin](UMLPackageScalaSupport._umlBuilder)
  
  object ActionInputPin {
    def apply(): ActionInputPin = {
      UMLPackageScalaSupport._umlBuilder.create[ActionInputPin]
    }
  }
  
  implicit class ActionInputPinScalaSupport(that: ActionInputPin) {
    def fromAction: Action = that.getFromAction
    def fromAction_=(value: Action): Unit = that.setFromAction(value)
  }
}

object ActionInputPinScalaSupport extends ActionInputPinScalaSupport
