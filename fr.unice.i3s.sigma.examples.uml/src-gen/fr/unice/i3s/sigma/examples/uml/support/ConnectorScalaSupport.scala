package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.ConnectorKind;

trait ConnectorScalaSupport {
  implicit class ConnectorScalaSupport(that: Connector) {
    def contract: EList[Behavior] = that.getContracts
    def end: EList[ConnectorEnd] = that.getEnds
    def kind: ConnectorKind = that.getKind
    def redefinedConnector: EList[Connector] = that.getRedefinedConnectors
    def `type`: Association = that.getType
    def type_=(value: Association): Unit = that.setType(value)
  }
}

object ConnectorScalaSupport extends ConnectorScalaSupport
