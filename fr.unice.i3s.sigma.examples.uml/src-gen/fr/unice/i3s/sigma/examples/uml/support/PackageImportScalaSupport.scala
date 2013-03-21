package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.VisibilityKind;

trait PackageImportScalaSupport {
  implicit class PackageImportScalaSupport(that: PackageImport) {
    def importedPackage: org.eclipse.uml2.uml.Package = that.getImportedPackage
    def importedPackage_=(value: org.eclipse.uml2.uml.Package): Unit = that.setImportedPackage(value)
    def importingNamespace: Namespace = that.getImportingNamespace
    def importingNamespace_=(value: Namespace): Unit = that.setImportingNamespace(value)
    def visibility: VisibilityKind = that.getVisibility
    def visibility_=(value: VisibilityKind): Unit = that.setVisibility(value)
  }
}

object PackageImportScalaSupport extends PackageImportScalaSupport
