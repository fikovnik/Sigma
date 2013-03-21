package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Substitution;

trait SubstitutionScalaSupport {
  implicit class SubstitutionScalaSupport(that: Substitution) {
    def contract: Classifier = that.getContract
    def contract_=(value: Classifier): Unit = that.setContract(value)
    def substitutingClassifier: Classifier = that.getSubstitutingClassifier
    def substitutingClassifier_=(value: Classifier): Unit = that.setSubstitutingClassifier(value)
  }
}

object SubstitutionScalaSupport extends SubstitutionScalaSupport
