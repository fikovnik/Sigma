package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectorEnd;

trait ConnectableElementScalaSupport {
  implicit class ConnectableElementScalaSupport(that: ConnectableElement) {
    def end: EList[ConnectorEnd] = that.getEnds
  }
}

object ConnectableElementScalaSupport extends ConnectableElementScalaSupport
