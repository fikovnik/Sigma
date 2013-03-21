package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Feature;

trait FeatureScalaSupport {
  implicit class FeatureScalaSupport(that: Feature) {
    def featuringClassifier: EList[Classifier] = that.getFeaturingClassifiers
    def isStatic: Boolean = that.isStatic
    def isStatic_=(value: Boolean): Unit = that.setIsStatic(value)
  }
}

object FeatureScalaSupport extends FeatureScalaSupport
