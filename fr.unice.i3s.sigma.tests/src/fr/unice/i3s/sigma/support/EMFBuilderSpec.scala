package fr.unice.i3s.sigma.support

import scala.collection.JavaConversions._
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EcorePackage
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import fr.unice.i3s.sigma.support.EMFBuilder.InitializableEObject
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class EMFBuilderSpec extends FlatSpec with MustMatchers with EcorePackageScalaSupport {

  import EcorePackageScalaSupport._

  "EMFBuilder" must "create an EObject" in {
    val builder = new EMFBuilder(EcorePackage.eINSTANCE)
    import EMFBuilder._
    import builder._

    val clazz = create[EClass] init { clz ⇒
      clz.name = "MyClass"
      clz.`abstract` = false
      clz.eStructuralFeatures ++= List("A", "B") map { name ⇒
        create[EAttribute] init { _.name = name }
      }
    }

    clazz.name must be === "MyClass"
    clazz.eAttributes must have size (2)
    clazz.eAttributes.map(_.name) must be === List("A", "B")
  }

  it must "create and configure an EObject" in {
    val builder = new EMFBuilder(EcorePackage.eINSTANCE)
    import builder._

    var x: EClass = null
    val clazz = build[EClass](_.name = "MyClass", x = _)

    clazz.name must be === "MyClass"
    x must be === clazz
  }

}