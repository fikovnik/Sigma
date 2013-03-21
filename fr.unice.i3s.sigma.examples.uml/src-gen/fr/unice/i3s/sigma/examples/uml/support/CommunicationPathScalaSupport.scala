package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.CommunicationPath;

trait CommunicationPathScalaSupport {
  implicit class CommunicationPathScalaSupport(that: CommunicationPath) {
    
  }
}

object CommunicationPathScalaSupport extends CommunicationPathScalaSupport
