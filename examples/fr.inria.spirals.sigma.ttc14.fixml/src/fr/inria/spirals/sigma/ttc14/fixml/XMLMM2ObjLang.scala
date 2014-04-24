package fr.inria.spirals.sigma.ttc14.fixml

import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang._objlang._
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.support.XMLMM
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.support.XMLMM._xmlmm._
import fr.unice.i3s.sigma.m2m.M2MT
import fr.unice.i3s.sigma.m2m.annotations.Lazy
import fr.unice.i3s.sigma.m2m.annotations.LazyUnique
import scala.util.Try

object XMLMM2ObjLang {

  // basic types
  val DTString = DataType(name = "string")
  val DTDouble = DataType(name = "double")
  val DTLong = DataType(name = "long")
  val DTInteger = DataType(name = "int")

  // it also stores the promotion ordering from righ to left
  val Builtins = Seq(DTString, DTDouble, DTLong, DTInteger)

  private val PDouble = """([+-]?\d+.\d+)""".r
  private val PInteger = """([+-]?\d+)""".r

  def guessDataType(value: String): DataType = value match {
    case PDouble(_) => DTDouble
    case PInteger(_) => Try(Integer.parseInt(value)) map (_ => DTInteger) getOrElse (DTLong)
    case _ => DTString
  }

  def guessDataType(values: Seq[String]): DataType =
    values map guessDataType reduce { (a, b) =>
      if (Builtins.indexOf(a) < Builtins.indexOf(a)) a else b
    }

  def valueLiteral(dataType: DataType, value: String): Expression = dataType match {
    case DTDouble => DoubleLiteral(value.toDouble)
    case DTLong => LongLiteral(value.toLong)
    case DTInteger => IntegerLiteral(value.toInt)
    case _ => StringLiteral(value)
  }

  def defaultValueLiteral(c: Classifier): Expression = c match {
    case DTDouble => DoubleLiteral(0)
    case DTLong => LongLiteral(0)
    case DTInteger => IntegerLiteral(0)
    case _ => NullLiteral()
  }
}

class XMLMM2ObjLang extends M2MT with XMLMM with ObjLang {

  import XMLMM2ObjLang._

  sourceMetaModels = _xmlmm
  targetMetaModels = _objlang

  override def setUp {
    // register built-in type
    Builtins foreach associate
  }

  def ruleXMLNode2Class(s: XMLNode, t: Class) {

    // associate all same siblings (sibling tags with the same name)
    // to the same target Class
    s.allSameSiblings foreach (associate(_, t))

    t.name = s.tag
    t.members ++= s.sTargets[Constructor]
    t.members ++= ~s.allAttributes
    t.members ++= s.allSubnodes.sTarget[Field]
  }

  @Lazy
  def ruleXMLNode2ConstructorCall(s: XMLNode, t: ConstructorCall) {
    val constructor = s.sTargets[Constructor]
      .find { c ⇒
        (c.parameters.isEmpty && s.isEmptyLeaf) || // default one
          (c.parameters.nonEmpty && !s.isEmptyLeaf) // non-default one 
      }
      .get // since there must be such a constructor

    t.constructor = constructor

    // source elements used to create constructor parameters
    val paramSources = constructor.parameters map { p => (p.type_, p.sSource.get) }

    // resolve the arguments using the source of constructor parameters

    val attrLen = s.allAttributes.size

    t.arguments ++= {
      for {
        (p, idx) <- constructor.parameters.zipWithIndex
        source = p.sSource.get
      } yield {
        source match {
          case attr: XMLAttribute =>
            // we can cast since attributes have always primitive types
            val dataType = p.type_.asInstanceOf[DataType]

            s.attributes
              .find(_.name == attr.name)
              .map { local => valueLiteral(dataType, local.value) }
              .getOrElse(defaultValueLiteral(dataType))

          case node: XMLNode =>
            s.subnodes.filter(_.tag == node.tag) match {
              case Seq() => NullLiteral()
              case Seq(x) if !p.many => x.sTarget[ConstructorCall].get
              case Seq(xs@_*) => 
                val init = ArrayLiteral()
                init.type_ = p.type_
                init.elements ++= ~xs
                init
            }
        }
      }
    }
  }

