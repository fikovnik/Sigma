package fr.unice.i3s.sigma.examples.simpleoo.support

import fr.unice.i3s.sigma.workflow.lib.StandaloneSetup
import fr.unice.i3s.sigma.workflow.WorkflowApp
import fr.unice.i3s.sigma.workflow.lib.CleanDirectory
import fr.unice.i3s.sigma.workflow.lib.GenerateEcore
import fr.unice.i3s.sigma.workflow.lib.GenerateEMFScalaSupport

object GenerateSimpleOOModelSupport extends WorkflowApp {

  val projectName = "fr.unice.i3s.sigma.examples.simpleoo"
  val runtimeProject = s"../$projectName"
  val srcGen = s"$runtimeProject/src-gen"

  val packageSuffix = ".support"
  val ecoreModel = s"platform:/resource/$projectName/model/SimpleOO.genmodel"

  !new StandaloneSetup {
    platformPath = s"$runtimeProject/.."
    logResourceURIMap = true
  }

  !new CleanDirectory {
    path = srcGen
  }

  !new GenerateEcore {
    genModelURI = ecoreModel
    srcPath(s"platform:/resource/${projectName}/src")
  }

  !new GenerateEMFScalaSupport {
    baseDir = srcGen
    genModelURI = ecoreModel
    useOption = true
    useSeparateNamespace = true
    packageNameMapping = { _ + packageSuffix }
  }

}