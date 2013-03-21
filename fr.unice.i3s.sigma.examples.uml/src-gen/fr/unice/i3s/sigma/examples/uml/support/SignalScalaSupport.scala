package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Signal;

trait SignalScalaSupport {
  implicit class SignalScalaSupport(that: Signal) {
    def ownedAttribute: EList[Property] = that.getOwnedAttributes
  }
}

object SignalScalaSupport extends SignalScalaSupport
