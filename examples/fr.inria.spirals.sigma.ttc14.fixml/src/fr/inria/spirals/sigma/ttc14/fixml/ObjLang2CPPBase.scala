package fr.inria.spirals.sigma.ttc14.fixml

import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang._objlang._

trait ObjLang2CPPBase extends ObjLang2Code {

  var cppHeaderSuffix = "h"

  implicit class ClassCPPUtil(that: Class) {
    def cppHeaderFile = s"${that.name}.${cppHeaderSuffix}"
  }

  override def toCode(e: NullLiteral) = "NULL"

  override def type2Code(e: TypedElement): String = (e.type_.isInstanceOf[Class], e.many) match {
    case (true, false) => class2Code(e.type_) + "*"
    case (true, true) => class2Code(e.type_) + "**"
    case (false, true) => class2Code(e.type_)+ "[]"
    case (false, false) => class2Code(e.type_)
  }

  override def toCode(e: DoubleLiteral): String = e.value.toString
  
  override def toCode(a: ArrayLiteral): String =
    s"new ${class2Code(a.type_)}*[${a.elements.size}] { ${a.elements map (toCode) mkString (", ")} }"

  override def class2Code(p: DataType) = {
    import XMLMM2ObjLang._
    p match {
      case DTString => "std::string"
      case DTDouble => "double"
      case DTLong => "long"
      case DTInteger => "int"
    }
  }
}