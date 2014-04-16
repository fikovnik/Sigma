package fr.unice.i3s.sigma.examples.perfromance.sigma;

import fr.unice.i3s.sigma.validation.ValidationContext
import fr.unice.i3s.sigma.validation.Error
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner
import org.scalatest.Matchers
import fr.unice.i3s.sigma.examples.simpleoo.support.SimpleooPackageScalaSupport
import fr.unice.i3s.sigma.examples.simpleoo.ScopeKind

trait SingletonSpec { this: FlatSpec with SimpleooPackageScalaSupport with Matchers ⇒

  import _simpleoo._
  
  def singletonValidationContext(ctx: ValidationContext { type Self = Class }) {
    it must "Check guard" in {
      val clazz = Class(name = "A")

      val res = ctx.validate(clazz)

      res.cancelled should be(true)
    }

    it must "Pass on correct class" in {
      val clazz = Class(
        name = "A",
        stereotypes = Seq(
          Stereotype("singleton")
        ),
        features = Seq(
          Operation(name = "getInstance", ownerScope = ScopeKind.SK_CLASSIFIER)
        )
      )

      val res = ctx.validate(clazz)

      res.passed should be(true)
    }

    it must "Fail on incorrect class" in {
      val clazz = Class(
        name = "A",
        stereotypes = Seq(
          Stereotype("singleton")
        )
      )

      val res = ctx.validate(clazz)

      res.passed should be(false)
      res.violates("HasGetInstance") should be(true)
      res.violates("GetInstanceIsStatic") should be(true)
    }

    it must "Fail and correct an incorrect class" in {
      val clazz = Class(
        name = "A",
        stereotypes = Seq(
          Stereotype("singleton")
        ),
        features = Seq(
          Operation(name = "getInstance")
        )
      )

      val res = ctx.validate(clazz)

      res.passed should be(false)
      res.violates("HasGetInstance") should be(false)
      res.violates("GetInstanceIsStatic") should be(true)
      val inv = res.results("GetInstanceIsStatic")

      inv match {
        case Error(_, fixes) ⇒
          fixes should have size(1)

          val fix = fixes(0)

          fix.title should be("Change A.getInstance to static")
          clazz.operations(0).ownerScope should be(ScopeKind.SK_INSTANCE)

          ctx.fix(clazz, fix)

          clazz.operations(0).ownerScope should be(ScopeKind.SK_CLASSIFIER)

        case _ ⇒ fail("Must be an error instance")
      }

      ctx.validate(clazz).passed should be(true)
    }
  }
}