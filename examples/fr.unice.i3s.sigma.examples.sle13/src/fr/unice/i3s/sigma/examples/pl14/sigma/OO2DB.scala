package fr.unice.i3s.sigma.examples.pl14.sigma

import fr.unice.i3s.sigma.m2m.M2M
import fr.unice.i3s.sigma.m2m.RuleMethods
import db.support.DBPackageScalaSupport
import oo.support.OOPackageScalaSupport
import db.DBPackage
import fr.unice.i3s.sigma.m2m.Lazy
import fr.unice.i3s.sigma.m2m.Unique

class OO2DB extends M2M with RuleMethods
  with OOPackageScalaSupport with DBPackageScalaSupport {

  val targetMetaModels = Seq(DBPackage.eINSTANCE)

  def ruleClass2Table(cls: Class, tab: Table, pkey: Column) {
    tab.name = cls.name;
    tab.columns += pkey
    tab.columns ++= ~cls.properties

    pkey.name = "Id"
    pkey.dataType = "Int"
  }

  // ALTERNATIVES to Property2Column

  @Lazy
  def ruleProperty2Column(prop: Property, col: Column) = guardedBy {
    !prop.multi && prop.type_.isInstanceOf[PrimitiveType]
  } transform {
    col.name = prop.name
    col.dataType = prop.type_.name
  }

  //  def ruleProperty2Column(prop: Property) = guardedBy {
  //    !prop.multi && prop.type_.isInstanceOf[PrimitiveType]
  //  } transform {
  //    Column(prop.name, prop.type_.name)
  //  }
  //  

  //  def ruleProperty2Column = partial[Property, Column] {
  //    case p: Property if !p.multi && p.type_.isInstanceOf[PrimitiveType] ⇒
  //      Column(p.name, p.type_.name)
  //  }

  //  def ruleProperty2Column = partial[Property, Column] {
  //    case Property(_, name, _, type_ : PrimitiveType, false) ⇒
  //      Column(name, type_.name)
  //  }

}
