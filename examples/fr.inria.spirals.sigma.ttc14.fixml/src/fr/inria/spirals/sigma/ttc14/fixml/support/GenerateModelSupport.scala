package fr.inria.spirals.sigma.ttc14.fixml.support

import fr.unice.i3s.sigma.workflow.lib.StandaloneSetup
import fr.unice.i3s.sigma.workflow.WorkflowApp
import fr.unice.i3s.sigma.workflow.lib.CleanDirectory
import fr.unice.i3s.sigma.workflow.lib.GenerateEcore
import fr.unice.i3s.sigma.workflow.lib.GenerateEMFScalaSupport

object GenerateModelSupport extends WorkflowApp {

  val projectName = "fr.inria.spirals.sigma.ttc14.fixml"
  val runtimeProject = s"../$projectName"
  val srcGen = s"$runtimeProject/src-gen"

  val ecoreModels = Seq(
    s"platform:/resource/$projectName/model/xmlmm.genmodel",
    s"platform:/resource/$projectName/model/objlang.genmodel"
  )

  !new StandaloneSetup {
    platformPath = s"$runtimeProject/.."
  }

  !new CleanDirectory {
    path = srcGen
  }

  for (model ← ecoreModels) {
    !new GenerateEcore {
      genModelURI = model
      srcPath(s"platform:/resource/${projectName}/src")
    }

    !new GenerateEMFScalaSupport {
      baseDir = srcGen
      genModelURI = model
      useOption = true
      useSeparateNamespace = true
      generateExtractors = true
    }
  }

}