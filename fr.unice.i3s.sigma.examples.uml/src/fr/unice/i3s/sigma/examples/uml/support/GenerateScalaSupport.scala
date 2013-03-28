package fr.unice.i3s.sigma.examples.uml.support

import scala.collection.JavaConversions._
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.URIConverter
import fr.unice.i3s.sigma.workflow.lib.StandaloneSetup
import fr.unice.i3s.sigma.workflow.WorkflowApp
import fr.unice.i3s.sigma.workflow.lib.LoadModel
import org.eclipse.emf.ecore.EObject
import fr.unice.i3s.sigma.workflow.lib.ValidateModel
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.ecore.plugin.EcorePlugin
import fr.unice.i3s.sigma.workflow.lib.GenerateEMFScalaSupport
import fr.unice.i3s.sigma.workflow.lib.CleanDirectory

object GenerateScalaSupport extends WorkflowApp {

  val projectName = "fr.unice.i3s.sigma.examples.uml"
  val runtimeProject = s"../$projectName"
  val srcGen = s"$runtimeProject/src-gen"

  val targetPackage = "fr.unice.i3s.sigma.examples.uml.support"
  val ecoreModel = s"platform:/resource/org.eclipse.uml2.uml/model/UML.genmodel"

  !new StandaloneSetup {
    platformPath = s"$runtimeProject/.."
    logResourceURIMap = true
    logRegisteredPackages = true

    registerPackage(org.eclipse.emf.ecore.EcorePackage.eINSTANCE)
    registerPackage(org.eclipse.uml2.types.TypesPackage.eINSTANCE)
    registerPackage(org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage.eINSTANCE)
    registerPackage(org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage.eINSTANCE)

    val maps = List(
      "platform:/plugin/org.eclipse.emf.ecore/model/Ecore.genmodel",
      "platform:/plugin/org.eclipse.emf.codegen.ecore/model/GenModel.genmodel",
      "platform:/plugin/org.eclipse.uml2.codegen.ecore/model/GenModel.genmodel",
      "platform:/plugin/org.eclipse.uml2.uml/model/UML.genmodel",
      "platform:/plugin/org.eclipse.emf.codegen.ecore/model/GenModel.ecore",
      "platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore",
      "platform:/plugin/org.eclipse.uml2.codegen.ecore/model/GenModel.ecore",
      "platform:/plugin/org.eclipse.uml2.uml/model/UML.ecore",
      "platform:/plugin/org.eclipse.uml2.types/model/Types.ecore",
      "platform:/plugin/org.eclipse.uml2.types/model/Types.genmodel")

    maps foreach { uri ⇒
      addMapping(uri, uri.replace("plugin", "resource"))
    }
  }

  //  val model = LoadModel(ecoreModel).model[GenModel]
  //  ValidateModel(model)

  !new CleanDirectory {
    path = srcGen
  }

  !new GenerateEMFScalaSupport {
    baseDir = srcGen
    genModelURI = ecoreModel
    pkgName = targetPackage

    // FIXME: there is a problem with EList[scala.boolean] and EList[java.lang.Boolean] 
    skipType("DurationObservation")
    skipType("DurationConstraint")

    mapping("Feature.isStatic", "static")
  }

}