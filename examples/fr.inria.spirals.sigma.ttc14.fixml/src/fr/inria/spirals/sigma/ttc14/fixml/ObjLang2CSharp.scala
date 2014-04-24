package fr.inria.spirals.sigma.ttc14.fixml

import fr.unice.i3s.sigma.m2t.M2T
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang._objlang._


class ObjLang2CSharp extends ObjLang2Code {

  override def class2Code(p: DataType) = {
    import XMLMM2ObjLang._
    p match {
      case DTString => "string"
      case DTDouble => "double"
      case DTLong => "long"
      case DTInteger => "int"
    }
  }
  
}