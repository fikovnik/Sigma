package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.LinkEndDestructionData;

trait LinkEndDestructionDataScalaSupport {
  implicit class LinkEndDestructionDataScalaSupport(that: LinkEndDestructionData) {
    def destroyAt: InputPin = that.getDestroyAt
    def destroyAt_=(value: InputPin): Unit = that.setDestroyAt(value)
    def isDestroyDuplicates: Boolean = that.isDestroyDuplicates
    def isDestroyDuplicates_=(value: Boolean): Unit = that.setIsDestroyDuplicates(value)
  }
}

object LinkEndDestructionDataScalaSupport extends LinkEndDestructionDataScalaSupport
