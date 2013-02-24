package fr.unice.i3s.sigma.docgen.graphviz.common

import org.eclipse.emf.ecore.EcorePackage
import fr.unice.i3s.sigma.scala.utils.io._
import java.io.File

object EcoreClassDiagramTest extends App {

  val pkg = EcorePackage.eINSTANCE
  val diagram = new ClassDiagram(pkg)

  using(new File("/tmp/ecore.dot")) { f ⇒
    diagram >> f
  }

}