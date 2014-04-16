package fr.unice.i3s.sigma.examples.models14.support

import fr.unice.i3s.sigma.workflow.lib.StandaloneSetup
import fr.unice.i3s.sigma.workflow.WorkflowApp
import fr.unice.i3s.sigma.workflow.lib.CleanDirectory
import fr.unice.i3s.sigma.workflow.lib.GenerateEcore
import fr.unice.i3s.sigma.workflow.lib.GenerateEMFScalaSupport

object GenerateSigmaSupport extends WorkflowApp {

  val projectName = "fr.unice.i3s.sigma.examples.models14"
  val runtimeProject = s"../$projectName"
  val srcGen = s"$runtimeProject/src-gen"

  val packageSuffix = ".support"
  val ecoreModels = List(s"platform:/resource/$projectName/model/EERmodel.genmodel",
    s"platform:/resource/$projectName/model/Relational.genmodel")

  !new StandaloneSetup {
    platformPath = s"$runtimeProject/.."
    logResourceURIMap = true
  }

  !new CleanDirectory {
    path = srcGen
  }

  for (model <- ecoreModels) {
    !new GenerateEcore {
      genModelURI = model
      srcPath(s"platform:/resource/${projectName}/src")
    }

    !new GenerateEMFScalaSupport {
      baseDir = srcGen
      genModelURI = model
      useOption = true
      useSeparateNamespace = true
      packageNameMapping = { _ + packageSuffix }
    }
  }

}