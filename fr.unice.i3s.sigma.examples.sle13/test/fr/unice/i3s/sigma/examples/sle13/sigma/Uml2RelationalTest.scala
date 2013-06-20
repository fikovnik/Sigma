package fr.unice.i3s.sigma.examples.sle13.sigma

import org.junit.runner.RunWith
import org.scalatest.matchers.MustMatchers
import org.scalatest.FunSuite
import uml.support.UmlPackageScalaSupport
import relational.support.RelationalPackageScalaSupport
import fr.unice.i3s.sigma.m2m.M2M
import org.scalatest.junit.JUnitRunner
import relational.RelationalPackage
import uml.UMLPackage
import scala.collection.mutable.Buffer
import org.eclipse.emf.ecore.EObject
import org.junit.Test


class OO2DBTest extends UmlPackageScalaSupport 
  with RelationalPackageScalaSupport {
  
  @Test
  def testRuleProperty2Column {
	val int = PrimitiveType(name = "int")
    val m2t = new Uml2Relational
    val p = Property(name = "a", `type` = int, multi = false)
    assert(m2t.ruleProperty2Column(p) == 
      Some(Column(name = "a", dataType = "int" )))
  }
  
}


@RunWith(classOf[JUnitRunner])
class Uml2RelationalTest extends FunSuite with MustMatchers with UmlPackageScalaSupport with RelationalPackageScalaSupport {

  test("Simple test") {

    val int = PrimitiveType(name = "int")
    val clazz = UmlClass(
      name = "A",
      properties = Seq(
        Property(name = "a", `type` = int, multi = false),
        Property(name = "b", `type` = int, multi = true)
      )
    )

    val trans = new Uml2Relational
    val db = Buffer[EObject]()
    val classes = Seq[UmlClass]()
    for (c <- classes) db ++= new Uml2Relational().apply(c)

  }

}