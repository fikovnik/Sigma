package fr.unice.i3s.sigma.examples.pl14.scala

import scala.collection.JavaConversions._
import fr.unice.i3s.sigma.examples.pl14.benchmark.M2TMicroBenchmark
import org.eclipse.emf.ecore.resource.Resource
import oo.support.OOPackageScalaSupport
import fr.unice.i3s.sigma.util.IOUtils
import java.io.File
import fr.unice.i3s.sigma.examples.pl14.benchmark.BenchmarkRunner
import fr.unice.i3s.sigma.examples.pl14.benchmark.OO2JavaModelGenerator
import IOUtils.RichSigmaFile

class ScalaOO2JavaBenchmark extends M2TMicroBenchmark with OOPackageScalaSupport {
  override def pre(res: Resource) = {}

  override def post(res: Resource) = {}

  override def run(res: Resource, targetDir: File) = {
    val pkg = res.getContents.get(0).asInstanceOf[Package] 
    pkg.ownedElements foreach { x ⇒
      x match {
        case cls: Class ⇒
          new File(targetDir, s"${cls.name}.java") << new OO2JavaInScala(cls).toString
        case _ =>
      }
    }
  }
}
