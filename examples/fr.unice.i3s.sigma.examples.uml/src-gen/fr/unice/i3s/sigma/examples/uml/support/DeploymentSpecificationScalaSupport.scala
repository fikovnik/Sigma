package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.DeploymentSpecification;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait DeploymentSpecificationScalaSupport extends EMFScalaSupport {
  type DeploymentSpecification = org.eclipse.uml2.uml.DeploymentSpecification
  
  protected implicit val _deploymentspecificationProxyBuilder = new EMFProxyBuilder[DeploymentSpecification](UMLPackageScalaSupport._umlBuilder)
  
  object DeploymentSpecification {
    def apply(): DeploymentSpecification = {
      UMLPackageScalaSupport._umlBuilder.create[DeploymentSpecification]
    }
  }
  
  implicit class DeploymentSpecificationScalaSupport(that: DeploymentSpecification) {
    def deploymentLocation: String = that.getDeploymentLocation
    def deploymentLocation_=(value: String): Unit = that.setDeploymentLocation(value)
    def executionLocation: String = that.getExecutionLocation
    def executionLocation_=(value: String): Unit = that.setExecutionLocation(value)
    def deployment: Deployment = that.getDeployment
    def deployment_=(value: Deployment): Unit = that.setDeployment(value)
    def deployment_=(value: ⇒ Option[Deployment]): Unit =
      that.setDeployment(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object DeploymentSpecificationScalaSupport extends DeploymentSpecificationScalaSupport
