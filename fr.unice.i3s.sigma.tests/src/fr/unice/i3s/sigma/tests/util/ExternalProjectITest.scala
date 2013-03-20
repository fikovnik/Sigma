package fr.unice.i3s.sigma.tests.util

import scala.collection.JavaConversions._
import java.io.File
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
import org.eclipse.jdt.core.IJavaModelMarker
import org.eclipse.jdt.core.JavaCore
import org.junit.runner.JUnitCore
import org.osgi.framework.Bundle
import org.osgi.framework.Version
import com.google.common.io.Files.copy
import com.google.common.io.Resources
import fr.unice.i3s.sigma.util.EMFUtils
import org.junit.runner.Result
import scala.Array.canBuildFrom
import fr.unice.i3s.sigma.Activator
import fr.unice.i3s.sigma.util.IOUtils

trait ExternalProjectITest {

  assert(EMFPlugin.IS_ECLIPSE_RUNNING)

  val workspace = ResourcesPlugin.getWorkspace
  val workspaceRoot = workspace.getRoot
  val bundleContext = Activator.context.get

  //  def copyDir(from: File, to: File) {
  //    if (!to.exists()) to.mkdirs()
  //
  //    for (f ← from.listFiles) yield {
  //      val dest = new File(to, f.getName())
  //
  //      if (f.isDirectory) copyDir(f, dest)
  //      else copy(f, dest)
  //    }
  //  }

  def getBundleByName(symbolicName: String, version: Version = null): Option[Bundle] = {
    val bundles = bundleContext.getBundles.filter(_.getSymbolicName == symbolicName)

    Option(version).map(v ⇒ bundles.filter(_.getVersion.compareTo(v) >= 0).headOption).getOrElse(bundles.headOption)
  }

  def extractBundleEntry(bundle: Bundle, path: String): File = {
    val target = bundle.getDataFile(path)
    Option(target.getParentFile).filter(!_.exists()).map(_.mkdirs())

    copy(Resources.newInputStreamSupplier(bundle.getEntry(path)), target)
    target
  }

  def importProject(projectName: String) = {
    // prerequisites 
    val monitor = new BasicMonitor.Printing(System.out)

    val sourceProject = new File(projectName)
    val targetProject = new File(workspaceRoot.getLocation.toFile, projectName)

    // import a copy of a project
    println("Importing project")

    IOUtils.cpdir(sourceProject, targetProject, { (f, t) ⇒ println(s"Copying ${f.getCanonicalPath} to ${t.getCanonicalPath}") })

    val projectDescriptorFile = new File(targetProject, ".project")
    val projectDescription = workspace.loadProjectDescription(
      new Path(projectDescriptorFile.getAbsolutePath()))

    val project = workspaceRoot.getProject(projectDescription.getName())
    project.create(projectDescription, null)
    project.open(null)

    val projectPath = project.getFullPath

    assert(project != null)
    assert(project.getName == projectName)

    projectPath
  }

  def generateModel(platformURI: String) = {
    // generate model
    println("Generating model")

    val genModelURI = URI.createPlatformResourceURI(platformURI, true);
    val genModel = EMFUtils.IO.load[GenModel](genModelURI)

    genModel.setCanGenerate(true)
    genModel.reconcile()

    val monitor = new BasicMonitor.Printing(System.out)
    val generator = GenModelUtil.createGenerator(genModel);
    val result = generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, monitor);

    //    val projectBin = new File(targetProject, "bin")
    //    val metaInfDir = new File(projectBin, "META-INF")
    //
    //    // FIXME: here we copy the original manifest because codegen will rewrite it from whatever reason
    //    copyDir(new File(sourceProject, "META-INF"), metaInfDir)

