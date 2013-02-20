package fr.unice.i3s.sigma.docgen.graphviz.common

import scala.collection.JavaConversions._
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.MustMatchers
import fr.unice.i3s.sigma.scala.utils.EcoreBuilder
import fr.unice.i3s.sigma.scala.utils.ecore.EcoreScalaSupport
import fr.unice.i3s.sigma.scala.mtt.TextTemplateTest

@RunWith(classOf[JUnitRunner])
class ClassDiagramSpec extends FlatSpec with MustMatchers with EcoreScalaSupport {

  "ClassDiagram" must "must render a generalization" in {

    val builder = new EcoreBuilder
    import builder._

    val pkg = ePackage(name = "MyPackage", nsURI = "http://mypkg", nsPrefix = "my")
    val classA = eClass("A")
    val classB = eClass("B", eSuperTypes = List(classA))
    pkg.eClassifiers += (classA, classB)

    val diag = new ClassDiagram(pkg) with TextTemplateTest
    diag.renderGeneralization(classB, classA)

    // actually we only need to check the first row
    diag.toString.split("\n").head must be ===
      "MyPackage__A:port -> MyPackage__B:port ["

  }

}