package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.MessageEvent;

trait MessageEventScalaSupport {
  implicit class MessageEventScalaSupport(that: MessageEvent) {
    
  }
}

object MessageEventScalaSupport extends MessageEventScalaSupport
