package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.LinkEndData;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.QualifierValue;

trait LinkEndDataScalaSupport {
  implicit class LinkEndDataScalaSupport(that: LinkEndData) {
    def end: Property = that.getEnd
    def end_=(value: Property): Unit = that.setEnd(value)
    def qualifier: EList[QualifierValue] = that.getQualifiers
    def value: InputPin = that.getValue
    def value_=(value: InputPin): Unit = that.setValue(value)
  }
}

object LinkEndDataScalaSupport extends LinkEndDataScalaSupport
