package fr.inria.spirals.sigma.ttc14.fixml

import fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveType
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang._objlang._
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.support.XMLMM
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.support.XMLMM._xmlmm._
import fr.unice.i3s.sigma.m2m.M2MT
import fr.unice.i3s.sigma.m2m.annotations.Lazy
import fr.unice.i3s.sigma.m2m.annotations.LazyUnique

class XMLMM2ObjLang extends M2MT with XMLMM with ObjLang {

  sourceMetaModels = _xmlmm
  targetMetaModels = _objlang

  def ruleXMLNode2Class(s: XMLNode, t: Class) {

    // associate all same tag siblings to the same class (and same default constructor)
    s.sameTagSiblings foreach (_ sAssociate t)

    t.name = s.tag

    // assign constructors
    t.members ++= s.sTargets[Constructor]
    // all attributes become class attributes
    t.members ++= ~s.allAttributes
    // nested nodes become class references
    t.members ++= s.allSubnodes.sTarget[Reference]

    // fix reference duplicate names - only concerns references since attributes have unique names
    fixNames(t.members collect { case e: Reference ⇒ e })
  }

  @Lazy
  def ruleXMLNode2ConstructorCall(source: XMLNode, t: ConstructorCall) {
    val constructor = source.sTargets[Constructor]
      .find { c ⇒
        (c.parameters.isEmpty && source.isEmptyLeaf) || // default one
          (c.parameters.nonEmpty && !source.isEmptyLeaf) // non-default one 
      }
      .get // since there must be such a constructor

    t.constructor = constructor

    // resolve the arguments using the source of constructor parameters
    t.arguments ++= constructor.parameters map (_.sSource.get) collect {
      // an owning attribute  
      case e: XMLAttribute if e.eContainer == source ⇒ StringLiteral(e.value)
      // an owning node
      case e: XMLNode if e.eContainer == source ⇒ e.sTarget[ConstructorCall].get
      // an attribute or a node defined in a sibling
      case _: XMLAttribute | _: XMLNode ⇒
        NullLiteral()
    }
  }

  def ruleXMLNode2DefaultConstructor(s: XMLNode, t: Constructor) {
    // associate all siblings to the same constructor
    s.sameTagSiblings foreach (_ sAssociate t)
  }

  def ruleXMLNode2NonDefaultConstructor(s: XMLNode, t: Constructor) = guardedBy {
    // only applicable on non-empty leaves
    !s.isEmptyLeaf
  } transform {

    // associate all siblings to the same constructor
    s.sameTagSiblings foreach (_ sAssociate t)

    for (e ← (s.allAttributes ++ s.allSubnodes)) {
      val param = e.sTarget[Parameter].get
      val field = e.sTarget[Field].get

      t.parameters += param
      t.initialisations += FieldInitialisiation(
        field = field,
        expression = ParameterAccess(parameter = param)
      )
    }

    // fix the parameter naming
    fixNames(t.parameters)
  }

  @Lazy
  def ruleXMLAttribute2ConstructorParameter(s: XMLAttribute, t: PrimitiveParameter) {
    t.name = checkName(s.name)
    t.type_ = PrimitiveType.STRING
  }

  @Lazy
  def ruleXMLNode2ConstructorParameter(s: XMLNode, t: ReferenceParameter) {
    t.name = checkName(s.tag)
    t.type_ = ~s
  }

  @LazyUnique
  def ruleXMLAttribute2Attribute(s: XMLAttribute, t: Attribute) {
    t.name = checkName(s.name)
    // currently they are all strings now
    t.type_ = PrimitiveType.STRING
    t.initialValue = StringLiteral(s.value)
  }

  @LazyUnique
  def ruleXMLNode2Reference(s: XMLNode, t: Reference) {
    t.name = s.tag + "_object"
    t.type_ = ~s
    t.initialValue = ~s
  }

  // HELPERS

  def checkName(name: String): String = "_" + name

  def fixNames(seq: Seq[NamedElement]) {
    for {
      (name, elems) ← seq groupBy (_.name) if elems.size > 1
      (node, idx) ← elems.zipWithIndex
    } {
      node.name = (if (name.last == '_') name else name + "_") + (idx + 1)
    }
  }

  implicit class XMLNodeExtras(that: XMLNode) {
    lazy val sameTagSiblings = that.sSiblings filter { e ⇒ e != that && e.tag == that.tag }

    lazy val allAttributes = that.attributes ++ sameTagSiblings
      .flatMap(_.attributes)
      .filter { a ⇒ !that.attributes.exists(_.name == a.name) }

    lazy val allSubnodes = that.subnodes ++ sameTagSiblings
      .flatMap(_.subnodes)
      .filter { a ⇒ !that.subnodes.exists(_.tag == a.tag) }

    lazy val isEmpty = that.attributes.isEmpty
    lazy val isLeaf = that.subnodes.isEmpty
    lazy val isEmptyLeaf = isEmpty && isLeaf
  }
}