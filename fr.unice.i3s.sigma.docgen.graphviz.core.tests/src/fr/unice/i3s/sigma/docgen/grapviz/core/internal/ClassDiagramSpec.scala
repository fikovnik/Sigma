package fr.unice.i3s.sigma.docgen.grapviz.core.internal

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.MustMatchers
import org.scalatest.FlatSpec
import org.eclipse.emf.ecore.EcoreFactory
import fr.unice.i3s.sigma.docgen.graphviz.core.internal.ClassDiagram
import java.io.File
import fr.unice.i3s.sigma.scala.utils._
import fr.unice.i3s.sigma.scala.utils.io._
import org.eclipse.emf.ecore.EAttribute
import fr.unice.i3s.sigma.scala.utils.EcoreBuilder
import org.eclipse.emf.ecore.EcorePackage
import fr.unice.i3s.sigma.scala.utils.ecore.EcoreScalaSupport

@RunWith(classOf[JUnitRunner])
class ClassDiagramSpec extends FlatSpec with MustMatchers with EcoreScalaSupport {

  "ClassDiagram" must "must render a class" in {

    val builder = new EcoreBuilder
    import builder._

    val pkg = ePackage(name = "MyPackage", nsURI = "http://mypkg", nsPrefix = "my")
    pkg eClassifiers {

      val classA = eClass("A")
      classA eStructuralFeatures {
        //        0 until 10 foreach { i ⇒
        eAttribute(name = s"Attribute", eType = EcorePackage.eINSTANCE.getEString)
        //        }
      }

      val classB = eClass("B")
      classB eStructuralFeatures {
        //        0 until 10 foreach { i ⇒
        eReference(name = s"Reference", containment = true, eType = classA)
        //        }
      }

    }

    println(pkg.validate prettyPrint)

    assert(pkg isValid)

    val diag = new ClassDiagram(pkg)

    using(new File("/tmp/test.dot")) { f ⇒
      diag >> f
    }

  }

}