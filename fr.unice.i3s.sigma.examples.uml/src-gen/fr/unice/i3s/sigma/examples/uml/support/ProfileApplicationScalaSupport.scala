package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;

trait ProfileApplicationScalaSupport {
  implicit class ProfileApplicationScalaSupport(that: ProfileApplication) {
    def appliedProfile: Profile = that.getAppliedProfile
    def appliedProfile_=(value: Profile): Unit = that.setAppliedProfile(value)
    def isStrict: Boolean = that.isStrict
    def isStrict_=(value: Boolean): Unit = that.setIsStrict(value)
    def applyingPackage: org.eclipse.uml2.uml.Package = that.getApplyingPackage
    def applyingPackage_=(value: org.eclipse.uml2.uml.Package): Unit = that.setApplyingPackage(value)
  }
}

object ProfileApplicationScalaSupport extends ProfileApplicationScalaSupport
