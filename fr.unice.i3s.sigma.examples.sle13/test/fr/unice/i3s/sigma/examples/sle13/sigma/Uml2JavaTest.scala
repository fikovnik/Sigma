package fr.unice.i3s.sigma.examples.sle13.sigma

//import org.scalatest.matchers.MustMatchers
//import org.junit.runner.RunWith
//import uml.support.UmlPackageScalaSupport
//import org.scalatest.FunSuite
//import org.scalatest.junit.JUnitRunner
//
//@RunWith(classOf[JUnitRunner])
//class Uml2JavaTest extends FunSuite with MustMatchers with UmlPackageScalaSupport {
//
//  test("Must generate simple class") {
//
//    val int = PrimitiveType(name = "int")
//    val clazz = UmlClass(
//      name = "A",
//      operations = Seq(
//        Operation(name = "a", returnType = int),
//        Operation(name = "b", returnType = int)
//      )
//    )
//
//    val generator = Uml2Java(clazz)
//    println(generator.toString)
//    generator.toString must be ===
//      """|public class A {
//		 |  
//		 |  public int a() {
//		 |    // TODO: should be implemented
//		 |    throw new UnsupportedOperationException("a");
//		 |  }
//		 |  
//		 |  public int b() {
//		 |    // TODO: should be implemented
//		 |    throw new UnsupportedOperationException("b");
//		 |  }
//		 |}
//         |""".stripMargin
//
//  }
//
//}