package fr.unice.i3s.sigma.support

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class EMFBuilderTest extends FunSuite {

  test("Overload hack for the setters") {

    trait OverloadHack {
      // one class per overloaded method
      class Overloaded1
      class Overloaded2

      // one implicit val per overloaded method
      implicit val overload1 = new Overloaded1
      implicit val overload2 = new Overloaded2
    }

    class A {
      var name: String = _
    }
    class B {
      var name: String = _
    }

    class Test extends OverloadHack {
      private def nothing: Nothing = sys.error("this method is not meant to be called")
      def name(implicit ev: Nothing) = nothing

      def name_=[T <: A](name: String)(implicit o: Overloaded1) =
        (subject: T) ⇒ subject.name = name
      def name_=[T <: B](name: String)(implicit o: Overloaded2) =
        (subject: T) ⇒ subject.name = name

      def a(configs: (A ⇒ Any)*) = {
        configure(new A, configs: _*)
      }
      def b(configs: (B ⇒ Any)*) = {
        configure(new B, configs: _*)
      }

      def configure[T](target: T, configs: (T ⇒ Any)*): T = {
        configs.foreach(cfg ⇒ cfg(target))
        target
      }

    }
    val builder = new Test
    import builder._

    val ia = a(name = "a")
    val ib = b(name = "b")

    assert(ia.name === "a")
    assert(ib.name === "b")

  }

}