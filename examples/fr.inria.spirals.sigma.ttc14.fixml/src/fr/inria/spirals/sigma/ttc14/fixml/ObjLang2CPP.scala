package fr.inria.spirals.sigma.ttc14.fixml

import fr.unice.i3s.sigma.m2t.M2T
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang._objlang._

class ObjLang2CPP extends ObjLang2CPPBase {

  override def main = {
    !s"#include ${source.cppHeaderFile.quoted}"

    !endl

    source.constructors foreach genConstructor
  }

  override def genConstructor(c: Constructor) = {
    val args = c.parameters map param2Code mkString (", ")

    !s"${source.name}::${source.name}($args)" curlyIndent {
      for (field <- c.parent.fields) {
        c.initialisations
          .find(_.field == field) // try to find field initialization within a constructor
          .map(_.expression) 
          .orElse(field.initialValue) // if there is none try field itself
          .foreach { e =>
            !s"this->${field.name} = ${toCode(e)};"
          }
      }
    }

    !endl
  }

}