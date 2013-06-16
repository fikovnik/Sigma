package fr.unice.i3s.sigma.examples.sle13.sigma

import fr.unice.i3s.sigma.m2m.M2M
import relational.support.RelationalPackageScalaSupport
import uml.support.UmlPackageScalaSupport

class Uml2Relational extends M2M with UmlPackageScalaSupport with RelationalPackageScalaSupport {

  def ruleEClass2Table(cls: UmlClass, tab: Table, pkey: Column) = {
    tab.name = cls.name;
    tab.columns += pkey
    tab.columns ++= ~cls.attributes

    pkey.name = "Id"
    pkey.dataType = "Int"
  }

  def ruleProperty2Column2(attrib: Property, column: Column) = guardedBy {
    !attrib.multi
  } transform {
    column.name = attrib.name
    column.dataType = attrib.`type`.name
  }

  def ruleProperty2Column = partial[Property, Column] {
    case Property(name, _, _, dataType, false) ⇒ Column(name, dataType.name)
  }

  implicit val _ruleProperty2Column = partialRule(ruleProperty2Column)
  //  implicit val _ruleProperty2Column2 = rule(ruleProperty2Column2)

}
