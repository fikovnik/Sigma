package fr.unice.i3s.sigma.examples.library.support

import fr.unice.i3s.sigma.workflow.lib.StandaloneSetup
import fr.unice.i3s.sigma.workflow.WorkflowApp
import fr.unice.i3s.sigma.workflow.lib.CleanDirectory
import fr.unice.i3s.sigma.workflow.lib.GenerateEcore
import fr.unice.i3s.sigma.workflow.lib.GenerateEMFScalaSupport

object GenerateLibraryScalaSupport extends WorkflowApp {

  val projectName = "fr.unice.i3s.sigma.examples.library"
  val runtimeProject = s"../$projectName"
  val src = s"$runtimeProject/src"
  val srcGen = s"$runtimeProject/src-gen"

  val packageSuffix = ".support"
  val ecoreModel = s"platform:/resource/$projectName/model/Library.genmodel"

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
    packageNameMapping = { _ + packageSuffix }
    generateExtractors = true
    generateDelegates = true
    delegatesBaseDir = src
    useEMFBuilder = true
    useOption = true
  }
  
  !new GenerateEcore {
	  genModelURI = ecoreModel
	  srcPath(src)
  }
}