package fr.unice.i3s.sigma.examples.sle13

import fr.unice.i3s.sigma.validation.ValidationContext
import uml.support.UmlPackageScalaSupport
import uml.ScopeKind
import fr.unice.i3s.sigma.validation.InvMethods
import fr.unice.i3s.sigma.validation.Passed
import language.postfixOps
import fr.unice.i3s.sigma.validation.Error
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.MustMatchers

class Singleton extends ValidationContext with InvMethods
  with UmlPackageScalaSupport {

  type Self = UMLClass // context type, the type of self
  // context guard
  override def guard = {
    self.stereotypes exists (_.name == "singleton")
  }

  def invHasGetInstance =
    getGetInstanceOperation(self) != null

  def invGetInstanceIsStatic = guardedBy {
    self satisfies invHasGetInstance
  } check {
    val op = getGetInstanceOperation(self)
    if (op.ownerScope == ScopeKind.SK_CLASSIFIER) Passed
    else Error(s"${self.name}.getInstance must be static")
      .quickFix(s"Change ${self.name}.getInstance to static") {
        op.ownerScope = ScopeKind.SK_CLASSIFIER
      }
  }

  def getGetInstanceOperation(c: UMLClass): Operation =
    c.operations find (_.name == "getInstance") orNull
}

@RunWith(classOf[JUnitRunner])
class ModelValidationTest extends FunSuite with MustMatchers with UmlPackageScalaSupport {

  test("Check correct class") {
    val clazz = UMLClass(
      name = "A",
      stereotypes = Seq(
        Stereotype("singleton")
      ),
      operations = Seq(
        Operation(name = "getInstance", ownerScope = ScopeKind.SK_CLASSIFIER)
      )
    )

    val ctx = new Singleton
    val res = ctx.validate(clazz)

    res.passed must be(true)
  }

  test("Check incorrect class") {
    val clazz = UMLClass(
      name = "A",
      stereotypes = Seq(
        Stereotype("singleton")
      )
    )

    val ctx = new Singleton
    val res = ctx.validate(clazz)

    res.passed must be(false)
    res.violates('HasGetInstance) must be(true)
    res.violates('GetInstanceIsStatic) must be(true)
  }

  test("Check almost correct class") {
    val clazz = UMLClass(
      name = "A",
      stereotypes = Seq(
        Stereotype("singleton")
      ),
      operations = Seq(
        Operation(name = "getInstance")
      )
    )

    val ctx = new Singleton
    val res = ctx.validate(clazz)

    res.passed must be(false)
    res.violates('HasGetInstance) must be(false)
    res.violates('GetInstanceIsStatic) must be(true)
    val inv = res.results('GetInstanceIsStatic)

    inv match {
      case Error(_, fixes) ⇒
        fixes must have(size(1))

        val fix = fixes(0)

        fix.title must be("Change A.getInstance to static")
        clazz.operations(0).ownerScope must be(ScopeKind.SK_INSTANCE)

        ctx.fix(clazz, fix)

        clazz.operations(0).ownerScope must be(ScopeKind.SK_CLASSIFIER)

      case _ ⇒ fail("Must be an error instance")
    }

    ctx.validate(clazz).passed must be(true)

  }
}