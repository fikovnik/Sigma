package fr.unice.i3s.sigma.examples.uml.validation

import scala.collection.JavaConversions.asScalaBuffer
import org.eclipse.emf.common.util.URI
import org.eclipse.uml2.uml.resource.UMLResource
import org.junit.runner.RunWith
import org.scalatest.BeforeAndAfter
import org.scalatest.BeforeAndAfterAll
import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import fr.unice.i3s.sigma.examples.uml.support.UmlBuilder._
import fr.unice.i3s.sigma.examples.uml.support.UmlPackageScalaSupport
import fr.unice.i3s.sigma.test.scalatest.WorkflowTestSupport
import fr.unice.i3s.sigma.workflow.lib.LoadModel
import fr.unice.i3s.sigma.workflow.lib.StandaloneSetup
import org.scalatest.junit.JUnitRunner
import fr.unice.i3s.sigma.validation.ValidationContext
import scala.reflect.{ classTag, ClassTag }

abstract class AbstractSingletonSpec[T <: ValidationContext[UMLClass]: ClassTag] extends FlatSpec with MustMatchers with WorkflowTestSupport with UmlPackageScalaSupport with BeforeAndAfter with BeforeAndAfterAll {

  val projectName = "fr.unice.i3s.sigma.examples.uml.tests"
  val runtimeProject = s"../$projectName"
  val modelURI = "/model/Test.uml"

  override def beforeAll(configMap: Map[String, Any]) {

    StandaloneSetup(
      platformPath = s"$runtimeProject/..",
      config = { t ⇒
        t.registerPackage(org.eclipse.uml2.uml.UMLPackage.eINSTANCE)

        t.registerExtension(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE)

        t.addMapping("platform:/plugin/org.eclipse.uml2.uml/model/UML.ecore", "platform:/resource/org.eclipse.uml2.uml/model/UML.ecore")
        t.addMapping(UMLResource.LIBRARIES_PATHMAP, "platform:/resource/org.eclipse.uml2.uml.resources/libraries/")
        t.addMapping(UMLResource.METAMODELS_PATHMAP, "platform:/resource/org.eclipse.uml2.uml.resources/metamodels/")
        t.addMapping(UMLResource.PROFILES_PATHMAP, "platform:/resource/org.eclipse.uml2.uml.resources/profiles/")
      }
    )
  }

  var pkg: UMLPackage = _
  var context: T = _
  val name: String = classTag[T].runtimeClass.getSimpleName

  before {
    pkg = LoadModel(URI.createURI(getClass.getResource(modelURI).toString)).model[UMLPackage]
    context = classTag[T].runtimeClass.getConstructor().newInstance().asInstanceOf[T]
  }

  name must "report DefinesGetInstance on missing GetInstance" in {
    val cls = pkg.packagedElement.collectFirst { case e: UMLClass if e.name == "Singleton1" ⇒ e }.get
    val res = context.validate(cls)
    res.violates('DefinesGetInstance) must be === true
  }
}

@RunWith(classOf[JUnitRunner])
class SingletonSpec extends AbstractSingletonSpec[SingletonContext]

@RunWith(classOf[JUnitRunner])
class MethodBasedSingletonSpec extends AbstractSingletonSpec[MethodBasedSingletonContext]