  def ruleXMLNode2DefaultConstructor(s: XMLNode, t: Constructor) {
    // associate all siblings to the same constructor
    s.allSameSiblings foreach (associate(_, t))
  }

  def ruleXMLNode2NonDefaultConstructor(s: XMLNode, t: Constructor) = guardedBy {
    // only applicable on non-empty leaves
    !s.isEmptyLeaf
  } transform {

    // associate all siblings to the same constructor
    s.allSameSiblings foreach (associate(_, t))

    for (e ← (s.allAttributes ++ s.allSubnodes.distinctBy(_.tag))) {
      val param = e.sTarget[Parameter].get
      val field = e.sTarget[Field].get

      t.parameters += param
      t.initialisations += FieldInitialisiation(
        field = field,
        expression = ParameterAccess(parameter = param))
    }
  }

  @Lazy
  def ruleXMLAttribute2ConstructorParameter(s: XMLAttribute, t: Parameter) {
    t.name = checkName(s.name)
    // use the already guessed type
    t.type_ = s.sTarget[Field].get.type_
  }

  @Lazy
  def ruleXMLNode2ConstructorParameter(s: XMLNode, t: Parameter) {
    val field = s.sTarget[Field].get

    t.name = field.name
    t.many = field.many
    t.type_ = field.type_
  }

  @LazyUnique
  def ruleXMLAttribute2Field(s: XMLAttribute, t: Field) {
    t.name = checkName(s.name)

    val dt = guessDataType((s +: s.allSameSiblings) map (_.value))
    t.type_ = dt
    t.initialValue = valueLiteral(dt, s.value)
  }

  @LazyUnique
  def ruleXMLNode2Field(s: XMLNode, t: Field) {
    val allSiblings = s.allSameSiblings
    allSiblings foreach (associate(_, t))

    val groups = (s +: allSiblings) groupBy (_.eContainer)
    val max = groups.values map (_.size) max

    if (max > 1) {
      t.name = s.tag + "_objects"
      t.many = true
      val init = ArrayLiteral()
      init.type_ = ~s

      val siblings = groups(s.eContainer)
      init.elements ++= ~siblings
      init.elements ++= 0 until (max - siblings.size) map (_ => NullLiteral())
      t.initialValue = init
    } else {
      t.name = s.tag + "_object"
      t.initialValue = ~s
    }

    t.type_ = ~s
  }

  // HELPERS

  def checkName(name: String): String = "_" + name

  implicit class XMLAttributeExtras(that: XMLAttribute) {
    lazy val allSameSiblings = that.sContainer[XMLNode] match {
      case Some(c) =>
        (c +: c.sSiblings)
          .flatMap(_.attributes)
          .filter { e ⇒ e != that && e.name == that.name }
      case None => Seq()
    }
  }

  implicit class XMLNodeExtras(that: XMLNode) {
    lazy val allSameSiblings = that.sContainer[XMLNode] match {
      case Some(c) =>
        (c +: c.sSiblings)
          .flatMap(_.subnodes)
          .filter { e ⇒ e != that && e.tag == that.tag }
      case None => Seq()
    }

    lazy val sameSiblings = that.sSiblings filter { e ⇒ e != that && e.tag == that.tag }

    lazy val allAttributes = that.attributes ++ allSameSiblings
      .flatMap(_.attributes)
      .filter { a ⇒ !that.attributes.exists(_.name == a.name) }

    lazy val allSubnodes = that.subnodes ++ allSameSiblings
      .flatMap(_.subnodes)
      .filter { a ⇒ !that.subnodes.exists(_.tag == a.tag) }

    lazy val isEmptyLeaf = that.attributes.isEmpty && that.subnodes.isEmpty
  }
}