package fr.unice.i3s.sigma.examples.sle13.performance

import java.io.File
import scala.collection.JavaConversions._
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel
import org.eclipse.epsilon.evl.EvlModule
import fr.unice.i3s.sigma.util.EMFUtils
import uml.ScopeKind
import uml.support.UmlPackageScalaSupport
import fr.unice.i3s.sigma.examples.sle13.SingletonMethodBased
import scala.collection.mutable.ListBuffer
import fr.unice.i3s.sigma.validation.ValidationContextResult
import fr.unice.i3s.sigma.validation.ValidationResult
import uml.UMLPackage

trait PerformanceTest {

  def execute(res: Resource): Unit
  def post = {}
  def dispose = {}

}

class SigmaValidation extends PerformanceTest with UmlPackageScalaSupport {

  val ctx = new SingletonMethodBased
  val unsatisfied = new ListBuffer[(UmlClass, Iterable[ValidationResult])]()

  def execute(res: Resource) {
    res.getContents foreach { e ⇒
      e match {
        case cls: UmlClass ⇒
          val res = ctx.validate(cls)
          if (!res.passed) {
            unsatisfied += ((cls, res.results.values filter (!_.passed)))
          }
      }
    }
  }

  override def post {
    if (unsatisfied.size > 0) {
      println(unsatisfied.size + " constraint(s) have not been satisfied");
      println(unsatisfied map (_._2) map (_.mkString(",")) mkString ("\n"))
    } else {
      println("All constraints have been satisfied");
    }

  }
}

class EpsilonValidation extends PerformanceTest {

  val ePackageUri = UMLPackage.eINSTANCE.getNsURI
  val source = new File("src/fr/unice/i3s/sigma/examples/sle13/epsilon/Singleton.evl").toURI()
  val module: EvlModule = {
    val m = new EvlModule
    m.parse(source)
    require(m.getParseProblems.size == 0, "EVL parse problems!\n" + module.getParseProblems().mkString("\n"))
    m
  }

  def execute(resource: Resource) = {
    val model = new InMemoryEmfModel("model", resource, ePackageUri);
    module.getContext.getModelRepository.addModel(model)

    module.execute
  }

  override def post {
    val unsatisfied = module.getContext.getUnsatisfiedConstraints();

    if (unsatisfied.size > 0) {
      println(unsatisfied.size + " constraint(s) have not been satisfied");
      println(unsatisfied map (_.getMessage) mkString ("\n"))
    } else {
      println("All constraints have been satisfied");
    }

  }

  override def dispose {
    module.getContext().getModelRepository().dispose();
  }

}

object Test extends App {

  // register
  EMFUtils.IO.registerDefaultFactories
  UMLPackage.eINSTANCE.getEFactoryInstance

  val resource = generateData(600, 400)

  //  val test = new EpsilonValidation
  val test = new SigmaValidation

  val start = System.currentTimeMillis
  test.execute(resource)
  val stop = System.currentTimeMillis - start
  println(stop)

  test.post
  test.dispose

  def generateData(n: Int, m: Int) = {
    import UmlPackageScalaSupport._

    val resourceSet = new ResourceSetImpl
    val resource = resourceSet.createResource(URI.createFileURI("test.xmi"))

    for (i ← 0 until n) {
      val cls = UmlClass(
        name = "A",
        stereotypes = Seq(
          Stereotype("singleton")
        ),
        operations = Seq(
          Operation(name = "getInstance", ownerScope = ScopeKind.SK_CLASSIFIER)
        )
      )
      resource.getContents += cls
    }

    // bad ones
    for (i ← 0 until m) {
      val cls = UmlClass(
        name = "A",
        stereotypes = Seq(
          Stereotype("singleton")
        ),
        operations = Seq(
          Operation(name = "getInstance", ownerScope = ScopeKind.SK_INSTANCE)
        )
      )
      resource.getContents += cls
    }

    resource
  }

}

