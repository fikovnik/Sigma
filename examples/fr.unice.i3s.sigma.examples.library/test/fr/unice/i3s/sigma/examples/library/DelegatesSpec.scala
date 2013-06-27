package fr.unice.i3s.sigma.examples.library

import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import fr.unice.i3s.sigma.examples.library.support.LibraryPackageScalaSupport
import org.junit.runner.RunWith
import fr.unice.i3s.sigma.examples.library.impl.LibraryImplDelegate
import fr.unice.i3s.sigma.examples.library.impl.BookImplDelegate
import fr.unice.i3s.sigma.examples.library.impl.MemberImplDelegate
import fr.unice.i3s.sigma.examples.library.impl.BookImplDelegate
import fr.unice.i3s.sigma.examples.library.impl.LibraryImplDelegate
import fr.unice.i3s.sigma.examples.library.impl.MemberImplDelegate
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DelegatesSpec extends FlatSpec with MustMatchers with LibraryPackageScalaSupport {

  "Instance delegates" must "be correctly installed" in {

    Library().getClass must be(classOf[LibraryImplDelegate])
    Book().getClass must be(classOf[BookImplDelegate])
    Member().getClass must be(classOf[MemberImplDelegate])

  }

  "Library delegate" must "find book by name" in {

    val lib = Library()
    val book1 = lib.books +== Book(name = "Book 1")
    val book2 = lib.books +== Book(name = "Book 2")
    val book3 = lib.books +== Book(name = "Book 3")

    lib.getBookByName("Book 2") must be(book2)
    lib.getBookByName("Book 4") must be(null)

  }

  "Book delegate" must "check for availablity" in {

    val lib = Library()
    val member1 = lib.members +== Member()
    val book1 = lib.books +== Book(name = "Book 1", copies = 1)
    val book2 = lib.books +== Book(name = "Book 2", copies = 2)
    lib.loans += Loan() init { x ⇒
      x.book = book1
      x.member = member1
    }
    lib.loans += Loan() init { x ⇒
      x.book = book2
      x.member = member1
    }

    book1.isAvailable must be(false)
    book2.isAvailable must be(true)
  }

  "Book delegate" must "get book loans" in {

    val lib = Library()
    val member1 = lib.members +== Member()
    val member2 = lib.members +== Member()
    val book1 = lib.books +== Book(name = "Book 1", copies = 1)
    val loan1 = lib.loans +== Loan() init { x ⇒
      x.book = book1
      x.member = member1
    }
    val loan2 = lib.loans +== Loan() init { x ⇒
      x.book = book1
      x.member = member2
    }

    book1.loans must have size (2)
    book1.loans must contain(loan1)
    book1.loans must contain(loan2)

  }

  "Member delegate" must "get member loans" in {

    val lib = Library()
    val member1 = lib.members +== Member()
    val book1 = lib.books +== Book(name = "Book 1", copies = 1)
    val book2 = lib.books +== Book(name = "Book 2", copies = 1)
    val loan1 = lib.loans +== Loan() init { x ⇒
      x.book = book1
      x.member = member1
    }
    val loan2 = lib.loans +== Loan() init { x ⇒
      x.book = book2
      x.member = member1
    }

    member1.loans must have size (2)
    member1.loans must contain(loan1)
    member1.loans must contain(loan2)

  }

  "Member delegate" must "get member books" in {

    val lib = Library()
    val member1 = lib.members +== Member()
    val book1 = lib.books +== Book(name = "Book 1", copies = 1)
    val book2 = lib.books +== Book(name = "Book 2", copies = 1)
    val loan1 = lib.loans +== Loan() init { x ⇒
      x.book = book1
      x.member = member1
    }
    val loan2 = lib.loans +== Loan() init { x ⇒
      x.book = book2
      x.member = member1
    }

    member1.books must have size (2)
    member1.books must contain(book1)
    member1.books must contain(book2)

  }

}