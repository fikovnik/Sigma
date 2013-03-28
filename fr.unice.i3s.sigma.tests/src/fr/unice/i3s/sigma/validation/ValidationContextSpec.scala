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

      new Constraint {
        name = 'AlwaysPass
        check = true
      }
    }

    ctx.validate(Book(name = "MyBook")).passed must be === true
    ctx.validate(Book()).cancelled must be === true
  }

  it must "support constraint satisfaction" in {
    val ctx = new ValidationContext[Book]() {
      new Constraint {
        name = 'NotNullName
        check = self.name != null
      }

      new Constraint {
        name = 'NotEmptyName
        guard = self satisfies 'NotNullName
        check = !self.name.trim.isEmpty
      }
    }

    checkBooks(ctx)
  }

  it must "register all constraint checking methods" in {
    val ctx = new ValidationContext[Book]() {
      def invNotNullName = self.name != null

      def invNotEmptyName_Guard = self satisfies 'NotNullName
      def invNotEmptyName = {
        if (!self.name.trim.isEmpty) Passed
        else Error("Empty name")
      }
    }

    checkBooks(ctx)
  }

  it must "support adding constraint via builder" in {
    val ctx = new ValidationContext[Book]() {
      constraint('NotNullName) check {
        self.name != null
      }

      constraint('NotEmptyName) guardedBy {
        self satisfies 'NotNullName
      } check {
        if (!self.name.trim.isEmpty) Passed
        else Error("Empty name")
      }
    }

    checkBooks(ctx)
  }

  def checkBooks(ctx: ValidationContext[Book]) {
    ctx.constraints must have(size(2))

    {
      val res = ctx.validate(Book())
      res.violates('NotNullName) must be === true
      res.results('NotEmptyName) must be === Cancelled
    }

    {
      val res = ctx.validate(Book(name = "MyBook"))
      res.passed must be === true
    }
  }

  it must "support fixes" in {
    val ctx = new ValidationContext[Book]() {
      constraint('NotNullName) check {
        if (self.name != null)
          Passed
        else {
          new Error {
            message = "Name must not be empty"
            new Fix {
              title = "Set name"
              perform = {
                self.name = "NewName"
              }
            }
          }
        }
      }
    }

    ctx.constraints must have(size(1))

    val book = Book()
    val res = ctx.validate(book)
    val err = res.results('NotNullName)
    err match {
      case x: Error ⇒
        x.fixes must have(size(1))

        val fix = x.fixes(0)

        fix.title must be === "Set name"
        book.name must be === null

        ctx.fix(book, fix)

        book.name must be === "NewName"

      case _ ⇒ fail("Must be an error instance")
    }

  }

  "Constraint" must "register itself into the surrounding validation context scope" in {
    val ctx = new ValidationContext[Book]() {
      new Constraint {
        name = 'Hi
        check = self.name != null
      }
    }

    ctx.validate(Book(name = "MyBook")).passed must be === true
    ctx.validate(Book()).passed must be === false
  }

}