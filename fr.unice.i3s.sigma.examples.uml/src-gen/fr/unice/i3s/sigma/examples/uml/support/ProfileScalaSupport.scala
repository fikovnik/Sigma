package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Profile;

trait ProfileScalaSupport {
  implicit class ProfileScalaSupport(that: Profile) {
    def metaclassReference: EList[ElementImport] = that.getMetaclassReferences
    def metamodelReference: EList[PackageImport] = that.getMetamodelReferences
  }
}

object ProfileScalaSupport extends ProfileScalaSupport
