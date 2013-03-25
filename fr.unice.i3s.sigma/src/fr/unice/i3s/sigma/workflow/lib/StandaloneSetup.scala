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
import fr.unice.i3s.sigma.workflow.WorkflowTask
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.EPackage
import fr.unice.i3s.sigma.workflow.WorkflowTaskFactory
import fr.unice.i3s.sigma.workflow.WorkflowRunner
import scala.collection.mutable.Buffer
import scala.util.Failure
import scala.util.Success
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.emf.ecore.resource.Resource

object StandaloneSetup extends WorkflowTaskFactory {
  type Task = StandaloneSetup

  EMFUtils.IO.registerDefaultFactories

  // initialize packages
  EcorePackage.eINSTANCE.getEClass
  GenModelPackage.eINSTANCE.getGenClass

  private val skipDir = "^\\.[^.]+".r

  def apply(
    platformPath: String,
    scanClassPath: Boolean = true,
    logResourceURIMap: Boolean = false,
    logRegisteredPackages: Boolean = false,
    config: Config = { _ ⇒ })(implicit runner: WorkflowRunner): StandaloneSetup = {

    val task = new StandaloneSetup(platformPath, scanClassPath, logResourceURIMap, logRegisteredPackages)
    config(task)
    execute(task)
    task
  }

}

class StandaloneSetup(
  val platformPath: String,
  val scanClassPath: Boolean = true,
  val logResourceURIMap: Boolean = false,
  val logRegisteredPackages: Boolean = false) extends WorkflowTask with Logging {

  import StandaloneSetup._

  protected val platformFile = new File(platformPath)

  val registerGenModelFiles: Buffer[String] = Buffer.empty
  val registerPackages: Buffer[EPackage] = Buffer.empty
  val registerExtensions: collection.mutable.Map[String, Resource.Factory] = collection.mutable.Map.empty
  val URIMap: collection.mutable.Map[String, String] = collection.mutable.Map.empty
  val bundleNameMapping = Map[String, String]()

  // call the companion's object static block
  StandaloneSetup

  override def validate = {
    if (!platformFile.isDirectory) {
      Failure(new ConfigurationException("The platformURI location must point to a directory"))
    } else {
      Success()
    }
  }

  def execute {
    logger.info("Initializing Standalone Setup")

    initPlatformURI
    doScanClassPath
    doLogResourceUriMap
    doLogRegisteredPackages
    // TODO: there should be extra map of URI->URI checked in the validate method
    URIMap foreach registerURIMapping
    registerExtensions foreach registerExtension
    registerPackages foreach registerPackage
    registerGenModelFiles foreach registerGenModelFile
  }

  def initPlatformURI = {
    logger.info(s"Registering platform uri '${platformFile.getCanonicalPath}'");

    scan(platformFile);
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

    logger.info("Resource URI Map:")
    EcorePlugin.getPlatformResourceMap.toSeq
      .sortBy(_._1)
      .foreach { case (k, v) ⇒ logger.info(s"$k - $v") }
  }

  protected def doLogRegisteredPackages {
    if (!logRegisteredPackages) return

    logger.info("Registered Epackages:")
    EPackage.Registry.INSTANCE.toSeq
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

  protected def registerExtension(mapping: (String, Resource.Factory)) {
    val (ext, factory) = mapping
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap += (ext -> factory)
  }

  protected def registerURIMapping(mapping: (String, String)) {
    val (from, to) = mapping
    URIConverter.URI_MAP.put(URI.createURI(from), URI.createURI(to));
  }

  protected def registerPackage(pkg: EPackage) {
    pkg.getEFactoryInstance
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