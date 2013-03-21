package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.StructuralFeature;

trait StructuralFeatureScalaSupport {
  implicit class StructuralFeatureScalaSupport(that: StructuralFeature) {
    def isReadOnly: Boolean = that.isReadOnly
    def isReadOnly_=(value: Boolean): Unit = that.setIsReadOnly(value)
  }
}

object StructuralFeatureScalaSupport extends StructuralFeatureScalaSupport
