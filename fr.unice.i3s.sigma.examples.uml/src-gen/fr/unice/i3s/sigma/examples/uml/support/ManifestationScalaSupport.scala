package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.PackageableElement;

trait ManifestationScalaSupport {
  implicit class ManifestationScalaSupport(that: Manifestation) {
    def utilizedElement: PackageableElement = that.getUtilizedElement
    def utilizedElement_=(value: PackageableElement): Unit = that.setUtilizedElement(value)
  }
}

object ManifestationScalaSupport extends ManifestationScalaSupport
