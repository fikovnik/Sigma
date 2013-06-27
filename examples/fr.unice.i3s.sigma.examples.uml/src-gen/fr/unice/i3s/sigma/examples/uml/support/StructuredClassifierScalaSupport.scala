package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

trait StructuredClassifierScalaSupport extends EMFScalaSupport {
  type StructuredClassifier = org.eclipse.uml2.uml.StructuredClassifier
  
  protected implicit val _structuredclassifierProxyBuilder = new EMFProxyBuilder[StructuredClassifier](UMLPackageScalaSupport._umlBuilder)
  
  object StructuredClassifier {
    def apply(): StructuredClassifier = {
      UMLPackageScalaSupport._umlBuilder.create[StructuredClassifier]
    }
  }
  
  implicit class StructuredClassifierScalaSupport(that: StructuredClassifier) {
    def ownedAttribute: EList[Property] = that.getOwnedAttributes
    def ownedConnector: EList[Connector] = that.getOwnedConnectors
    def part: EList[Property] = that.getParts
    def role: EList[ConnectableElement] = that.getRoles
  }
}

object StructuredClassifierScalaSupport extends StructuredClassifierScalaSupport
