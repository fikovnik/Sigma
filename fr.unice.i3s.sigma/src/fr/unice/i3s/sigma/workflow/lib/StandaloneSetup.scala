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
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.EPackage

object StandaloneSetup {
  EMFUtils.IO.registerDefaultFactories

  // initialize packages
  EcorePackage.eINSTANCE.getEClass
  GenModelPackage.eINSTANCE.getGenClass

  private val skipDir = "^\\.[^.]+".r
}

case class StandaloneSetup(
  val platformURI: String,
  val scanClassPath: Boolean = true,
  val logResourceURIMap: Boolean = false,
  val registerGenModelFiles: Seq[String] = Seq.empty) extends WorkflowComponent with Logging {

  import StandaloneSetup._

  val bundleNameMapping = Map[String, String]()

  // call the companion's object static block
  StandaloneSetup

  def invoke {
    logger.info("Initializing Standalone Setup")

    initPlatformURI
    doScanClassPath
    doLogResourceUriMap
    doRegisterGenModelFiles
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

  val resourceSet = new ResourceSetImpl

  protected def doRegisterGenModelFiles {
    registerGenModelFiles foreach registerGenModelFile
  }

  protected def registerGenModelFile(genModelURI: String) {
    val res = resourceSet.getResource(URI.createURI(genModelURI), true)
    if (res == null)
      throw new ConfigurationException("Couldn't find resource under  " + genModelURI)

    res.getContents.collect { case e: GenModel ⇒ e } foreach (registerGenModel)
  }

  protected def registerGenModel(genModel: GenModel) {
    //    EPackage.Registry.INSTANCE.
    val registry = EcorePlugin.getEPackageNsURIToGenModelLocationMap

    println((genModel.getGenPackages ++ genModel.getUsedGenPackages) mkString ("\n"))

    for (pkg ← (genModel.getGenPackages ++ genModel.getUsedGenPackages)) {
      if (pkg.eIsProxy) {
        logger.debug("Unresolved proxy for GenPackage " + EcoreUtil.getURI(pkg))
      } else {
        val nsURI = pkg.getEcorePackage.getNsURI
        EPackage.Registry.INSTANCE.put(nsURI, pkg.getEcorePackage)
        logger.debug(s"!!!Registered $nsURI to ${pkg.getEcorePackage}")
        if (nsURI != null) {
          val newUri = pkg.eResource.getURI;
          if (registry.containsKey(nsURI)) {
            val oldURI = registry.get(nsURI);
            if (!oldURI.equals(newUri))
              logger.warn(s"There is already a GenModel registered for NamespaceURI '$nsURI'. It will be overwritten from '$oldURI' to '$newUri'");
          }
          registry.put(nsURI, newUri);
          logger.info("Registered GenModel '" + nsURI + "' from '" + newUri + "'");
        }
      }
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