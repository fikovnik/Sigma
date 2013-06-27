package fr.unice.i3s.sigma.examples.sle13.sigma

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import org.junit.runner.RunWith
import org.scalatest.matchers.MustMatchers
import org.scalatest.junit.JUnitRunner
import scala.collection.mutable.Buffer
import oo.Package
import oo.support.OOPackageScalaSupport
import fr.unice.i3s.sigma.support.EMFProxyBuilder

@RunWith(classOf[JUnitRunner])
class CommonInfrastructureTest extends FunSuite with MustMatchers with BeforeAndAfter with OOPackageScalaSupport {

  var pkg: Package = _

  before {
    pkg = Package()

    val singleton = pkg.ownedStereotypes +== Stereotype("singleton")

    pkg.ownedElements += Class(name = "A", stereotypes = Seq(singleton))
    pkg.ownedElements += Class(name = "B", stereotypes = Seq(singleton), features = Seq(Operation(name = "op1")))
    pkg.ownedElements += Class(name = "C")
  }

  test("Select names of singletons") {
    val singletons =
      pkg.ownedElements
        .filter(e ⇒ e.stereotypes exists (s ⇒ s.name == "singleton"))
        .map(e ⇒ e.name)

    singletons must contain("A")
    singletons must contain("B")
    singletons must not(contain("C"))
  }

  test("Select name of all operations") {
    val res = pkg.ownedElements collect {
      case x: Class ⇒ x.operations map (_.name)
    }

    res must be(Seq(Seq(), Seq("op1"), Seq()))
  }

  test("Construct a class") {
    val cls = Class(name = "MyClass")
    cls.stereotypes += Stereotype(name = "singleton")
    cls.features += Operation(name = "getInstance", returnType = cls)

    cls.name must be("MyClass")
    cls.stereotypes must have size (1)
    cls.features must have size (1)
  }

  test("Delayed init") {
    val cls = Class() initLater { x ⇒
      x.name = "MyClass"
    }

    cls.name must be(null)

    pkg.ownedElements += cls //adds to package and executes initLater

    cls.name must be("MyClass")
  }
  
  test("Lazy proxy resolution") {
    val cls = Class(name = "MyClass")
    cls.stereotypes += pkg.ownedStereotypes.find(_.name == "transient")

    cls.stereotypes(0).eIsProxy must be(true)

    pkg.ownedStereotypes += Stereotype(name = "transient")
    
    cls.stereotypes(0).eIsProxy must be(false)
    cls.stereotypes(0).name must be("transient")
  }

}