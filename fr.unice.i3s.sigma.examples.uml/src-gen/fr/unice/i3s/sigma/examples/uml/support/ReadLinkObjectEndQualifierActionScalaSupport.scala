package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ReadLinkObjectEndQualifierAction;

trait ReadLinkObjectEndQualifierActionScalaSupport {
  implicit class ReadLinkObjectEndQualifierActionScalaSupport(that: ReadLinkObjectEndQualifierAction) {
    def `object`: InputPin = that.getObject
    def object_=(value: InputPin): Unit = that.setObject(value)
    def qualifier: Property = that.getQualifier
    def qualifier_=(value: Property): Unit = that.setQualifier(value)
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
  }
}

object ReadLinkObjectEndQualifierActionScalaSupport extends ReadLinkObjectEndQualifierActionScalaSupport
