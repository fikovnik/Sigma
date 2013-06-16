package fr.unice.i3s.sigma.examples.sle13.sigma

import scala.collection.JavaConversions._
import org.scalatest.FunSuite
import library.support.LibraryPackageScalaSupport
import org.scalatest.BeforeAndAfter
import org.junit.runner.RunWith
import org.scalatest.matchers.MustMatchers
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CommonInfrastructureTest extends FunSuite with MustMatchers with BeforeAndAfter with LibraryPackageScalaSupport {

  var library: Library = _

  before {
    library = Library()
    library.catalog += Book("A", null, 101)
    library.catalog += Book("B", null, 102)
    library.catalog += Book("C", null, 100)

  }

  test("Select names of books with more than 100 pages") {
    val books =
      library.catalog.filter(b ⇒ b.pages > 100) //more than 100 pages
        .map(b ⇒ b.name) // get name

    books must contain("A")
    books must contain("B")
    books must not(contain("C"))
  }

  test("Select names of books with more than 100 pages using pattern matching") {
    val books =
      library.catalog collect {
        case Book(name, author, pages) if pages > 100 ⇒ name
      }

    books must contain("A")
    books must contain("B")
    books must not(contain("C"))
  }

  test("Book constructor") {
    // Scala support named arguments in method calls
    val sicp = Book(name = "SICP", author = Author("H. Abelson"))
    sicp.pages = 683 // Scala setter

    sicp.name must be("SICP")
    sicp.author.name must be("H. Abelson")
    sicp.pages must be(683)
  }

  test("Delayed init") {
    val sicp = Book(name = "SICP") initLater { e ⇒
      e.pages = 683
    }

    sicp.pages must be(0)

    library.catalog += sicp //adds to library and executes initLater

    sicp.pages must be(683)
  }

  test("Lazy proxy resolution") {
    val sicp = Book(name = "SICP")
    // following expression creates a new Book proxy instance
    // using the book additional setter that accepts Option
    sicp.author = library.authors.find(_.name == "H. Abelson")
    // ...

    sicp.author.eIsProxy must be(true)

    library.authors += Author(name = "H. Abelson")

    sicp.author.name must be("H. Abelson")

    // sicp author proxy gets resolved
    assert(sicp.author.name == "H. Abelson")
  }

}