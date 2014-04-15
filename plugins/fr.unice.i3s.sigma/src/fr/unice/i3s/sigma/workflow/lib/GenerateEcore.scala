package fr.unice.i3s.sigma.workflow.lib

import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import fr.unice.i3s.sigma.util.EMFUtils
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.generator.Generator
import org.eclipse.emf.codegen.merge.java.JControlModel
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter._
import org.eclipse.emf.common.util.BasicMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenClassGeneratorAdapter
import org.eclipse.emf.codegen.ecore.genmodel.GenBase
import org.eclipse.emf.codegen.util.ImportManager
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenEnumGeneratorAdapter
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapter
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenPackageGeneratorAdapter
import fr.unice.i3s.sigma.workflow.WorkflowTask
import com.typesafe.scalalogging.log4j.Logging
import fr.unice.i3s.sigma.support.EMFScalaSupport._
import com.typesafe.scalalogging.log4j.Logger
import fr.unice.i3s.sigma.workflow.WorkflowRunner
import scala.collection.mutable.Buffer
import fr.unice.i3s.sigma.workflow.WorkflowTask
import scala.beans.BeanProperty

private class LoggingMonitor(logger: Logger) extends BasicMonitor {
  override def beginTask(name: String, totalWork: Int): Unit = logger.debug(name)
  override def subTask(name: String): Unit = logger.debug(name)
}

object GenerateEcore {

  EMFUtils.IO.registerDefaultFactories

  // initialize packages
  EcorePackage.eINSTANCE.getEClass
  GenModelPackage.eINSTANCE.getGenClass

}

class GenerateEcore extends WorkflowTask with Logging {

  // execute the companion's object static block
  GenerateEcore

  @BeanProperty
  protected var genModelURI: URI = _
  protected def genModelURI_=(v: String): Unit = genModelURI = URI.createURI(v)
  protected def setGenModelURI(v: String) = genModelURI = v

  @BeanProperty
  protected var generateEdit: Boolean = false

  @BeanProperty
  protected var generateEditor: Boolean = false

  @BeanProperty
  protected var instanceDelegateNameMapper: (String, String) ⇒ Option[String] = defaultInstanceDelegateNameMapper

  private val srcPaths: Buffer[String] = Buffer[String]()
  protected def srcPath(path: String) = srcPaths += path

  protected def defaultInstanceDelegateNameMapper(base: String, from: String): Option[String] = {
    val uri = URI.createURI(base + "/" + from.replace('.', '/') + "Delegate.scala");
    if (URIConverter.INSTANCE.exists(uri, null)) Some(from + "Delegate")
    else None
  }

  protected def instanceDelegateMapper(from: String): Option[String] = {
    require(from != null)

    if (from.startsWith("org.eclipse.emf.ecore")) None
    else {
      srcPaths collectFirst {
        case p if instanceDelegateNameMapper(p, from).isDefined ⇒
          instanceDelegateNameMapper(p, from).get
      }
    }
  }

  // TODO: validate the model file
  
  def doExecute {
    generateEcore
  }

  protected def generateEcore {
    val genModel = EMFUtils.IO.load[GenModel](genModelURI)
    genModel.setCanGenerate(true);
    genModel.reconcile();
    //	createGenModelSetup().registerGenModel(genModel);

    val generator = new Generator {
      override def getJControlModel = {
        new JControlModel {
          // prevent merging
          override def canMerge = false
        }
      }
    }

    // prevent overriding bundle manifest
    genModel.setBundleManifest(false);

    generator.getAdapterFactoryDescriptorRegistry().addDescriptor(GenModelPackage.eNS_URI,
      new GeneratorAdapterDescriptor);
    generator.setInput(genModel);

    logger.info("Generating Ecore model code for: " + genModelURI)
    val diagnostic = generator.generate(genModel, MODEL_PROJECT_TYPE, new LoggingMonitor(logger));

    if (!diagnostic.isOK) logger.error(diagnostic.prettyPrint);

    if (generateEdit) {
      logger.info("Generating Ecore edit code for: " + genModelURI)
      val editDiag = generator.generate(genModel, EDIT_PROJECT_TYPE, new LoggingMonitor(logger));
      if (!editDiag.isOK) logger.error(diagnostic.prettyPrint);
    }

    if (generateEditor) {
      logger.info("Generating Ecore editor code for: " + genModelURI)
      val editorDiag = generator.generate(genModel, EDITOR_PROJECT_TYPE, new LoggingMonitor(logger));
      if (!editorDiag.isOK) logger.error(diagnostic.prettyPrint);
    }

  }

  class GeneratorAdapterDescriptor extends GeneratorAdapterFactory.Descriptor {
    class AdapterFactory extends GenModelGeneratorAdapterFactory {

      override def createGenClassAdapter = {
        new GenClassGeneratorAdapter(this) {
          override def createImportManager(packageName: String, className: String) = {
            importManager = new ImportManagerHack(packageName, instanceDelegateMapper _)
            importManager.addMasterImport(packageName, className)
            if (generatingObject != null)
              generatingObject.asInstanceOf[GenBase].getGenModel().setImportManager(importManager);
          }
        }
      }

      override def createGenEnumAdapter = {
        new GenEnumGeneratorAdapter(this) {
          override def createImportManager(packageName: String, className: String) = {
            importManager = new ImportManagerHack(packageName, instanceDelegateMapper _)
            importManager.addMasterImport(packageName, className)
            if (generatingObject != null)
              generatingObject.asInstanceOf[GenBase].getGenModel().setImportManager(importManager);
          }
        }
      }

      override def createGenModelAdapter = {
        new GenModelGeneratorAdapter(this) {
          override def createImportManager(packageName: String, className: String) = {
            importManager = new ImportManagerHack(packageName, instanceDelegateMapper _)
            importManager.addMasterImport(packageName, className)
            if (generatingObject != null)
              generatingObject.asInstanceOf[GenBase].getGenModel().setImportManager(importManager);
          }
        }
      }

      override def createGenPackageAdapter = {
        new GenPackageGeneratorAdapter(this) {
          override def createImportManager(packageName: String, className: String) = {
            importManager = new ImportManagerHack(packageName, instanceDelegateMapper _)
            importManager.addMasterImport(packageName, className)
            if (generatingObject != null)
              generatingObject.asInstanceOf[GenBase].getGenModel().setImportManager(importManager);
          }
        }
      }
    }

    override def createAdapterFactory = new AdapterFactory
  }

  class ImportManagerHack(compilationUnitPackage: String, val mapper: String ⇒ Option[String]) extends ImportManager(compilationUnitPackage) {
    override def getImportedName(qualifiedName: String, autoImport: Boolean) = {
      mapper(qualifiedName) match {
        case Some(mapped) ⇒ {
          logger.debug(s"mapping $qualifiedName to $mapped")
          super.getImportedName(mapped, autoImport)
        }
        case None ⇒ super.getImportedName(qualifiedName, autoImport)
      }
    }
  }

}