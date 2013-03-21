package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.DeployedArtifact;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.DeploymentSpecification;
import org.eclipse.uml2.uml.DeploymentTarget;

trait DeploymentScalaSupport {
  implicit class DeploymentScalaSupport(that: Deployment) {
    def configuration: EList[DeploymentSpecification] = that.getConfigurations
    def deployedArtifact: EList[DeployedArtifact] = that.getDeployedArtifacts
    def location: DeploymentTarget = that.getLocation
    def location_=(value: DeploymentTarget): Unit = that.setLocation(value)
  }
}

object DeploymentScalaSupport extends DeploymentScalaSupport
