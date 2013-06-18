package fr.unice.i3s.sigma.examples.sle13.sigma

import scala.collection.JavaConversions._
import org.scalatest.FunSuite
import library.support.LibraryPackageScalaSupport
import org.scalatest.BeforeAndAfter
import org.junit.runner.RunWith
import org.scalatest.matchers.MustMatchers
import org.scalatest.junit.JUnitRunner
import uml.support.UmlPackageScalaSupport
import scala.collection.mutable.Buffer

@RunWith(classOf[JUnitRunner])
class CommonInfrastructureTest extends FunSuite with MustMatchers with BeforeAndAfter with UmlPackageScalaSupport {

  var pkg: UmlPackage = _

  before {
    pkg = UmlPackage()
    pkg.ownedElements += UmlClass(name = "A", stereotypes = Seq(Stereotype("singleton")))
    pkg.ownedElements += UmlClass(name = "B", stereotypes = Seq(Stereotype("singleton")), operations = Seq(Operation("op1")))
    pkg.ownedElements += UmlClass(name = "C")

  }

  test("Select names of singletons") {
    val singletons =
      pkg.ownedElements
        .filter(e ⇒ e.stereotypes exists (s => s.name == "singleton"))
        .map(e ⇒ e.name)

    singletons must contain("A")
    singletons must contain("B")
    singletons must not(contain("C"))
  }

  test("Select names and number op class operations") {
    val res =
      pkg.ownedElements collect {
        case UmlClass(name, Seq(Stereotype("singleton")),_,_,_) =>  
        case UmlClass(name,_,_,_,ops) ⇒ (name -> ops.size)
      }

    res must be === (Buffer(("A" -> 0),("B" -> 1),("C" -> 0)))
  }
//  }
//
//  test("Book constructor") {
//    // Scala support named arguments in method calls
//    val sicp = Book(name = "SICP", author = Author("H. Abelson"))
//    sicp.pages = 683 // Scala setter
//
//    sicp.name must be("SICP")
//    sicp.author.name must be("H. Abelson")
//    sicp.pages must be(683)
//  }
//
//  test("Delayed init") {
//    val sicp = Book(name = "SICP") initLater { e ⇒
//      e.pages = 683
//    }
//
//    sicp.pages must be(0)
//
//    library.catalog += sicp //adds to library and executes initLater
//
//    sicp.pages must be(683)
//  }
//
//  test("Lazy proxy resolution") {
//    val sicp = Book(name = "SICP")
//    // following expression creates a new Book proxy instance
//    // using the book additional setter that accepts Option
//    sicp.author = library.authors.find(_.name == "H. Abelson")
//    // ...
//
//    sicp.author.eIsProxy must be(true)
//
//    library.authors += Author(name = "H. Abelson")
//
//    sicp.author.name must be("H. Abelson")
//
//    // sicp author proxy gets resolved
//    assert(sicp.author.name == "H. Abelson")
//  }

}