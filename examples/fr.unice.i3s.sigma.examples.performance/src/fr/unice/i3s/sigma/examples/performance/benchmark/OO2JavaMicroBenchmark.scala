package fr.unice.i3s.sigma.examples.performance.benchmark

import org.scalameter.PerformanceTest
import org.scalameter.Gen
import fr.unice.i3s.sigma.examples.performance.sigma.OO2Java
import oo.support.OOPackageScalaSupport
import java.io.File
import com.google.common.io.Files
import fr.unice.i3s.sigma.util.IOUtils.RichSigmaFile

object OO2JavaMicroBenchmark extends PerformanceTest.Microbenchmark with OOPackageScalaSupport {

  def createModel(classes: Int, properties: Int, methods: Int) = {
    new OO2JavaModelGenerator(classes, methods, properties).generate()
  }

  val sizes = Array(10, 25)

  val models = for {
    classes ← Gen.enumeration("classes")(sizes: _*)
    properties ← Gen.enumeration("properties")(sizes: _*)
    methods ← Gen.enumeration("methods")(sizes: _*)
  } yield createModel(classes, properties, methods)

  val targetDir = Files.createTempDir()
  
  performance of "OO2Java" in {
    using(models) in { res ⇒
      val template = new OO2Java
      val pkg = res.getContents.get(0).asInstanceOf[Package]
      pkg.ownedElements foreach { x ⇒
        x match {
          case cls: Class ⇒
            new File(targetDir, s"${cls.name}.java") << template.transform(cls)
          case _ ⇒
        }
      }
    }
  }

}