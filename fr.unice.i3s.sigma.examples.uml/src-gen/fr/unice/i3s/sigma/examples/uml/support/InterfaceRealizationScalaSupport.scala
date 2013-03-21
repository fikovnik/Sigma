package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;

trait InterfaceRealizationScalaSupport {
  implicit class InterfaceRealizationScalaSupport(that: InterfaceRealization) {
    def contract: Interface = that.getContract
    def contract_=(value: Interface): Unit = that.setContract(value)
    def implementingClassifier: BehavioredClassifier = that.getImplementingClassifier
    def implementingClassifier_=(value: BehavioredClassifier): Unit = that.setImplementingClassifier(value)
  }
}

object InterfaceRealizationScalaSupport extends InterfaceRealizationScalaSupport
