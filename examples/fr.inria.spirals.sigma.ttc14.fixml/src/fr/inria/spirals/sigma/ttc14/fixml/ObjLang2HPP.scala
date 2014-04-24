package fr.inria.spirals.sigma.ttc14.fixml

import fr.unice.i3s.sigma.m2t.M2T
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang._objlang._

class ObjLang2HPP extends ObjLang2CPPBase {

  override def main = {
    !s"#ifndef _${source.name}_H_"
    !s"#define _${source.name}_H_"

    !endl

    // to support PrimitiveType.STRING
    !"#include <string>"

    !endl

    source.fields map (_.type_) collect { case x: Class => x } map (_.cppHeaderFile) foreach { hdr ⇒
      !s"#include ${hdr.quoted}"
    }

    !endl

    super.main
    !";"

    !endl

    !s"#endif // _${source.name}_H_"
  }

  override def genFields = {
    !"public:" indent {
      super.genFields
    }
  }

  override def genField(c: Field) =
      !s"${type2Code(c)} ${c.name};"

  override def genConstructors = {
    !"public:" indent {
      super.genConstructors
    }
  }

  override def genConstructor(c: Constructor) = {
    val args = c.parameters map param2Code mkString (", ")

    !s"${source.name}($args);"

    !endl
  }
}