package fr.unice.i3s.utils.scala.emf

import org.junit.Assert.assertEquals
import org.junit.Test

import my.MyFactory

object TemplatesTest {

  //  @BeforeClass
  //  def configureGenModel() {
  //    GenModelPackage.eINSTANCE.getGenClass
  //
  //    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap() +=
  //      ("genmodel" -> new XMIResourceFactoryImpl())
  //    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap() +=
  //      ("ecore" -> new XMIResourceFactoryImpl())
  //
  //    GeneratorAdapterFactory.Descriptor.Registry.INSTANCE.addDescriptor(GenModelPackage.eNS_URI, GenModelGeneratorAdapterFactory.DESCRIPTOR)
  //
  //    EcorePlugin.getPlatformResourceMap() +=
  //      ("fr.unice.i3s.utils.scala.emf.tests" -> URI.createFileURI(new File(".").getAbsolutePath()))
  //  }

}

class TemplatesTest {

  //  @Before
  //  def regenerateModel() {
  //    val (genModel, rs) = load[GenModel]("model/My.genmodel")
  //    genModel.setForceOverwrite(true)
  //    genModel.setCanGenerate(true)
  //    genModel.setBundleManifest(false)
  //
  //    val generator = new Generator()
  //    generator.setInput(genModel)
  //
  //    println("Regenerating model to: " + genModel.getModelDirectory)
  //    generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, new BasicMonitor.Printing(System.out))
  //
  //    TODO: compile  
  //  }

  @Test
  def testScalaGetters() {
    val clazz = MyFactory.eINSTANCE.createClass1
    clazz.setAttribute1("Test")
    assertEquals("Test", clazz.attribute1)
  }

}