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

trait ArtifactScalaSupport extends EMFScalaSupport {
  type Artifact = org.eclipse.uml2.uml.Artifact
  
  protected implicit val _artifactProxyBuilder = new EMFProxyBuilder[Artifact](UMLPackageScalaSupport._umlBuilder)
  
  object Artifact {
    def apply(): Artifact = {
      UMLPackageScalaSupport._umlBuilder.create[Artifact]
    }
  }
  
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
