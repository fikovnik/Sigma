package fr.unice.i3s.sigma.examples.uml.support

import scala.collection.JavaConversions._
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.URIConverter
import fr.unice.i3s.sigma.workflow.lib.StandaloneSetup
import fr.unice.i3s.sigma.workflow.lib.DirectoryCleaner
import fr.unice.i3s.sigma.workflow.lib.EMFScalaSupportGenerator
import fr.unice.i3s.sigma.workflow.lib.EcoreGenerator

object GenerateScalaSupport extends App {

  val projectName = "fr.unice.i3s.sigma.examples.uml"
  val runtimeProject = s"../$projectName"
  val srcGen = s"$runtimeProject/src-gen"

  val targetPackage = "fr.unice.i3s.sigma.examples.uml.support"
  //  val ecoreModel = s"platform:/resource/org.eclipse.uml2.uml/model/UML.genmodel"
  val ecoreModel = s"platform:/resource/$projectName/model/UML.genmodel"

  // add support for this to standalone setup
  // registerEPackage(org.eclipse.emf.ecore.EcorePackage.eINSTANCE)
  org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEClass
  org.eclipse.uml2.types.TypesPackage.eINSTANCE.getBoolean
  org.eclipse.uml2.codegen.ecore.genmodel.GenModelPackage.eINSTANCE.getGenClass
  org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage.eINSTANCE.getGenClass
  println(EPackage.Registry.INSTANCE map { case (k, v) ⇒ s"$k -> $v" } mkString ("\n"))

  StandaloneSetup(
    platformURI = s"$runtimeProject/..",
    logResourceURIMap = true //    registerGenModelFiles = List(
    //      "platform:/resource/org.eclipse.uml2.codegen.ecore/model/GenModel.genmodel",
    //      "platform:/resource/org.eclipse.emf.ecore/model/Ecore.genmodel",
    //      "platform:/resource/org.eclipse.emf.codegen.ecore/model/GenModel.genmodel")
    )

  // TODO: check how to work with the URI conversions
  // so there is no need to rewrite the the files - TODO later
  val mapp = URIConverter.INSTANCE.getURIMap
  mapp.put(
    URI.createURI("platform:/plugin/org.eclipse.emf.ecore/model/Ecore.genmodel"),
    URI.createURI(org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getNsURI))
  mapp.put(
    URI.createURI("platform:/plugin/org.eclipse.uml2.types/model/Types.genmodel"),
    URI.createURI(org.eclipse.uml2.types.TypesPackage.eINSTANCE.getNsURI))

  //  URIConverter.URI_MAP.put(
  //    URI.createURI("platform:/plugin/org.eclipse.emf.ecore/model/Ecore.genmodel"), URI.createURI("platform:/resource/org.eclipse.emf.ecore/model/Ecore.genmodel"))
  //  URIConverter.URI_MAP.put(
  //    URI.createURI("platform:/plugin/org.eclipse.uml2.types/model/Types.genmodel"), URI.createURI("platform:/resource/org.eclipse.uml2.types/model/Types.genmodel"))

  DirectoryCleaner(path = srcGen)

  EMFScalaSupportGenerator(
    baseDir = srcGen,
    genModelURI = ecoreModel,
    pkgName = targetPackage,
    skipTypes = List("DurationObservation", "DurationConstraint") //    aliases = {
    //      List("Boolean", "Integer", "String", "Class", "Package")
    //        .map { e ⇒ (e, "UML" + e) }
    //        .toMap
    //    }
    )

}