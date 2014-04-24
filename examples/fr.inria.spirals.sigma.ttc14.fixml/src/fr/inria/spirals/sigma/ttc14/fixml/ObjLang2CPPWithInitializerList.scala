package fr.inria.spirals.sigma.ttc14.fixml

import fr.unice.i3s.sigma.m2t.M2T
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang._objlang._

class ObjLang2CPPWithInitializerList extends ObjLang2CPP {

  override def genConstructor(c: Constructor) = {
    val args = c.parameters map param2Code mkString (", ")

    if (c.initialisations.nonEmpty) {
      !s"${source.name}::${source.name}($args) :" indent {

        val inits = for {
          field <- c.parent.fields
          expression <- c.initialisations find (_.field == field) map (_.expression) orElse (field.initialValue)
        } yield !s"${field.name}(${toCode(expression)})"

        !(inits mkString (", "))
      }
    } else {
      !s"${source.name}::${source.name}($args)"
    }

    !s"{"
    !s"}"

    !endl
  }

}