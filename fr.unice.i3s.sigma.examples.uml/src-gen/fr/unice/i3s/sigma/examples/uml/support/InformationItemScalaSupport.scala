package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InformationItem;

trait InformationItemScalaSupport {
  implicit class InformationItemScalaSupport(that: InformationItem) {
    def represented: EList[Classifier] = that.getRepresenteds
  }
}

object InformationItemScalaSupport extends InformationItemScalaSupport
