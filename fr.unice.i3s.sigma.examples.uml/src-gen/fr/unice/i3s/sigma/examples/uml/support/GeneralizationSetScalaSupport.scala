package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;

trait GeneralizationSetScalaSupport {
  implicit class GeneralizationSetScalaSupport(that: GeneralizationSet) {
    def isCovering: Boolean = that.isCovering
    def isCovering_=(value: Boolean): Unit = that.setIsCovering(value)
    def isDisjoint: Boolean = that.isDisjoint
    def isDisjoint_=(value: Boolean): Unit = that.setIsDisjoint(value)
    def powertype: Classifier = that.getPowertype
    def powertype_=(value: Classifier): Unit = that.setPowertype(value)
    def generalization: EList[Generalization] = that.getGeneralizations
  }
}

object GeneralizationSetScalaSupport extends GeneralizationSetScalaSupport
