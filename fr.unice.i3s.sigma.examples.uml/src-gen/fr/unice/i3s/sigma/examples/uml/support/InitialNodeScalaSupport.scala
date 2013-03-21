package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InitialNode;

trait InitialNodeScalaSupport {
  implicit class InitialNodeScalaSupport(that: InitialNode) {
    
  }
}

object InitialNodeScalaSupport extends InitialNodeScalaSupport
