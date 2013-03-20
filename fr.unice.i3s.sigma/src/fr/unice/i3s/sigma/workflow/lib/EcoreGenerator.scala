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
import fr.unice.i3s.sigma.workflow.WorkflowComponent
import com.typesafe.scalalogging.log4j.Logging
import fr.unice.i3s.sigma.support.EMFScalaSupport._
import com.typesafe.scalalogging.log4j.Logger

private class LoggingMonitor(logger: Logger) extends BasicMonitor {
  override def beginTask(name: String, totalWork: Int): Unit = logger.debug(name)
  override def subTask(name: String): Unit = logger.debug(name)
}

case class EcoreGenerator(
  val generateEdit: Boolean = false,
  val generateEditor: Boolean = false,
  val generateDelegates: Boolean = false,
  val srcPaths: List[String] = Nil,
  val genModelURI: String) extends WorkflowComponent with Logging {

  // initialize packages
  EcorePackage.eINSTANCE.getEFactoryInstance()
  GenModelPackage.eINSTANCE.getEFactoryInstance()

  def delegateClassNameMapper(from: String): Option[String] = {
    require(from != null)

    if (from.startsWith("org.eclipse.emf.ecore")) None
    else {
      srcPaths collectFirst {
        case p if {
          val createURI = URI.createURI(p + "/" + from.replace('.', '/') + "Delegate.scala");
          URIConverter.INSTANCE.exists(createURI, null)
        } ⇒ from + "Delegate"
      }
    }
  }

  def invoke = {
    generateEcore
  }

  protected def generateEcore {
    val genModel = EMFUtils.IO.load[GenModel](URI.createURI(genModelURI))
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
        if (genClassGeneratorAdapter == null) {
          genClassGeneratorAdapter = new GenClassGeneratorAdapter(this) {
            override def createImportManager(packageName: String, className: String) = {
              importManager = new ImportManagerHack(packageName, delegateClassNameMapper _)
              importManager.addMasterImport(packageName, className)
              if (generatingObject != null)
                generatingObject.asInstanceOf[GenBase].getGenModel().setImportManager(importManager);
            }
          }
        }
        genClassGeneratorAdapter
      }

      override def createGenEnumAdapter = {
        if (genEnumGeneratorAdapter == null) {
          genEnumGeneratorAdapter = new GenEnumGeneratorAdapter(this) {
            override def createImportManager(packageName: String, className: String) = {
              importManager = new ImportManagerHack(packageName, delegateClassNameMapper _)
              importManager.addMasterImport(packageName, className)
              if (generatingObject != null)
                generatingObject.asInstanceOf[GenBase].getGenModel().setImportManager(importManager);
            }
          }
        }
        genEnumGeneratorAdapter
      }

      override def createGenModelAdapter = {
        if (genModelGeneratorAdapter == null) {
          genModelGeneratorAdapter = new GenModelGeneratorAdapter(this) {
            override def createImportManager(packageName: String, className: String) = {
              importManager = new ImportManagerHack(packageName, delegateClassNameMapper _)
              importManager.addMasterImport(packageName, className)
              if (generatingObject != null)
                generatingObject.asInstanceOf[GenBase].getGenModel().setImportManager(importManager);
            }
          }
        }
        genModelGeneratorAdapter

      }

      override def createGenPackageAdapter = {
        if (genPackageGeneratorAdapter == null) {
          genPackageGeneratorAdapter = new GenPackageGeneratorAdapter(this) {
            override def createImportManager(packageName: String, className: String) = {
              importManager = new ImportManagerHack(packageName, delegateClassNameMapper _)
              importManager.addMasterImport(packageName, className)
              if (generatingObject != null)
                generatingObject.asInstanceOf[GenBase].getGenModel().setImportManager(importManager);
            }
          }
        }
        genPackageGeneratorAdapter

      }
    }

    override def createAdapterFactory = new AdapterFactory
  }

  class ImportManagerHack(compilationUnitPackage: String, val mapper: String ⇒ Option[String]) extends ImportManager(compilationUnitPackage) {
    override def getImportedName(qualifiedName: String, autoImport: Boolean) =
      mapper(qualifiedName) match {
        case Some(mapped) ⇒ {
          // TODO: log
          super.getImportedName(mapped, autoImport)
        }
        case None ⇒ super.getImportedName(qualifiedName, autoImport)
      }
  }

}