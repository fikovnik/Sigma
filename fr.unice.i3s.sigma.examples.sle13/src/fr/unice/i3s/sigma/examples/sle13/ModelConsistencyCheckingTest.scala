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
import fr.unice.i3s.sigma.validation.InvBuilder
import org.scalatest.FlatSpec

class SingletonMethodBased extends ValidationContext with InvMethods
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

class SingletonBuilderBased extends ValidationContext with InvBuilder with UmlPackageScalaSupport {

  type Self = UMLClass // context type, the type of self

  // context guard
  override def guard = {
    self.stereotypes exists (_.name == "singleton")
  }

  constraint("HasGetInstance")
    .check { getGetInstanceOperation(self) != null }

  constraint("GetInstanceIsStatic")
    .guardedBy { self satisfies "HasGetInstance" }
    .check {
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

trait SingletonSpec { this: FlatSpec with UmlPackageScalaSupport with MustMatchers ⇒

  def singletonValidationContext(ctx: ValidationContext { type Self = UMLClass }) {
    it must "Check guard" in {
      val clazz = UMLClass(name = "A")

      val res = ctx.validate(clazz)

      res.cancelled must be(true)
    }

    it must "Pass on correct class" in {
      val clazz = UMLClass(
        name = "A",
        stereotypes = Seq(
          Stereotype("singleton")
        ),
        operations = Seq(
          Operation(name = "getInstance", ownerScope = ScopeKind.SK_CLASSIFIER)
        )
      )

      val res = ctx.validate(clazz)

      res.passed must be(true)
    }

    it must "Fail on incorrect class" in {
      val clazz = UMLClass(
        name = "A",
        stereotypes = Seq(
          Stereotype("singleton")
        )
      )

      val res = ctx.validate(clazz)

      res.passed must be(false)
      res.violates("HasGetInstance") must be(true)
      res.violates("GetInstanceIsStatic") must be(true)
    }

    it must "Fail and correct an incorrect class" in {
      val clazz = UMLClass(
        name = "A",
        stereotypes = Seq(
          Stereotype("singleton")
        ),
        operations = Seq(
          Operation(name = "getInstance")
        )
      )

      val res = ctx.validate(clazz)

      res.passed must be(false)
      res.violates("HasGetInstance") must be(false)
      res.violates("GetInstanceIsStatic") must be(true)
      val inv = res.results("GetInstanceIsStatic")

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
}

@RunWith(classOf[JUnitRunner])
class ModelValidationTest extends FlatSpec with MustMatchers with UmlPackageScalaSupport
  with SingletonSpec {

  "Method based validation context" must behave like singletonValidationContext(new SingletonMethodBased)
  "Builder based validation context" must behave like singletonValidationContext(new SingletonBuilderBased)

}