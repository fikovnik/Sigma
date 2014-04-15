package fr.unice.i3s.sigma.examples.simpleoo.support

import fr.unice.i3s.sigma.examples.simpleoo.ModelElement;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ModelElementScalaSupport extends EMFScalaSupport {
  type ModelElement = fr.unice.i3s.sigma.examples.simpleoo.ModelElement
  
  object ModelElement {
  }
}

object ModelElementScalaSupport extends ModelElementScalaSupport
