package fr.unice.i3s.sigma.examples.sle13.sigma

import fr.unice.i3s.sigma.m2m.M2M
import relational.support.RelationalPackageScalaSupport
import uml.support.UmlPackageScalaSupport
import fr.unice.i3s.sigma.m2m.RuleMethods

class Uml2Relational extends M2M with RuleMethods
  with UmlPackageScalaSupport with RelationalPackageScalaSupport {

  def ruleClass2Table(cls: UmlClass, tab: Table, pkey: Column) {
    tab.name = cls.name;
    tab.columns += pkey
    tab.columns ++= ~cls.properties

    pkey.name = "Id"
    pkey.dataType = "Int"
  }

  def ruleProperty2Column3(prop: Property) = guardedBy {
	  !prop.multi
  } transform {
	  Column(prop.name, prop.`type`.name)
  }
  
  def ruleProperty2Column2(prop: Property) = guardedBy {
    !prop.multi
  } transform {
    Column(prop.name, prop.`type`.name)
  }

  def ruleProperty2Column = partial[Property, Column] {
    case Property(name, _, _, dt, false) ⇒ Column(name, dt.name)
  }

  implicit val _ruleProperty2Column = partialRule(ruleProperty2Column)
  //  implicit val _ruleProperty2Column2 = rule(ruleProperty2Column2)

}
