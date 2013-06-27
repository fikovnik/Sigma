package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;

import scala.Option;

trait ProfileApplicationScalaSupport extends EMFScalaSupport {
  type ProfileApplication = org.eclipse.uml2.uml.ProfileApplication
  
  protected implicit val _profileapplicationProxyBuilder = new EMFProxyBuilder[ProfileApplication](UMLPackageScalaSupport._umlBuilder)
  
  object ProfileApplication {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, appliedProfile: Profile = null, isStrict: Boolean = false): ProfileApplication = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ProfileApplication]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (appliedProfile != null) _instance.setAppliedProfile(appliedProfile)
      if (isStrict != false) _instance.setIsStrict(isStrict)
      
      _instance
    }
  }
  
  implicit class ProfileApplicationScalaSupport(that: ProfileApplication) {
    def appliedProfile: Profile = that.getAppliedProfile
    def appliedProfile_=(value: Profile): Unit = that.setAppliedProfile(value)
    def appliedProfile_=(value: ⇒ Option[Profile]): Unit =
      that.setAppliedProfile(UMLPackageScalaSupport._umlBuilder.ref(value))
    def isStrict: Boolean = that.isStrict
    def isStrict_=(value: Boolean): Unit = that.setIsStrict(value)
    def applyingPackage: org.eclipse.uml2.uml.Package = that.getApplyingPackage
    def applyingPackage_=(value: org.eclipse.uml2.uml.Package): Unit = that.setApplyingPackage(value)
    def applyingPackage_=(value: ⇒ Option[org.eclipse.uml2.uml.Package]): Unit =
      that.setApplyingPackage(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object ProfileApplicationScalaSupport extends ProfileApplicationScalaSupport
