package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Actor;

trait ActorScalaSupport {
  implicit class ActorScalaSupport(that: Actor) {
    
  }
}

object ActorScalaSupport extends ActorScalaSupport
