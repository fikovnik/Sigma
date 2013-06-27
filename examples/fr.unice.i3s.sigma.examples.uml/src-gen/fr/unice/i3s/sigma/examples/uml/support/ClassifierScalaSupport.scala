package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.NamedElement;
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

trait ClassifierScalaSupport extends EMFScalaSupport {
  type Classifier = org.eclipse.uml2.uml.Classifier
  
  protected implicit val _classifierProxyBuilder = new EMFProxyBuilder[Classifier](UMLPackageScalaSupport._umlBuilder)
  
  object Classifier {
    def apply(): Classifier = {
      UMLPackageScalaSupport._umlBuilder.create[Classifier]
    }
  }
  
  implicit class ClassifierScalaSupport(that: Classifier) {
    def feature: EList[Feature] = that.getFeatures
    def attribute: EList[Property] = that.getAttributes
    def collaborationUse: EList[CollaborationUse] = that.getCollaborationUses
    def general: EList[Classifier] = that.getGenerals
    def generalization: EList[Generalization] = that.getGeneralizations
    def powertypeExtent: EList[GeneralizationSet] = that.getPowertypeExtents
    def inheritedMember: EList[NamedElement] = that.getInheritedMembers
    def isAbstract: Boolean = that.isAbstract
    def isAbstract_=(value: Boolean): Unit = that.setIsAbstract(value)
    def isFinalSpecialization: Boolean = that.isFinalSpecialization
    def isFinalSpecialization_=(value: Boolean): Unit = that.setIsFinalSpecialization(value)
    def ownedUseCase: EList[UseCase] = that.getOwnedUseCases
    def useCase: EList[UseCase] = that.getUseCases
    def redefinedClassifier: EList[Classifier] = that.getRedefinedClassifiers
    def representation: CollaborationUse = that.getRepresentation
    def representation_=(value: CollaborationUse): Unit = that.setRepresentation(value)
    def representation_=(value: ⇒ Option[CollaborationUse]): Unit =
      that.setRepresentation(UMLPackageScalaSupport._umlBuilder.ref(value))
    def substitution: EList[Substitution] = that.getSubstitutions
  }
}

object ClassifierScalaSupport extends ClassifierScalaSupport
