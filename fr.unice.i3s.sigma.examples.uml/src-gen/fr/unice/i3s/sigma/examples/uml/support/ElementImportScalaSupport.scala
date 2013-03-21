package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.VisibilityKind;

trait ElementImportScalaSupport {
  implicit class ElementImportScalaSupport(that: ElementImport) {
    def alias: String = that.getAlias
    def alias_=(value: String): Unit = that.setAlias(value)
    def importedElement: PackageableElement = that.getImportedElement
    def importedElement_=(value: PackageableElement): Unit = that.setImportedElement(value)
    def importingNamespace: Namespace = that.getImportingNamespace
    def importingNamespace_=(value: Namespace): Unit = that.setImportingNamespace(value)
    def visibility: VisibilityKind = that.getVisibility
    def visibility_=(value: VisibilityKind): Unit = that.setVisibility(value)
  }
}

object ElementImportScalaSupport extends ElementImportScalaSupport
