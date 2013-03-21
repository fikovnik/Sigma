package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageableElement;

trait NamespaceScalaSupport {
  implicit class NamespaceScalaSupport(that: Namespace) {
    def elementImport: EList[ElementImport] = that.getElementImports
    def packageImport: EList[PackageImport] = that.getPackageImports
    def ownedRule: EList[Constraint] = that.getOwnedRules
    def ownedMember: EList[NamedElement] = that.getOwnedMembers
    def importedMember: EList[PackageableElement] = that.getImportedMembers
    def member: EList[NamedElement] = that.getMembers
  }
}

object NamespaceScalaSupport extends NamespaceScalaSupport
