package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.LinkEndCreationData;

trait LinkEndCreationDataScalaSupport {
  implicit class LinkEndCreationDataScalaSupport(that: LinkEndCreationData) {
    def insertAt: InputPin = that.getInsertAt
    def insertAt_=(value: InputPin): Unit = that.setInsertAt(value)
    def isReplaceAll: Boolean = that.isReplaceAll
    def isReplaceAll_=(value: Boolean): Unit = that.setIsReplaceAll(value)
  }
}

object LinkEndCreationDataScalaSupport extends LinkEndCreationDataScalaSupport
