package fr.unice.i3s.sigma.examples.uml.validation


import scala.collection.JavaConversions.asScalaBuffer
import org.eclipse.emf.common.util.URI
import org.eclipse.uml2.uml.resource.UMLResource
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfter
import org.scalatest.BeforeAndAfterAll
import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import fr.unice.i3s.sigma.examples.uml.support.UMLPackageScalaSupport
import fr.unice.i3s.sigma.test.scalatest.WorkflowTestSupport
import fr.unice.i3s.sigma.workflow.lib.StandaloneSetup
import org.scalatest.junit.JUnitRunner
import fr.unice.i3s.sigma.validation.ValidationContext
import scala.reflect.{ classTag, ClassTag }
import fr.unice.i3s.sigma.workflow.EMFWorkflow
import org.eclipse.uml2.uml.Class

abstract class AbstractSingletonSpec(val context: ValidationContext { type Self = Class }) extends FlatSpec with MustMatchers with WorkflowTestSupport with EMFWorkflow with UMLPackageScalaSupport with BeforeAndAfter with BeforeAndAfterAll {

  val projectName = "fr.unice.i3s.sigma.examples.uml.tests"
  val runtimeProject = s"../$projectName"

  override def beforeAll(configMap: Map[String, Any]) {

    !new StandaloneSetup {
      platformPath = s"$runtimeProject/.."
      registerPackage(org.eclipse.uml2.uml.UMLPackage.eINSTANCE)

      registerExtension(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE)

      addMapping("platform:/plugin/org.eclipse.uml2.uml/model/UML.ecore", "platform:/resource/org.eclipse.uml2.uml/model/UML.ecore")
      addMapping(UMLResource.LIBRARIES_PATHMAP, "platform:/resource/org.eclipse.uml2.uml.resources/libraries/")
      addMapping(UMLResource.METAMODELS_PATHMAP, "platform:/resource/org.eclipse.uml2.uml.resources/metamodels/")
      addMapping(UMLResource.PROFILES_PATHMAP, "platform:/resource/org.eclipse.uml2.uml.resources/profiles/")
    }

  }

  var pkg: Package = _
  val name = context.getClass.getSimpleName

  before {
    pkg = loadModel[Package](getClass.getResource("/model/Test.uml"))
  }

  name must "report DefinesGetInstance on missing GetInstance" in {
    val cls = pkg.packagedElement.collectFirst { case e: Class if e.name == "Singleton1" ⇒ e }.get
    val res = context.validate(cls)
    res.violates("DefinesGetInstance") must be === true
  }
}

@RunWith(classOf[JUnitRunner])
class MethodBasedSingletonSpec extends AbstractSingletonSpec(new MethodBasedSingletonContext)

@RunWith(classOf[JUnitRunner])
class BuilderBasedSingletonSpec extends AbstractSingletonSpec(new BuilderBasedSingletonContext)