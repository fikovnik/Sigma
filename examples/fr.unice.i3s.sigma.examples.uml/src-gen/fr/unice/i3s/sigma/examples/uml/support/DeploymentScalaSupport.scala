package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DeployedArtifact;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.DeploymentSpecification;
import org.eclipse.uml2.uml.DeploymentTarget;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait DeploymentScalaSupport extends EMFScalaSupport {
  type Deployment = org.eclipse.uml2.uml.Deployment
  
  protected implicit val _deploymentProxyBuilder = new EMFProxyBuilder[Deployment](UMLPackageScalaSupport._umlBuilder)
  
  object Deployment {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, client: EList[NamedElement] = null, supplier: EList[NamedElement] = null, configuration: EList[DeploymentSpecification] = null, deployedArtifact: EList[DeployedArtifact] = null): Deployment = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Deployment]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (client != null) _instance.getClients.addAll(client)
      if (supplier != null) _instance.getSuppliers.addAll(supplier)
      if (configuration != null) _instance.getConfigurations.addAll(configuration)
      if (deployedArtifact != null) _instance.getDeployedArtifacts.addAll(deployedArtifact)
      
      _instance
    }
  }
  
  implicit class DeploymentScalaSupport(that: Deployment) {
    def configuration: EList[DeploymentSpecification] = that.getConfigurations
    def deployedArtifact: EList[DeployedArtifact] = that.getDeployedArtifacts
    def location: DeploymentTarget = that.getLocation
    def location_=(value: DeploymentTarget): Unit = that.setLocation(value)
    def location_=(value: ⇒ Option[DeploymentTarget]): Unit =
      that.setLocation(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object DeploymentScalaSupport extends DeploymentScalaSupport
