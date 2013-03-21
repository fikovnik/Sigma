package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;

trait StructuredClassifierScalaSupport {
  implicit class StructuredClassifierScalaSupport(that: StructuredClassifier) {
    def ownedAttribute: EList[Property] = that.getOwnedAttributes
    def ownedConnector: EList[Connector] = that.getOwnedConnectors
    def part: EList[Property] = that.getParts
    def role: EList[ConnectableElement] = that.getRoles
  }
}

object StructuredClassifierScalaSupport extends StructuredClassifierScalaSupport
