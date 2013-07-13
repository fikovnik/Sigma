package fr.unice.i3s.sigma.examples.library

import org.junit.runner.RunWith
import org.scalatest.matchers.MustMatchers
import org.scalatest.FlatSpec
import fr.unice.i3s.sigma.examples.library.support.LibraryPackageScalaSupport
import org.scalatest.junit.JUnitRunner
import org.scalatest.BeforeAndAfter
import scala.collection.mutable.Buffer

@RunWith(classOf[JUnitRunner])
class CommonInfrastructureSpec extends FlatSpec with MustMatchers with BeforeAndAfter with LibraryPackageScalaSupport {

  var library: Library = _
  var bookA: Book = _
  var bookB: Book = _
  var bookC: Book = _

  before {
    library = Library()
    bookA = library.books +== Book(name = "A", copies = 2)
    bookB = library.books +== Book(name = "B", copies = 2)
    bookC = library.books +== Book(name = "C", copies = 1)

  }

  "Common Infrastructure" must "select books with more than 1 copy" in {
    val books = library.books filter (b ⇒ b.copies > 1)

    books must be(Buffer(bookA, bookB))
  }

  it must "select books with more than 1 copy using pattern matching" in {
    val books =
      library.books collect {
        // it filters and map at the same time
        case Book(name, _, copies, _, _, _) if copies > 1 ⇒ name
      }

    books must be(Buffer("A", "B"))
  }

  it must "support delayed initialization" in {
    val bookD = Book(name = "D") initLater { e ⇒
      e.copies = 10
    }

    // the initLater has not been yet executed
    bookD.copies must be(0)

    //adds to library and executes initLater
    library.books += bookD

    bookD.copies must be(10)
  }

  it must "support lazy proxy resolution in non-contained reference" in {
    val sicp = library.books +== Book(name = "SICP")

    // the author setter is overloaded
    // this expression is using the Option[Author] version
    // it will create EMF proxy
    sicp.author = library.authors find (_.name == "H. Abelson")
    sicp.author.eIsProxy must be(true)

    // when we add author the proxy will be resolved
    library.authors +== Author(name = "H. Abelson")

    // author proxy gets resolved
    sicp.author.name must be ("H. Abelson")
    sicp.author.eIsProxy must be(false)
  }

  it must "support lazy proxy resolution in non-contained reference list" in {
    // categories are empty
    bookA.categories must have size (0)

    // add a category using the overloaded operator +=(value: Option[A])
    bookA.categories += library.categories find (_.name == "C1")

    // a proxy has been created
    bookA.categories must have size (1)
    bookA.categories(0).eIsProxy must be(true)

    // when we add category the proxy will be resolved
    val category1 = library.categories +== Category("C1")
    
    bookA.categories(0) must be (category1)
  }
  
}