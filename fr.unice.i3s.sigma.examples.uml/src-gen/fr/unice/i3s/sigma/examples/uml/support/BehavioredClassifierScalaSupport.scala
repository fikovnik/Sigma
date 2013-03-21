package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.InterfaceRealization;

trait BehavioredClassifierScalaSupport {
  implicit class BehavioredClassifierScalaSupport(that: BehavioredClassifier) {
    def classifierBehavior: Behavior = that.getClassifierBehavior
    def classifierBehavior_=(value: Behavior): Unit = that.setClassifierBehavior(value)
    def interfaceRealization: EList[InterfaceRealization] = that.getInterfaceRealizations
    def ownedBehavior: EList[Behavior] = that.getOwnedBehaviors
  }
}

object BehavioredClassifierScalaSupport extends BehavioredClassifierScalaSupport
