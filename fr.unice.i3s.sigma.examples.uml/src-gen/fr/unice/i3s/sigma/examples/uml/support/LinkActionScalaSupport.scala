package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.LinkAction;
import org.eclipse.uml2.uml.LinkEndData;

trait LinkActionScalaSupport {
  implicit class LinkActionScalaSupport(that: LinkAction) {
    def endData: EList[LinkEndData] = that.getEndData
    def inputValue: EList[InputPin] = that.getInputValues
  }
}

object LinkActionScalaSupport extends LinkActionScalaSupport
