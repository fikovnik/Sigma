package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;

trait DependencyScalaSupport {
  implicit class DependencyScalaSupport(that: Dependency) {
    def client: EList[NamedElement] = that.getClients
    def supplier: EList[NamedElement] = that.getSuppliers
  }
}

object DependencyScalaSupport extends DependencyScalaSupport
