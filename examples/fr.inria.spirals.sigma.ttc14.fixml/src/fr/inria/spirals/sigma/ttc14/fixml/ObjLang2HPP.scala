package fr.inria.spirals.sigma.ttc14.fixml

import fr.unice.i3s.sigma.m2t.M2T
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang._objlang._
import fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveType

class ObjLang2HPP extends ObjLang2CPPBase {

  override def main = {
    !s"#ifndef _${source.name}_H_"
    !s"#define _${source.name}_H_"

    !endl

    // to support PrimitiveType.STRING
    !"#include <string>"

    !endl

    source.references map (_.type_.cppHeaderFile) foreach { hdr ⇒
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

  override def genConstructors = {
    !"public:" indent {
      super.genConstructors
    }
  }

  override def genConstructor(c: Constructor) = {
    val args = c.parameters map toCode mkString (", ")

    !s"${source.name}($args);"

    !endl
  }

  override def genAttribute(c: Attribute) =
    !s"${toCode(c.type_)} ${c.name};"

  override def genReference(c: Reference) =
    !s"${c.type_.name}* ${c.name};"

}