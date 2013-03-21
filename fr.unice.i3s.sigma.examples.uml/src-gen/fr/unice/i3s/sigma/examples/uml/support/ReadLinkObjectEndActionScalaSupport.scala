package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ReadLinkObjectEndAction;

trait ReadLinkObjectEndActionScalaSupport {
  implicit class ReadLinkObjectEndActionScalaSupport(that: ReadLinkObjectEndAction) {
    def end: Property = that.getEnd
    def end_=(value: Property): Unit = that.setEnd(value)
    def `object`: InputPin = that.getObject
    def object_=(value: InputPin): Unit = that.setObject(value)
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
  }
}

object ReadLinkObjectEndActionScalaSupport extends ReadLinkObjectEndActionScalaSupport
