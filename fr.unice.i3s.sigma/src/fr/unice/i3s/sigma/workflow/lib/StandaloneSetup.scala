package fr.unice.i3s.sigma.workflow.lib

import scala.collection.JavaConversions._
import java.io.File
import java.util.jar.JarFile
import scala.xml.XML
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.plugin.EcorePlugin
import com.typesafe.scalalogging.log4j.Logging
import fr.unice.i3s.sigma.util.EMFUtils
import fr.unice.i3s.sigma.util.IOUtils.Continue
import fr.unice.i3s.sigma.util.IOUtils.Skip
import fr.unice.i3s.sigma.util.IOUtils.VisitFile
import fr.unice.i3s.sigma.util.IOUtils.pathSep
import fr.unice.i3s.sigma.util.IOUtils.walk
import fr.unice.i3s.sigma.util.IOUtils.PreVisitDir
import fr.unice.i3s.sigma.workflow.ConfigurationException
import fr.unice.i3s.sigma.workflow.WorkflowComponent

object StandaloneSetup {
  EMFUtils.IO.registerDefaultFactories

  // initialize packages
  EcorePackage.eINSTANCE.getEClass
  GenModelPackage.eINSTANCE.getGenClass

  private val skipDir = "\\.[^.]+".r
}

case class StandaloneSetup(
  val platformURI: String,
  val scanClassPath: Boolean = true,
  val logResourceURIMap: Boolean = false) extends WorkflowComponent with Logging {

  import StandaloneSetup._

  val bundleNameMapping = Map[String, String]()

  // call the companion's object static block
  StandaloneSetup

  def invoke {
    logger.info("Initializing Standalone Setup")

    initPlatformURI
    doScanClassPath
    doLogResourceUriMap
  }

  def initPlatformURI = {
    val f = new File(platformURI);

    if (!f.isDirectory())
      throw new ConfigurationException("The platformURI location must point to a directory");

    logger.info(s"Registering platform uri '${f.getCanonicalPath}'");

    scan(f);
  }

  protected def doScanClassPath {
    if (!scanClassPath) return

    val property = System.getProperty("java.class.path");
    if (property != null) {
      property.split(pathSep) foreach { entry ⇒
        val f = new File(entry).getCanonicalFile();
        scan(f)
      }
    }
  }

  protected def doLogResourceUriMap {
    if (!logResourceURIMap) return ;

    EcorePlugin.getPlatformResourceMap.toSeq
      .sortBy(_._1)
      .foreach { case (k, v) ⇒ logger.info(s"$k - $v") }
  }

  protected def scan(file: File) = {
    walk(file) {
      case PreVisitDir(f) if (skipDir findFirstIn f.getName).isDefined ⇒
        logger.trace("Skipping: " + f.getCanonicalPath)
        Skip
      case VisitFile(f) if f.getName == ".project" ⇒
        logger.trace("Found project: " + f.getCanonicalPath)
        registerProject(f); Skip
      case VisitFile(f) if f.getName.endsWith(".jar") ⇒
        logger.trace("Found bundle: " + f.getCanonicalPath)
        registerBundle(f); Continue
      case _ ⇒ Continue
    }
  }

  protected def registerBundle(file: File) {
    val jarFile = new JarFile(file);
    val manifest = jarFile.getManifest();

    if (manifest == null) return ;

    Option(manifest.getMainAttributes().getValue("Bundle-SymbolicName"))
      .map { _ takeWhile (_ != ';') } match {
        case Some(name) if EcorePlugin.getPlatformResourceMap().containsKey(name) ⇒
        case Some(name) ⇒
          val path = "archive:" + file.toURI() + "!/";
          val uri = URI.createURI(path);

          EcorePlugin.getPlatformResourceMap().put(name, uri);

          logger.debug(s"Registering bundle $name -> $uri")
        case None ⇒
      }
  }

  protected def registerProject(file: File) {
    val doc = XML.loadFile(file)
    val name = (doc \ "name").text
    val uri = URI.createFileURI(file.getParentFile().getCanonicalPath() + File.separator)

    EcorePlugin.getPlatformResourceMap().put(name, uri);
    bundleNameMapping.get(name) match {
      case Some(mapping) ⇒ EcorePlugin.getPlatformResourceMap().put(mapping, uri);
      case None ⇒
    }

    logger.debug(s"Registering project $name -> $uri");
  }
}