package fr.unice.i3s.sigma.scala.utils

import scala.collection.JavaConversions._
import org.junit.Assert._
import org.junit.Test
import org.eclipse.emf.ecore.EcorePackage
import org.junit.Before
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import org.junit.Before
import org.junit.Test
import org.eclipse.emf.ecore.EAttribute

final class EMFBuilderTest {

  @Before
  def setUp() {
    EcorePackage.eINSTANCE.eClass
  }

  @Test
  def testMultiplInitializationIsNotSupported() {
    val builder = new EMFBuilder(EcorePackage.eINSTANCE)
    import builder._

    val eclazz = create[EClass] initLater { clz ⇒
      clz.setName("MyClass")
    }

    try {
      eclazz initLater { clz ⇒
        clz.setName("MyClass2")
      }
      fail("Multiple initialization is not supported")
    } catch {
      case e: IllegalStateException ⇒
      case _: Throwable ⇒ fail("Invalid exception thrown")
    }

  }

  @Test
  def testPostponedContentInitializerAdapter() {
    val res = new ResourceImpl

    res.eAdapters.add(new PostponeContentInitializerAdapter)

    val builder = new EMFBuilder(EcorePackage.eINSTANCE)
    import builder._

    // FIXME: try a different scenario
    // class1 initLater (add an attribute)
    // class2 initLater (add an attribute)
    // check where do these attributes end up

    val eclazz = create[EClass] initLater { clz ⇒
      clz.setName("MyClass")
      clz.setAbstract(false)
      clz.getEStructuralFeatures ++= List("A", "B") map (name ⇒ create[EAttribute] init { _.setName(name) })
    }

    assertNull(eclazz.getName)
    assertEquals(0, eclazz.getEAttributes.size)

    res.getContents += eclazz

    assertEquals("MyClass", eclazz.getName)
    assertEquals(2, eclazz.getEAttributes.size)
    assertEquals(List("A", "B"), eclazz.getEAttributes map (_.getName))
  }

  @Test
  def testPostponedInitialize() {
    val builder = new EMFBuilder(EcorePackage.eINSTANCE)
    import builder._

    val eclazz = create[EClass] initLater { clz ⇒
      clz.setName("MyClass")
      clz.setAbstract(false)
      clz.getEStructuralFeatures ++= List("A", "B") map (name ⇒ create[EAttribute] init { _.setName(name) })
    }

    assertNull(eclazz.getName)
    assertEquals(0, eclazz.getEAttributes.size)

    val adapter = eclazz.adapter[PostponedInitizationAdapter[_]]
    assertTrue(adapter.isDefined)

    // actual initialization
    adapter.get.initialize

    assertEquals("MyClass", eclazz.getName)
    assertEquals(2, eclazz.getEAttributes.size)
    assertEquals(List("A", "B"), eclazz.getEAttributes map (_.getName))

    assertFalse(eclazz.adapter[PostponedInitizationAdapter[_]].isDefined)
  }

  @Test
  def testInitialize() {
    val builder = new EMFBuilder(EcorePackage.eINSTANCE)
    import builder._

    val eclazz = create[EClass] init { clz ⇒
      clz.setName("MyClass")
      clz.setAbstract(false)
      clz.getEStructuralFeatures ++= List("A", "B") map (name ⇒ create[EAttribute] init { _.setName(name) })
    }

    assertEquals("MyClass", eclazz.getName)
    assertEquals(2, eclazz.getEAttributes.size)
    assertEquals(List("A", "B"), eclazz.getEAttributes map (_.getName))
  }

  @Test
  def testBasicCreate() {
    val builder = new EMFBuilder(EcorePackage.eINSTANCE)
    import builder._

    val eclazz = create[EClass] init { clz: EClass ⇒
      clz.setName("MyClass")
      clz.setAbstract(false)
      clz.getEStructuralFeatures ++= List("A", "B") map (name ⇒ builder.create[EAttribute] init { _.setName(name) })
    }

    assertEquals("MyClass", eclazz.getName)
    assertEquals(2, eclazz.getEAttributes.size)
    assertEquals(List("A", "B"), eclazz.getEAttributes map (_.getName))
  }

}