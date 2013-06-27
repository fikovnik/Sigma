package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

trait NamespaceScalaSupport extends EMFScalaSupport {
  type Namespace = org.eclipse.uml2.uml.Namespace
  
  protected implicit val _namespaceProxyBuilder = new EMFProxyBuilder[Namespace](UMLPackageScalaSupport._umlBuilder)
  
  object Namespace {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, elementImport: EList[ElementImport] = null, packageImport: EList[PackageImport] = null, ownedRule: EList[Constraint] = null): Namespace = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Namespace]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (elementImport != null) _instance.getElementImports.addAll(elementImport)
      if (packageImport != null) _instance.getPackageImports.addAll(packageImport)
      if (ownedRule != null) _instance.getOwnedRules.addAll(ownedRule)
      
      _instance
    }
  }
  
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
