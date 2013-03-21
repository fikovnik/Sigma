package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.ReplyAction;
import org.eclipse.uml2.uml.Trigger;

trait ReplyActionScalaSupport {
  implicit class ReplyActionScalaSupport(that: ReplyAction) {
    def replyToCall: Trigger = that.getReplyToCall
    def replyToCall_=(value: Trigger): Unit = that.setReplyToCall(value)
    def replyValue: EList[InputPin] = that.getReplyValues
    def returnInformation: InputPin = that.getReturnInformation
    def returnInformation_=(value: InputPin): Unit = that.setReturnInformation(value)
  }
}

object ReplyActionScalaSupport extends ReplyActionScalaSupport
