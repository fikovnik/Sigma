package fr.unice.i3s.sigma.examples.pl14.sigma

import org.junit.runner.RunWith
import org.scalatest.matchers.MustMatchers
import org.scalatest.FunSuite
import fr.unice.i3s.sigma.m2m.M2M
import org.scalatest.junit.JUnitRunner
import scala.collection.mutable.Buffer
import org.eclipse.emf.ecore.EObject
import org.junit.Test
import oo.support.OOPackageScalaSupport
import db.support.DBPackageScalaSupport
import fr.unice.i3s.sigma.util.EMFUtils


//class OO2DBTest extends UmlPackageScalaSupport 
//  with RelationalPackageScalaSupport {
//  
//  @Test
//  def testRuleProperty2Column {
//	val int = PrimitiveType(name = "int")
//    val m2t = new Uml2Relational
//    val p = Property(name = "a", `type` = int, multi = false)
//    assert(m2t.ruleProperty2Column(p) == 
//      Some(Column(name = "a", dataType = "int" )))
//  }
//  
//}
//

@RunWith(classOf[JUnitRunner])
class OO2DBTest extends FunSuite with MustMatchers with OOPackageScalaSupport with DBPackageScalaSupport {

  EMFUtils.IO.registerDefaultFactories
  
  test("Simple test") {

    val int = PrimitiveType(name = "int")
    val clazz = Class(
      name = "A",
      features = Seq(
        Property(name = "a", type_ = int, multi = false),
        Property(name = "b", type_ = int, multi = true)
      )
    )

    val db = Buffer[EObject]()
    val classes = Buffer(clazz)
//  val oo2db = new ExperimentalOO2DB()
    val oo2db = new OO2DB()
    for (c <- classes) db ++= oo2db(c)

    db foreach (_.dump())
  }

}