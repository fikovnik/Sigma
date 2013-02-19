package fr.unice.i3s.sigma.docgen.graphviz.core.internal

import scala.collection.JavaConversions.asScalaBuffer

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.MustMatchers

import fr.unice.i3s.sigma.scala.mtt.TextSection.endl
import fr.unice.i3s.sigma.scala.mtt.TextTemplateTest
import fr.unice.i3s.sigma.scala.utils.EcoreBuilder
import fr.unice.i3s.sigma.scala.utils.ecore.EcoreScalaSupport

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
    diag.toString.split(endl).head must be ===
      "MyPackage__A:port -> MyPackage__B:port ["

  }

}