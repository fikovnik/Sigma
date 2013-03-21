package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;

trait GeneralizationScalaSupport {
  implicit class GeneralizationScalaSupport(that: Generalization) {
    def general: Classifier = that.getGeneral
    def general_=(value: Classifier): Unit = that.setGeneral(value)
    def generalizationSet: EList[GeneralizationSet] = that.getGeneralizationSets
    def isSubstitutable: Boolean = that.isSubstitutable
    def isSubstitutable_=(value: Boolean): Unit = that.setIsSubstitutable(value)
    def specific: Classifier = that.getSpecific
    def specific_=(value: Classifier): Unit = that.setSpecific(value)
  }
}

object GeneralizationScalaSupport extends GeneralizationScalaSupport
