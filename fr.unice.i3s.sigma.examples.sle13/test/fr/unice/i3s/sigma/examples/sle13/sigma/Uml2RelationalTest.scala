package fr.unice.i3s.sigma.examples.sle13.sigma

import org.junit.runner.RunWith
import org.scalatest.matchers.MustMatchers
import org.scalatest.FunSuite
import uml.support.UmlPackageScalaSupport
import relational.support.RelationalPackageScalaSupport
import fr.unice.i3s.sigma.m2m.M2M
import org.scalatest.junit.JUnitRunner



@RunWith(classOf[JUnitRunner])
class Uml2RelationalTest extends FunSuite with MustMatchers with UmlPackageScalaSupport with RelationalPackageScalaSupport {

  test("Simple test") {

    val int = PrimitiveType(name = "int")
    val clazz = UmlClass(
      name = "A",
      attributes = Seq(
        Property(name = "a", `type` = int, multi = false),
        Property(name = "b", `type` = int, multi = true)
      )
    )

    val trans = new Uml2Relational
    val res = trans.transform(clazz)

  }

}