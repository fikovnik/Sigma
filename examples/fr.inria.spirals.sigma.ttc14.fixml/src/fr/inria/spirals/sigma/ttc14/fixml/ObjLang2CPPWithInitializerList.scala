package fr.inria.spirals.sigma.ttc14.fixml

import fr.unice.i3s.sigma.m2t.M2T
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang._objlang._
import fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveType

class ObjLang2CPPWithInitializerList extends ObjLang2CPP {

  override def genConstructor(c: Constructor) = {
    val args = c.parameters map toCode mkString (", ")

    if (c.initialisations.nonEmpty)
      !s"${source.name}::${source.name}($args) :" indent {
        !(c.initialisations map toFieldInitialization mkString (", "))
      }

    !s"{"
    !s"}"

    !endl
  }

  def toFieldInitialization(fi: FieldInitialisiation) = {
    s"${fi.field.name}(${toCode(fi.expression)})"
  }

}