package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

trait OpaqueBehaviorScalaSupport extends EMFScalaSupport {
  type OpaqueBehavior = org.eclipse.uml2.uml.OpaqueBehavior
  
  protected implicit val _opaquebehaviorProxyBuilder = new EMFProxyBuilder[OpaqueBehavior](UMLPackageScalaSupport._umlBuilder)
  
  object OpaqueBehavior {
    def apply(): OpaqueBehavior = {
      UMLPackageScalaSupport._umlBuilder.create[OpaqueBehavior]
    }
  }
  
  implicit class OpaqueBehaviorScalaSupport(that: OpaqueBehavior) {
    def body: EList[String] = that.getBodies
    def language: EList[String] = that.getLanguages
  }
}

object OpaqueBehaviorScalaSupport extends OpaqueBehaviorScalaSupport
