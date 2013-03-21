package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.PackageMerge;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;

trait PackageScalaSupport {
  implicit class PackageScalaSupport(that: org.eclipse.uml2.uml.Package) {
    def URI: String = that.getURI
    def URI_=(value: String): Unit = that.setURI(value)
    def nestedPackage: EList[org.eclipse.uml2.uml.Package] = that.getNestedPackages
    def nestingPackage: org.eclipse.uml2.uml.Package = that.getNestingPackage
    def nestingPackage_=(value: org.eclipse.uml2.uml.Package): Unit = that.setNestingPackage(value)
    def ownedStereotype: EList[Stereotype] = that.getOwnedStereotypes
    def packageMerge: EList[PackageMerge] = that.getPackageMerges
    def packagedElement: EList[PackageableElement] = that.getPackagedElements
    def profileApplication: EList[ProfileApplication] = that.getProfileApplications
    def ownedType: EList[Type] = that.getOwnedTypes
  }
}

object PackageScalaSupport extends PackageScalaSupport
