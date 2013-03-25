package fr.unice.i3s.sigma.examples.library.support

import fr.unice.i3s.sigma.workflow.lib.StandaloneSetup
import fr.unice.i3s.sigma.workflow.lib.DirectoryCleaner
import fr.unice.i3s.sigma.workflow.lib.EMFScalaSupportGenerator
import fr.unice.i3s.sigma.workflow.lib.EcoreGenerator
import fr.unice.i3s.sigma.workflow.WorkflowApp

object GenerateScalaSupport extends WorkflowApp {

  val projectName = "fr.unice.i3s.sigma.examples.library"
  val runtimeProject = s"../$projectName"
  val srcGen = s"$runtimeProject/src-gen"

  val targetPackage = "fr.unice.i3s.sigma.examples.library.support"
  val ecoreModel = s"platform:/resource/$projectName/model/Library.genmodel"

  StandaloneSetup(platformPath = s"$runtimeProject/..", logResourceURIMap = true)

  DirectoryCleaner(path = srcGen)

  EcoreGenerator(genModelURI = ecoreModel)

  EMFScalaSupportGenerator(
    baseDir = srcGen,
    genModelURI = ecoreModel,
    pkgName = targetPackage)

}