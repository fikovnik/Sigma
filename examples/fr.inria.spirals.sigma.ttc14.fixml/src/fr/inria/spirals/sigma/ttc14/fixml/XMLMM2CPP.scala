package fr.inria.spirals.sigma.ttc14.fixml

import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang._objlang._
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.support.XMLMM
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.support.XMLMM._xmlmm._

class XMLMM2CPP extends XMLMM2ObjLang {

  override def ruleXMLAttribute2Attribute(s: XMLAttribute, t: Attribute) {
    super.ruleXMLAttribute2Attribute(s, t)

    t.setInitialValue(null)
  }

  override def ruleXMLNode2Reference(s: XMLNode, t: Reference) {
    super.ruleXMLNode2Reference(s, t)

    t.setInitialValue(null)
  }

  override def ruleXMLNode2DefaultConstructor(s: XMLNode, t: Constructor) {
    super.ruleXMLNode2DefaultConstructor(s, t)

    t.initialisations ++= s.allAttributes map { attr ⇒
      val init = FieldInitialisiation()
      init.field = ~attr
      init.expression = StringLiteral(attr.value)
      init
    }

    t.initialisations ++= s.allSubnodes map { ref ⇒
      val init = FieldInitialisiation()
      init.field = ~ref
      init.expression = ~ref
      init
    }
  }

}