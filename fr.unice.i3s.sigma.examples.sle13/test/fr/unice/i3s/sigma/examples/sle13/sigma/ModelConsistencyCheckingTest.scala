package fr.unice.i3s.sigma.examples.sle13.sigma

import fr.unice.i3s.sigma.validation.ValidationContext
import uml.support.UmlPackageScalaSupport
import uml.ScopeKind
import fr.unice.i3s.sigma.validation.Error
import org.junit.runner.RunWith
import org.scalatest.matchers.MustMatchers
import org.scalatest.FlatSpec
import fr.unice.i3s.sigma.examples.sle13.SingletonBuilderBased
import fr.unice.i3s.sigma.examples.sle13.SingletonMethodBased
import org.scalatest.junit.JUnitRunner

trait SingletonSpec { this: FlatSpec with UmlPackageScalaSupport with MustMatchers ⇒

  def singletonValidationContext(ctx: ValidationContext { type Self = UmlClass }) {
    it must "Check guard" in {
      val clazz = UmlClass(name = "A")

      val res = ctx.validate(clazz)

      res.cancelled must be(true)
    }

    it must "Pass on correct class" in {
      val clazz = UmlClass(
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
      val clazz = UmlClass(
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
      val clazz = UmlClass(
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