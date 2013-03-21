package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.DeploymentSpecification;

trait DeploymentSpecificationScalaSupport {
  implicit class DeploymentSpecificationScalaSupport(that: DeploymentSpecification) {
    def deploymentLocation: String = that.getDeploymentLocation
    def deploymentLocation_=(value: String): Unit = that.setDeploymentLocation(value)
    def executionLocation: String = that.getExecutionLocation
    def executionLocation_=(value: String): Unit = that.setExecutionLocation(value)
    def deployment: Deployment = that.getDeployment
    def deployment_=(value: Deployment): Unit = that.setDeployment(value)
  }
}

object DeploymentSpecificationScalaSupport extends DeploymentSpecificationScalaSupport
