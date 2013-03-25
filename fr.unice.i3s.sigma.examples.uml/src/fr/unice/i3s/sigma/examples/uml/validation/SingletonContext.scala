package fr.unice.i3s.sigma.examples.uml.validation

import scala.collection.JavaConversions._
import fr.unice.i3s.sigma.validation.ValidationContext
import fr.unice.i3s.sigma.examples.uml.support.UmlBuilder._
import fr.unice.i3s.sigma.examples.uml.support.UmlPackageScalaSupport
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.uml2.uml.resource.UMLResource
import fr.unice.i3s.sigma.util.EMFUtils
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.emf.mapping.ecore2xml.util.Ecore2XMLResource
import org.eclipse.uml2.uml.resource.UML22UMLResource
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.mapping.ecore2xml.Ecore2XMLPackage
import org.eclipse.uml2.uml.resource.UML22UMLExtendedMetaData
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil
import fr.unice.i3s.sigma.workflow.WorkflowApp
import fr.unice.i3s.sigma.workflow.lib.StandaloneSetup
import fr.unice.i3s.sigma.workflow.lib.LoadModel
import fr.unice.i3s.sigma.workflow.lib.ValidateModel
import fr.unice.i3s.sigma.validation.Passed
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.uml2.uml.resources.ResourcesPlugin
import org.eclipse.emf.ecore.plugin.EcorePlugin
import org.eclipse.uml2.uml.UMLPlugin

class SingletonContext extends ValidationContext[UMLClass] with UmlPackageScalaSupport {

  // getAppliedStereotypes is an operation not a reference thus
  // no Scala-like getter is available
  guard = self.getAppliedStereotype("TestProfile::singleton") != null

  val invDefinesGetInstance = new Constraint("DefinesGetInstance") {
    check = Passed
  }

}

object Test extends WorkflowApp with UmlPackageScalaSupport {

  // http://www.eclipse.org/forums/index.php/mv/msg/151754/

  val projectName = "fr.unice.i3s.sigma.examples.uml"
  val runtimeProject = s"../$projectName"

  StandaloneSetup(
    platformPath = s"$runtimeProject/..",
    logResourceURIMap = true,
    logRegisteredPackages = true,
    config = { t ⇒
      t.registerPackages += org.eclipse.uml2.uml.UMLPackage.eINSTANCE

      t.registerExtensions += (UMLResource.FILE_EXTENSION -> UMLResource.Factory.INSTANCE)

      t.URIMap += ("platform:/plugin/org.eclipse.uml2.uml/model/UML.ecore" -> "platform:/resource/org.eclipse.uml2.uml/model/UML.ecore")
      t.URIMap += (UMLResource.LIBRARIES_PATHMAP -> "platform:/resource/org.eclipse.uml2.uml.resources/libraries/")
      t.URIMap += (UMLResource.METAMODELS_PATHMAP -> "platform:/resource/org.eclipse.uml2.uml.resources/metamodels/")
      t.URIMap += (UMLResource.PROFILES_PATHMAP -> "platform:/resource/org.eclipse.uml2.uml.resources/profiles/")

    })

  val pkg = LoadModel(URI.createPlatformResourceURI("/fr.unice.i3s.sigma.examples.uml/model/Test.uml", false)).model[UMLPackage]
  ValidateModel(pkg)

  println(pkg)
  println(pkg.getAllAppliedProfiles())

  val ctx = new SingletonContext
  for (cls ← pkg.packagedElement collect { case e: UMLClass ⇒ e }) {
    println(ctx.validate(cls))
    println(cls)
    println(pkg.getAllAppliedProfiles())
    println(cls.getAppliedStereotypes())
    println(cls.getAppliedStereotypes() map { _.qualifiedName })
  }

}