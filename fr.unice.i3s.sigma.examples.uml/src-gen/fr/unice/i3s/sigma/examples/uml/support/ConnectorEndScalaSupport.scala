package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Property;

trait ConnectorEndScalaSupport {
  implicit class ConnectorEndScalaSupport(that: ConnectorEnd) {
    def definingEnd: Property = that.getDefiningEnd
    def partWithPort: Property = that.getPartWithPort
    def partWithPort_=(value: Property): Unit = that.setPartWithPort(value)
    def role: ConnectableElement = that.getRole
    def role_=(value: ConnectableElement): Unit = that.setRole(value)
  }
}

object ConnectorEndScalaSupport extends ConnectorEndScalaSupport
