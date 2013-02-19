package fr.unice.i3s.sigma.docgen.graphviz.core.internal

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.MustMatchers
import org.scalatest.FlatSpec
import org.eclipse.emf.ecore.EcoreFactory
import java.io.File
import scala.collection.JavaConversions._
import fr.unice.i3s.sigma.scala.utils._
import fr.unice.i3s.sigma.scala.utils.io._
import org.eclipse.emf.ecore.EAttribute
import fr.unice.i3s.sigma.scala.utils.EcoreBuilder
import org.eclipse.emf.ecore.EcorePackage
import fr.unice.i3s.sigma.scala.utils.ecore.EcoreScalaSupport
import fr.unice.i3s.sigma.scala.mtt.TextSection.endl
import fr.unice.i3s.sigma.scala.mtt.TextTemplate
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
    diag.toString.split(endl).head must be ===
      "MyPackage__A:port -> MyPackage__B:port ["

  }

}