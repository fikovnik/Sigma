package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.UseCase;

trait ClassifierScalaSupport {
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
    def substitution: EList[Substitution] = that.getSubstitutions
  }
}

object ClassifierScalaSupport extends ClassifierScalaSupport
