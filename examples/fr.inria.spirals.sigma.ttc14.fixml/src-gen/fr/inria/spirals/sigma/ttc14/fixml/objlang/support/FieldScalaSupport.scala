package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Field;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait FieldScalaSupport extends EMFScalaSupport {
  type Field = fr.inria.spirals.sigma.ttc14.fixml.objlang.Field
  
  object Field {
    def unapply(that: Field): Option[(String,fr.inria.spirals.sigma.ttc14.fixml.objlang.Class,Expression)] =
      Some((that.getName,that.getParent,that.getInitialValue))
  }
}

object FieldScalaSupport extends FieldScalaSupport
