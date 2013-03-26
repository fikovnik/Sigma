package fr.unice.i3s.sigma.validation

import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import fr.unice.i3s.sigma.examples.library.support.LibraryPackageScalaSupport
import fr.unice.i3s.sigma.examples.library.support.LibraryBuilder._
import fr.unice.i3s.sigma.examples.library.support.LibraryAssignments._
import fr.unice.i3s.sigma.test.scalatest.ValidationMatchers

@RunWith(classOf[JUnitRunner])
class ValidationContextSpec extends FlatSpec with MustMatchers with LibraryPackageScalaSupport {

  "ValidationContext" must "use guard priod to validation" in {

    val ctx = new ValidationContext[Book]() {
      guard = self.name != null

      Constraint('AlwaysPass) { inv ⇒
        inv.check = true
      }
    }

    ctx.validate(Book(name = "MyBook")).passed must be === true
    ctx.validate(Book()).cancelled must be === true
  }

  it must "support constraint satisfaction" in {
    val ctx = new ValidationContext[Book]() {
      Constraint('NotNullName) { inv ⇒
        inv.check = self.name != null
      }

      Constraint('NotEmptyName) { inv ⇒
        inv.guard = self satisfies 'NotNullName
        inv.check = !self.name.trim.isEmpty
      }
    }

    val res = ctx.validate(Book())
    res.violates("NotNullName") must be === true
    res.results("NotEmptyName") must be === Cancelled

  }

  "Constraint" must "register itself into the surrounding validation context scope" in {
    val ctx = new ValidationContext[Book]() { inv ⇒
      Constraint('Hi) { inv ⇒
        inv.check = self.name != null
      }
    }

    ctx.validate(Book(name = "MyBook")).passed must be === true
    ctx.validate(Book()).passed must be === false
  }

}