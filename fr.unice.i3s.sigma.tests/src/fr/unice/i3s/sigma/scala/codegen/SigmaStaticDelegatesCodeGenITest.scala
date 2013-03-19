package fr.unice.i3s.sigma.scala.codegen

import java.io.File
import scala.Array.canBuildFrom
import scala.Option.apply
import scala.collection.JavaConversions._
import scala.collection.immutable.List.apply
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.FileLocator
import org.eclipse.core.runtime.Path
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter
import org.eclipse.emf.codegen.ecore.genmodel.util.GenModelUtil
import org.eclipse.emf.common.EMFPlugin
import org.eclipse.emf.common.util.BasicMonitor
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.jdt.core.IJavaModelMarker
import org.eclipse.jdt.core.JavaCore
import org.junit.runner.JUnitCore
import org.junit.runner.RunWith
import org.osgi.framework.Bundle
import org.osgi.framework.Version
import org.scalatest.Finders
import org.scalatest.FunSuite
import com.google.common.io.Files.copy
import com.google.common.io.Resources
import fr.unice.i3s.sigma.scala.Activator
import fr.unice.i3s.sigma.scala.utils.Util
import org.scalatest.junit.JUnitRunner
import fr.unice.i3s.sigma.scala.ExternalProjectITest

@RunWith(classOf[JUnitRunner])
class SigmaStaticDelegatesCodeGenITest extends FunSuite with ExternalProjectITest {

  test("Generate Model with EMF static delegates") {

    val projectName = "fr.unice.i3s.sigma.scala.tests.extensions"

    importProject(projectName)
    generateModel(s"/$projectName/model/Test.genmodel");
    buildProject(projectName)
    installProject(projectName)

    val junitResult = runJUnitTest(projectName, "test.ScalaEcoreGeneratedExtensionsTest")
    assert(junitResult.wasSuccessful())
  }

}