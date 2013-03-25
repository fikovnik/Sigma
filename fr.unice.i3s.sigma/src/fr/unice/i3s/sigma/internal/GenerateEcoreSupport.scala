package fr.unice.i3s.sigma.internal

import fr.unice.i3s.sigma.workflow.lib.CleanDirectory
import fr.unice.i3s.sigma.workflow.lib.StandaloneSetup
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl
import fr.unice.i3s.sigma.workflow.lib.GenerateEMFScalaSupport
import fr.unice.i3s.sigma.workflow.WorkflowApp

object GenerateEcoreSupport extends WorkflowApp {

  val projectName = "fr.unice.i3s.sigma"
  val runtimeProject = s"../$projectName"
  val srcGen = s"$runtimeProject/src-gen"

  val targetPackage = "fr.unice.i3s.sigma.support.ecore"
  val ecoreModel = "platform:/resource/org.eclipse.emf.ecore/model/Ecore.genmodel"

  StandaloneSetup(platformPath = s"$runtimeProject/..", logResourceURIMap = true)

  DirectoryCleaner(path = srcGen)

  EMFScalaSupportGenerator(
    baseDir = srcGen,
    genModelURI = ecoreModel,
    pkgName = targetPackage,
    config = { t ⇒
      t.skipTypes += "EStringToStringMapEntry"
    })
}