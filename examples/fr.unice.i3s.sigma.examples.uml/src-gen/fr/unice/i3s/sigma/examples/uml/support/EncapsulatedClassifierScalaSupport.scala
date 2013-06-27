package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

trait EncapsulatedClassifierScalaSupport extends EMFScalaSupport {
  type EncapsulatedClassifier = org.eclipse.uml2.uml.EncapsulatedClassifier
  
  protected implicit val _encapsulatedclassifierProxyBuilder = new EMFProxyBuilder[EncapsulatedClassifier](UMLPackageScalaSupport._umlBuilder)
  
  object EncapsulatedClassifier {
    def apply(): EncapsulatedClassifier = {
      UMLPackageScalaSupport._umlBuilder.create[EncapsulatedClassifier]
    }
  }
  
  implicit class EncapsulatedClassifierScalaSupport(that: EncapsulatedClassifier) {
    def ownedPort: EList[Port] = that.getOwnedPorts
  }
}

object EncapsulatedClassifierScalaSupport extends EncapsulatedClassifierScalaSupport
