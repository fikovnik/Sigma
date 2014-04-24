package fr.inria.spirals.sigma.ttc14.fixml

import fr.unice.i3s.sigma.m2t.M2T
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang._objlang._
import fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveType

class ObjLang2CPP extends ObjLang2CPPBase {

  override def main = {
    !s"#include ${source.cppHeaderFile.quoted}"

    !endl

    source.constructors foreach genConstructor
  }

  override def genConstructor(c: Constructor) = {
    val args = c.parameters map toCode mkString (", ")

    !s"${source.name}::${source.name}($args)" curlyIndent {
      c.initialisations foreach genFieldInitialization
    }

    !endl
  }

  override def genFieldInitialization(fi: FieldInitialisiation) =
    !s"this->${fi.field.name} = ${toCode(fi.expression)};"

}