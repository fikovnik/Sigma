package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.DeployedArtifact;

trait DeployedArtifactScalaSupport {
  implicit class DeployedArtifactScalaSupport(that: DeployedArtifact) {
    
  }
}

object DeployedArtifactScalaSupport extends DeployedArtifactScalaSupport
