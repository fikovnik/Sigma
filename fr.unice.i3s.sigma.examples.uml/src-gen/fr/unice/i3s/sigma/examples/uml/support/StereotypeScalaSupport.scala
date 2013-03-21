package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

trait StereotypeScalaSupport {
  implicit class StereotypeScalaSupport(that: Stereotype) {
    def icon: EList[Image] = that.getIcons
    def profile: Profile = that.getProfile
  }
}

object StereotypeScalaSupport extends StereotypeScalaSupport
