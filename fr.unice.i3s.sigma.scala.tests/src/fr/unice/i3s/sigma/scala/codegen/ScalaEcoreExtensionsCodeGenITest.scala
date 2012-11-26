package fr.unice.i3s.sigma.scala.codegen

import scala.collection.JavaConverters._
import org.scalatest.FunSuite
import org.eclipse.emf.common.EMFPlugin
import org.eclipse.emf.common.util.BasicMonitor
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.io.File
import com.google.common.io.Files.copy
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.util.GenModelUtil
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter
import org.eclipse.emf.common.util.Diagnostic

@RunWith(classOf[JUnitRunner])
class ScalaEcoreExtensionsCodeGenTest extends FunSuite {

  def copyDir(from: File, to: File) {
    if (!to.exists()) to.mkdirs()

    for (f <- from.listFiles) yield {
      val dest = new File(to, f.getName())

      println(f + " -> " + dest)

      if (f.isDirectory) copyDir(f, dest)
      else copy(f, dest)
    }
  }

  test("Generate Model") ({

    assert(EMFPlugin.IS_ECLIPSE_RUNNING)

    val monitor = new BasicMonitor.Printing(System.out)
    val resourceSet = new ResourceSetImpl
    val projectName = "fr.unice.i3s.sigma.scala.tests.extensions"
    val workspace = ResourcesPlugin.getWorkspace
    val workspaceRoot = workspace.getRoot

    val sourceProject = new File(projectName)
    val targetProject = new File(workspaceRoot.getLocation.toFile, projectName)

    copyDir(sourceProject, targetProject)

    val projectDescriptorFile = new File(targetProject, ".project")
    val projectDescription = workspace.loadProjectDescription(
      new Path(projectDescriptorFile.getAbsolutePath()))

    val project = workspaceRoot.getProject(projectDescription.getName())
    project.create(projectDescription, null)
    project.open(null)

    assert(project != null)
    assert(project.getName == projectName)

    val genModelURI = URI.createPlatformResourceURI(s"/$projectName/model/Test.genmodel", true);
    val resource = resourceSet.getResource(genModelURI, true);
    val genModel = resource.getContents.get(0).asInstanceOf[GenModel]

    genModel.setCanGenerate(true)
    // ad junit so we can run the test later
    genModel.getModelPluginVariables().add("org.junit")
    genModel.reconcile()

    val generator = GenModelUtil.createGenerator(genModel);
    val result = generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, monitor);

    // TODO: create some unit test that will be launched in the new eclipse
    // and that will verify the new methods

    assert(result.getSeverity() == Diagnostic.OK)

  })

}