    assert(result.getSeverity() == Diagnostic.OK)
  }

  def buildProject(projectName: String) = {
    val monitor = new BasicMonitor.Printing(System.out)
    val project = workspaceRoot.getProject(projectName)
    val projectPath = project.getFullPath

    // build project
    println(s"Building project $projectName")

    // originally this was supposed to be extremely simple
    // running it as a plug-in test will actually be
    // but from tycho, it was nightmare. Ideally the ony thing that should be 
    // required is to open the project. This will trigger the build and voila.

    // TOOD: REMOVE
    // this is an alternative to resolve the the PDE project classpath - create a new target platform
    //    val targetPlatform = ApiPlugin.getDefault().acquireService(classOf[ITargetPlatformService].getName()).asInstanceOf[ITargetPlatformService]
    // http://stackoverflow.com/questions/6998558/reload-target-platform-in-eclipse-dynamically-from-plugin
    //    val targetPlatform = PDECore.getDefault().acquireService(classOf[ITargetPlatformService].getName).asInstanceOf[ITargetPlatformService]
    //    val target = targetPlatform..getTargetDefinition();
    //    target.resolve(null);
    //    LoadTargetDefinitionJob.load(target);

    // TODO: REMOVE once the PDE bugs are resolved
    // resolve manually the dependencies
    // Note: org.eclipse.pde.core.requiredPlugins classpath variable cannot be used due to bugs:
    // - https://bugs.eclipse.org/bugs/show_bug.cgi?id=343156
    // - https://bugs.eclipse.org/bugs/show_bug.cgi?id=343152
    // Possible solution mentioned in: http://comments.gmane.org/gmane.comp.ide.eclipse.tycho.user/421
    // ONLY for 3.8
    val javaProject = JavaCore.create(project);

    val requiredPluginNames = List("org.eclipse.core.runtime", "org.eclipse.emf.common", "org.eclipse.emf.ecore")
    val requiredPluginLocations = requiredPluginNames.map(p ⇒ FileLocator.getBundleFile(getBundleByName(p).get).getAbsolutePath)
    val requiredplugin = requiredPluginLocations.map(p ⇒ JavaCore.newLibraryEntry(new Path(p), null, null, false))

    val scalaLibLocation = extractBundleEntry(getBundleByName("org.scala-ide.scala.library").get, "lib/scala-library.jar")
    val scalaLib = JavaCore.newLibraryEntry(new Path(scalaLibLocation.getAbsolutePath), null, null, false)

    val junitLocation = extractBundleEntry(getBundleByName("org.junit", new Version("4.8.0")).get, "junit.jar")
    val junit = JavaCore.newLibraryEntry(new Path(junitLocation.getAbsolutePath), null, null, false)

    val jre = Util.getJavaClassLibs().map(p ⇒ JavaCore.newLibraryEntry(new Path(p), null, null, false))

    val src = JavaCore.newSourceEntry(new Path(projectPath + "/src"))
    val src_gen = JavaCore.newSourceEntry(new Path(projectPath + "/src-gen"))

    javaProject.setRawClasspath((src_gen :: src :: scalaLib :: junit :: requiredplugin ++ jre).toArray, null);

    // TODO: this should happen somehow automatically
    // maybe if the launching.macosx is present, but I could not for tycho to resolve it
    // maybe here is some help https://github.com/sonatype/m2eclipse-tycho/blob/master/pom.xml
    //
    // Question asked: http://www.eclipse.org/forums/index.php/m/987613/#msg_987613
    //    val jre = JavaCore.newContainerEntry(new Path("org.eclipse.jdt.launching.JRE_CONTAINER"))
    //    JavaCore.setClasspathContainer(new Path("org.eclipse.jdt.launching.JRE_CONTAINER"), Array(javaProject), Array(
    //      new IClasspathContainer {
    //        override def getClasspathEntries = Util.getJavaClassLibs().map(p => JavaCore.newLibraryEntry(new Path(p), null, null, false))
    //        override def getDescription = "Basic JDK library container"
    //        override def getKind = IClasspathContainer.K_SYSTEM
    //        override def getPath = new Path("org.eclipse.jdt.launching.JRE_CONTAINER")
    //      }), null)

    println("Resolved classpath: ")
    javaProject.getResolvedClasspath(false) foreach (p ⇒ println(p.getPath()))

    project.findMarkers(IJavaModelMarker.BUILDPATH_PROBLEM_MARKER, false, IResource.DEPTH_ZERO) match {
      case Array() ⇒ // nothing
      case markers @ Array(_*) ⇒ {
        println("Build path problems: ")

        markers.foreach { m ⇒
          println("- " + m.getAttributes.map { case (k, v) ⇒ k + ": " + v }.mkString(", "))
        }
      }
    }

    project.build(IncrementalProjectBuilder.CLEAN_BUILD, null)
    project.build(IncrementalProjectBuilder.FULL_BUILD, null)

    project.findMarkers(null, false, IResource.DEPTH_INFINITE) match {
      case Array() ⇒ // nothing
      case markers @ Array(_*) ⇒ {
        println("Build problems: ")

        markers.foreach { m ⇒
          println("- " + m.getType() + " " + m.getAttributes.map { case (k, v) ⇒ k + ": " + v }.mkString(", "))
        }
      }
    }

    val projectBin = new File(projectPath.toOSString(), "bin")
    val metaInfDir = new File(projectBin, "META-INF")

    // FIXME: here we copy the original manifest because codegen will rewrite it from whatever reason
    IOUtils.cpdir(new File(projectPath.toOSString, "META-INF"), metaInfDir)

    project
  }

  def installProject(projectName: String) = {
    val targetProject = new File(workspaceRoot.getLocation.toFile, projectName)
    val projectBin = new File(targetProject, "bin")

    val bundle = bundleContext.installBundle("file://" + projectBin.getAbsolutePath())
    bundle
  }

  def runJUnitTest(projectName: String, unitTestName: String) = {
    val ctx = Activator.context.get
    val bundle = ctx.getBundle(projectName)
    //  platform bundles
    //    ctx.getBundles.foreach { b =>
    //      println(s"${b.getSymbolicName()}  ${b.getVersion()}")
    //    }
    val testClazz = bundle.loadClass(unitTestName)
    // try to invoke
    //    val method = testClazz.getMethods.find(_.getName == "testGeneratedMethods").get
    //    val csr = clazz.getConstructors()(0)
    //    method.invoke(csr.newInstance())

    println("Invoking test: " + testClazz.getName())

    // run the tests
    JUnitCore.runClasses(testClazz)

    //    assert(junitResult.wasSuccessful())
  }

  def prettyPrint(junitResult: Result) = {
    println("- Tests run: %d, Ignored: %d, Failures: %d failures) in %d msec" format (
      junitResult.getRunCount(),
      junitResult.getIgnoreCount(),
      junitResult.getFailureCount(),
      junitResult.getRunTime()))

    junitResult.getFailures foreach println
  }

}

