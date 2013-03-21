package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.DeploymentTarget;
import org.eclipse.uml2.uml.PackageableElement;

trait DeploymentTargetScalaSupport {
  implicit class DeploymentTargetScalaSupport(that: DeploymentTarget) {
    def deployedElement: EList[PackageableElement] = that.getDeployedElements
    def deployment: EList[Deployment] = that.getDeployments
  }
}

object DeploymentTargetScalaSupport extends DeploymentTargetScalaSupport
