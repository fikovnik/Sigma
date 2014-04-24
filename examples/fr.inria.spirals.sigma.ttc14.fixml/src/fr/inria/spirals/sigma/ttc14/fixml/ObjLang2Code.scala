package fr.inria.spirals.sigma.ttc14.fixml

import fr.unice.i3s.sigma.m2t.M2T
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang._objlang._

abstract class ObjLang2Code extends M2T with ObjLang {

  type Source = Class

  def main = {
    !s"class ${source.name}" curlyIndent {
      genFields

      !endl

      genConstructors
    }
  }

  def genConstructors =
    source.constructors foreach genConstructor

  def genFields =
    source.fields foreach genField
    
  def genField(c: Field) =
      !s"public ${type2Code(c)} ${c.name}${toInitCode(c)};"

  def toInitCode(f: Field) = 
    " = " + (f.initialValue map toCode getOrElse (""))

  def genConstructor(c: Constructor) = {
    val args = c.parameters map param2Code mkString (", ")

    !s"public ${source.name}($args)" curlyIndent {
      c.initialisations foreach genFieldInitialization
    }

    !endl
  }

  def genFieldInitialization(fi: FieldInitialisiation) =
    !s"this.${fi.field.name} = ${toCode(fi.expression)};"

  protected def type2Code(e: TypedElement): String =  
    if (e.many)
      s"${class2Code(e.type_)}[]"
    else
      s"${class2Code(e.type_)}"
    
  protected def param2Code(p: Parameter): String =
     s"${type2Code(p)} ${p.name}"

  protected def toCode(e: StringLiteral): String = e.value.quoted
  protected def toCode(e: DoubleLiteral): String = e.value + "D"
  protected def toCode(e: LongLiteral): String = e.value + "L"
  protected def toCode(e: IntegerLiteral): String = e.value.toString
  protected def toCode(e: ParameterAccess): String = e.parameter.name
  protected def toCode(e: NullLiteral): String = "null"
  protected def toCode(e: ConstructorCall): String =
    s"new ${class2Code(e.constructor.parent)}(${e.arguments map toCode mkString (", ")})"

  protected def toCode(a: ArrayLiteral): String =
    s"new ${class2Code(a.type_)}[] { ${a.elements map toCode mkString (", ")} }"

  protected def toCode(e: Expression): String = e match {
    case x: StringLiteral ⇒ toCode(x)
    case x: DoubleLiteral ⇒ toCode(x)
    case x: IntegerLiteral ⇒ toCode(x)
    case x: LongLiteral ⇒ toCode(x)
    case x: ParameterAccess ⇒ toCode(x)
    case x: ConstructorCall ⇒ toCode(x)
    case x: NullLiteral ⇒ toCode(x)
    case x: ArrayLiteral ⇒ toCode(x)
  }

  protected def class2Code(c: Classifier): String = c match {
    case x: Class => class2Code(x)
    case x: DataType => class2Code(x)
  }
  protected def class2Code(c: Class): String = c.name
  protected def class2Code(p: DataType): String = p.name
}