package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;

trait BehaviorScalaSupport {
  implicit class BehaviorScalaSupport(that: Behavior) {
    def context: BehavioredClassifier = that.getContext
    def isReentrant: Boolean = that.isReentrant
    def isReentrant_=(value: Boolean): Unit = that.setIsReentrant(value)
    def ownedParameter: EList[Parameter] = that.getOwnedParameters
    def ownedParameterSet: EList[ParameterSet] = that.getOwnedParameterSets
    def postcondition: EList[Constraint] = that.getPostconditions
    def precondition: EList[Constraint] = that.getPreconditions
    def redefinedBehavior: EList[Behavior] = that.getRedefinedBehaviors
    def specification: BehavioralFeature = that.getSpecification
    def specification_=(value: BehavioralFeature): Unit = that.setSpecification(value)
  }
}

object BehaviorScalaSupport extends BehaviorScalaSupport
