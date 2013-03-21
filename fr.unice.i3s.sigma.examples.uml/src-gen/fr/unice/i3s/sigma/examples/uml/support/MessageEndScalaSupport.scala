package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;

trait MessageEndScalaSupport {
  implicit class MessageEndScalaSupport(that: MessageEnd) {
    def message: Message = that.getMessage
    def message_=(value: Message): Unit = that.setMessage(value)
  }
}

object MessageEndScalaSupport extends MessageEndScalaSupport
