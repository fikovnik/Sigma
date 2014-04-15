package fr.unice.i3s.sigma.internal.support

import fr.unice.i3s.sigma.workflow.lib.CleanDirectory
import fr.unice.i3s.sigma.workflow.lib.StandaloneSetup
import fr.unice.i3s.sigma.workflow.lib.GenerateEMFScalaSupport
import fr.unice.i3s.sigma.workflow.WorkflowApp

object GenerateEcoreModelSupport extends WorkflowApp {

  val projectName = "fr.unice.i3s.sigma"
  val runtimeProject = s"../$projectName"
  val srcGen = s"$runtimeProject/src-gen"

  val targetPackage = "fr.unice.i3s.sigma.support.ecore"
  val ecoreModel = "platform:/resource/org.eclipse.emf.ecore/model/Ecore.genmodel"

  !new StandaloneSetup {
    platformPath = s"$runtimeProject/.."
    logResourceURIMap = true
  }

  !new CleanDirectory {
    path = srcGen
  }

  !new GenerateEMFScalaSupport {
    baseDir = srcGen
    genModelURI = ecoreModel
    packageName = targetPackage
    
    // Ecore model is very relaxed when it comes to multiplicity and thus it
    // does not make sense to use this feature
    useOption = false
    
    // TODO: document why!
    skipType("EStringToStringMapEntry")
  }
}