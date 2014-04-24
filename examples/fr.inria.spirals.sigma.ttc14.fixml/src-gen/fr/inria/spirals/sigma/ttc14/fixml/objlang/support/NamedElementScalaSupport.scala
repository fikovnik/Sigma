package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.NamedElement;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait NamedElementScalaSupport extends EMFScalaSupport {
  type NamedElement = fr.inria.spirals.sigma.ttc14.fixml.objlang.NamedElement
  
  object NamedElement {
    def unapply(that: NamedElement): Option[(String)] =
      Some((that.getName))
  }
}

object NamedElementScalaSupport extends NamedElementScalaSupport
