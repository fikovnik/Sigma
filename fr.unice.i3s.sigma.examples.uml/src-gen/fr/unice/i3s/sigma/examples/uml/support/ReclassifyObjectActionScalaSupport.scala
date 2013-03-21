package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.ReclassifyObjectAction;

trait ReclassifyObjectActionScalaSupport {
  implicit class ReclassifyObjectActionScalaSupport(that: ReclassifyObjectAction) {
    def isReplaceAll: Boolean = that.isReplaceAll
    def isReplaceAll_=(value: Boolean): Unit = that.setIsReplaceAll(value)
    def newClassifier: EList[Classifier] = that.getNewClassifiers
    def `object`: InputPin = that.getObject
    def object_=(value: InputPin): Unit = that.setObject(value)
    def oldClassifier: EList[Classifier] = that.getOldClassifiers
  }
}

object ReclassifyObjectActionScalaSupport extends ReclassifyObjectActionScalaSupport
