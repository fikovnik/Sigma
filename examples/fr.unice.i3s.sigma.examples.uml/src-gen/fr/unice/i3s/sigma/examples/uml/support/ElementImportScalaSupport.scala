package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ElementImportScalaSupport extends EMFScalaSupport {
  type ElementImport = org.eclipse.uml2.uml.ElementImport
  
  protected implicit val _elementimportProxyBuilder = new EMFProxyBuilder[ElementImport](UMLPackageScalaSupport._umlBuilder)
  
  object ElementImport {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, alias: String = null, importedElement: PackageableElement = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL): ElementImport = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ElementImport]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (alias != null) _instance.setAlias(alias)
      if (importedElement != null) _instance.setImportedElement(importedElement)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      
      _instance
    }
  }
  
  implicit class ElementImportScalaSupport(that: ElementImport) {
    def alias: String = that.getAlias
    def alias_=(value: String): Unit = that.setAlias(value)
    def importedElement: PackageableElement = that.getImportedElement
    def importedElement_=(value: PackageableElement): Unit = that.setImportedElement(value)
    def importedElement_=(value: ⇒ Option[PackageableElement]): Unit =
      that.setImportedElement(UMLPackageScalaSupport._umlBuilder.ref(value))
    def importingNamespace: Namespace = that.getImportingNamespace
    def importingNamespace_=(value: Namespace): Unit = that.setImportingNamespace(value)
    def importingNamespace_=(value: ⇒ Option[Namespace]): Unit =
      that.setImportingNamespace(UMLPackageScalaSupport._umlBuilder.ref(value))
    def visibility: VisibilityKind = that.getVisibility
    def visibility_=(value: VisibilityKind): Unit = that.setVisibility(value)
  }
}

object ElementImportScalaSupport extends ElementImportScalaSupport
