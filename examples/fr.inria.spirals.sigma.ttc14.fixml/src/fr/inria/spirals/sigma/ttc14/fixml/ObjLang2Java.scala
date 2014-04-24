package fr.inria.spirals.sigma.ttc14.fixml

import fr.unice.i3s.sigma.m2t.M2T
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang._objlang._
import fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveType

class ObjLang2Java extends ObjLang2Code {

  protected def toCode(p: PrimitiveType) = p match {
    case PrimitiveType.STRING ⇒ "String"
  }

}