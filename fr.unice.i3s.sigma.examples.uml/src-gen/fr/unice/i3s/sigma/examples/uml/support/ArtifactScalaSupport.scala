package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

trait ArtifactScalaSupport {
  implicit class ArtifactScalaSupport(that: Artifact) {
    def fileName: String = that.getFileName
    def fileName_=(value: String): Unit = that.setFileName(value)
    def manifestation: EList[Manifestation] = that.getManifestations
    def nestedArtifact: EList[Artifact] = that.getNestedArtifacts
    def ownedAttribute: EList[Property] = that.getOwnedAttributes
    def ownedOperation: EList[Operation] = that.getOwnedOperations
  }
}

object ArtifactScalaSupport extends ArtifactScalaSupport
