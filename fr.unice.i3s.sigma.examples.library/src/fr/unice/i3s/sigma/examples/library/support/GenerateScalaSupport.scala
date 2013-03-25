package fr.unice.i3s.sigma.examples.library.support

import fr.unice.i3s.sigma.workflow.lib.StandaloneSetup
import fr.unice.i3s.sigma.workflow.WorkflowApp
import fr.unice.i3s.sigma.workflow.lib.CleanDirectory
import fr.unice.i3s.sigma.workflow.lib.GenerateEcore
import fr.unice.i3s.sigma.workflow.lib.GenerateEMFScalaSupport

object GenerateScalaSupport extends WorkflowApp {

  val projectName = "fr.unice.i3s.sigma.examples.library"
  val runtimeProject = s"../$projectName"
  val srcGen = s"$runtimeProject/src-gen"

  val targetPackage = "fr.unice.i3s.sigma.examples.library.support"
  val ecoreModel = s"platform:/resource/$projectName/model/Library.genmodel"

  StandaloneSetup(platformPath = s"$runtimeProject/..", logResourceURIMap = true)

  CleanDirectory(path = srcGen)

  GenerateEcore(genModelURI = ecoreModel)

  GenerateEMFScalaSupport(
    baseDir = srcGen,
    genModelURI = ecoreModel,
    pkgName = targetPackage)

}