package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

trait NamedElementScalaSupport {
  implicit class NamedElementScalaSupport(that: NamedElement) {
    def clientDependency: EList[Dependency] = that.getClientDependencies
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
    def nameExpression: StringExpression = that.getNameExpression
    def nameExpression_=(value: StringExpression): Unit = that.setNameExpression(value)
    def namespace: Namespace = that.getNamespace
    def qualifiedName: String = that.getQualifiedName
    def visibility: VisibilityKind = that.getVisibility
    def visibility_=(value: VisibilityKind): Unit = that.setVisibility(value)
  }
}

object NamedElementScalaSupport extends NamedElementScalaSupport
