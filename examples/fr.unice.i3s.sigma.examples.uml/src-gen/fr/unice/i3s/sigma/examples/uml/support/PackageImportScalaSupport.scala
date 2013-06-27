package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait PackageImportScalaSupport extends EMFScalaSupport {
  type PackageImport = org.eclipse.uml2.uml.PackageImport
  
  protected implicit val _packageimportProxyBuilder = new EMFProxyBuilder[PackageImport](UMLPackageScalaSupport._umlBuilder)
  
  object PackageImport {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, importedPackage: org.eclipse.uml2.uml.Package = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL): PackageImport = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[PackageImport]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (importedPackage != null) _instance.setImportedPackage(importedPackage)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      
      _instance
    }
  }
  
  implicit class PackageImportScalaSupport(that: PackageImport) {
    def importedPackage: org.eclipse.uml2.uml.Package = that.getImportedPackage
    def importedPackage_=(value: org.eclipse.uml2.uml.Package): Unit = that.setImportedPackage(value)
    def importedPackage_=(value: ⇒ Option[org.eclipse.uml2.uml.Package]): Unit =
      that.setImportedPackage(UMLPackageScalaSupport._umlBuilder.ref(value))
    def importingNamespace: Namespace = that.getImportingNamespace
    def importingNamespace_=(value: Namespace): Unit = that.setImportingNamespace(value)
    def importingNamespace_=(value: ⇒ Option[Namespace]): Unit =
      that.setImportingNamespace(UMLPackageScalaSupport._umlBuilder.ref(value))
    def visibility: VisibilityKind = that.getVisibility
    def visibility_=(value: VisibilityKind): Unit = that.setVisibility(value)
  }
}

object PackageImportScalaSupport extends PackageImportScalaSupport
