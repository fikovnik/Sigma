package fr.unice.i3s.sigma.examples.sle13.performance

import java.io.File
import scala.collection.JavaConversions._
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel
import org.eclipse.epsilon.evl.EvlModule
import fr.unice.i3s.sigma.util.EMFUtils
import fr.unice.i3s.sigma.util.IOUtils
import uml.ScopeKind
import uml.support.UmlPackageScalaSupport
import fr.unice.i3s.sigma.examples.sle13.SingletonMethodBased
import scala.collection.mutable.ListBuffer
import fr.unice.i3s.sigma.validation.ValidationContextResult
import fr.unice.i3s.sigma.validation.ValidationResult
import uml.UMLPackage
import fr.unice.i3s.sigma.examples.sle13.sigma.Uml2Java
import fr.unice.i3s.sigma.examples.sle13.acceleo.main.Generate
import org.eclipse.emf.common.util.BasicMonitor
import java.util.Collections
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter
import org.eclipse.epsilon.egl.EglTemplateFactory
import org.eclipse.epsilon.eol.execute.context.Variable
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory
import fr.unice.i3s.sigma.examples.sle13.java.Uml2JavaInJava
import java.io.FileWriter

trait PerformanceTest {

  def execute(res: Resource): Unit
  def post = {}
  def dispose = {}

}

class SigmaM2T(val targetDir: File) extends PerformanceTest with UmlPackageScalaSupport {
  import IOUtils.RichSigmaFile

  def execute(res: Resource) {
    //    res.getAllContents foreach { e ⇒
    //      e match {
    //        case cls: UmlClass ⇒
    //          new File(targetDir, s"${cls.name}.java") << Uml2Java(cls)
    //        case _ ⇒
    //      }
    //    }
    res.getAllContents foreach { e ⇒
      if (e.isInstanceOf[UmlClass]) {
        val cls = e.asInstanceOf[UmlClass]
        val fw = new FileWriter(new File(targetDir, s"${cls.name}.java"))
        fw.write(Uml2Java(cls).toString)
        fw.close()
      }
    }
  }

  override def toString = s"Sigma $targetDir"
}

class JavaM2T(val targetDir: File) extends PerformanceTest with UmlPackageScalaSupport {
  import IOUtils.RichSigmaFile

  def execute(res: Resource) {
    res.getAllContents foreach { e ⇒
      if (e.isInstanceOf[UmlClass]) {
        val cls = e.asInstanceOf[UmlClass]
        val fw = new FileWriter(new File(targetDir, s"${cls.name}.java"))
        fw.write(new Uml2JavaInJava(e.asInstanceOf[UmlClass]).generate())
        fw.close()
      }
    }
    //    res.getAllContents foreach { e ⇒
    //      e match {
    //        case cls: UmlClass ⇒
    //          new File(targetDir, s"${cls.name}.java") << new Uml2JavaInJava(cls).generate()
    //        case _ ⇒
    //      }
    //    }
  }

  override def toString = s"Java $targetDir"
}

class AcceleoM2T(val targetDir: File) extends PerformanceTest with UmlPackageScalaSupport {
  def execute(res: Resource) {
    val generator = new Generate(res.getContents.get(0), targetDir, Collections.emptyList())
    generator.doGenerate(new BasicMonitor)
  }

  override def toString = s"Acceleo $targetDir"
}

class EpsilonM2T(val targetDir: File) extends PerformanceTest with UmlPackageScalaSupport {
	val ePackageUri = UMLPackage.eINSTANCE.getNsURI
			val source = new File("src/fr/unice/i3s/sigma/examples/sle13/epsilon/Uml2Java.egl").toURI()
			val factory = {
		val f = new EglFileGeneratingTemplateFactory
				f.setTemplateRoot(new File("src/fr/unice/i3s/sigma/examples/sle13/epsilon/").toURI.toString)
				f.getContext().getFrameStack().put(Variable.createReadOnlyVariable("targetDir", targetDir.getAbsolutePath))
				f
	}
	
	val template = factory.load(source)
			
			def execute(resource: Resource) = {
		val model = new InMemoryEmfModel("model", resource, ePackageUri);
		factory.getContext.getModelRepository.addModel(model)
		
		template.process
	}
	
	override def dispose {
		factory.getContext().getModelRepository().dispose();
	}
	
	override def toString = s"Epsilon $targetDir"
}

class EpsilonM2T2(val targetDir: File) extends PerformanceTest with UmlPackageScalaSupport {
  val ePackageUri = UMLPackage.eINSTANCE.getNsURI
  //  val source = new File("src/fr/unice/i3s/sigma/examples/sle13/epsilon/Uml2Java.egl").toURI()
  val source = new File("src/fr/unice/i3s/sigma/examples/sle13/epsilon/JavaClass.egl").toURI()
  val factory = {
    val f = new EglFileGeneratingTemplateFactory
    f.setTemplateRoot(new File("src/fr/unice/i3s/sigma/examples/sle13/epsilon/").toURI.toString)
    //    f.getContext().getFrameStack().put(Variable.createReadOnlyVariable("targetDir", targetDir.getAbsolutePath))
    f
  }

  val template = factory.load(source)

  def execute(resource: Resource) = {
    //    val model = new InMemoryEmfModel("model", resource, ePackageUri);
    //    factory.getContext.getModelRepository.addModel(model)
    import IOUtils.RichSigmaFile
   
    resource.getAllContents foreach { e ⇒
      e match {
        case cls: UmlClass ⇒ {
          template.populate("cls", cls)
          val res = template.process
          new File(targetDir, s"${cls.name}.java") << res
        }
        case _ ⇒
      }
    }

  }

  override def dispose {
    factory.getContext().getModelRepository().dispose();
  }

  override def toString = s"Epsilon $targetDir"
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
    require(m.getParseProblems.size == 0, "EVL parse problems!\n" + m.getParseProblems().mkString("\n"))
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

  for (i ← 0 until 20) {
    val test = new EpsilonValidation
    //    val test = new SigmaValidation

    val start = System.currentTimeMillis
    test.execute(resource)
    val stop = System.currentTimeMillis - start
    println(stop)

    //  test.post
    test.dispose
  }

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

object Test2 extends App {

  // register
  EMFUtils.IO.registerDefaultFactories
  UMLPackage.eINSTANCE.getEFactoryInstance

  val resource = generateData(500, 100)

  //  val test = new EpsilonValidation
  for (i ← 0 until 20) {
//            val test = new SigmaM2T(IOUtils.mkdtemp)
//    val test = new AcceleoM2T(IOUtils.mkdtemp)
            val test = new EpsilonM2T2(IOUtils.mkdtemp)
    //    val test = new JavaM2T(IOUtils.mkdtemp)

//        println(s"$test")
    val start = System.currentTimeMillis
    test.execute(resource)
    val stop = System.currentTimeMillis - start
    val rt = Runtime.getRuntime()
    println(stop + "," + rt.freeMemory() + "," + rt.maxMemory() + "," + rt.totalMemory())
    test.post
    test.dispose
  }

  def generateData(n: Int, m: Int) = {
    import UmlPackageScalaSupport._

    val resourceSet = new ResourceSetImpl
    val resource = resourceSet.createResource(URI.createFileURI("test.xmi"))

    val pkg = UmlPackage()
    resource.getContents += pkg

    val int = PrimitiveType(name = "int")
    pkg.ownedElements += int

    for (i ← 0 until n) {
      val cls = UmlClass(name = "A" + i)
      for (j ← 0 until m) {
        cls.operations += Operation(name = "op" + j, returnType = int)
      }
      pkg.ownedElements += cls
    }

    resource
  }

}

