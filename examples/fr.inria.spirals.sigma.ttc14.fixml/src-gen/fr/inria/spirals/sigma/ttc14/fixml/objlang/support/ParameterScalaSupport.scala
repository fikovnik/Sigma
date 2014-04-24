package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Parameter;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ParameterScalaSupport extends EMFScalaSupport {
  type Parameter = fr.inria.spirals.sigma.ttc14.fixml.objlang.Parameter
  
  object Parameter {
    def unapply(that: Parameter): Option[(String)] =
      Some((that.getName))
  }
}

object ParameterScalaSupport extends ParameterScalaSupport
