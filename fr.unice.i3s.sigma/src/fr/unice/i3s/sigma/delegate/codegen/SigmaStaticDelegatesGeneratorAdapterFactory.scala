package fr.unice.i3s.sigma.delegate.codegen

import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import fr.unice.i3s.sigma.delegate.SigmaDelegateDomain

object ScalaEcoreExtensionsGeneratorAdapterFactory {

  lazy val DESCRIPTOR = new GeneratorAdapterFactory.Descriptor {
    override def createAdapterFactory = new ScalaEcoreExtensionsGeneratorAdapterFactory
  }

  def install {
    GeneratorAdapterFactory.Descriptor.Registry.INSTANCE.addDescriptor(
      GenModelPackage.eNS_URI, DESCRIPTOR)
  }

}

class ScalaEcoreExtensionsGeneratorAdapterFactory extends GenModelGeneratorAdapterFactory {

  override def createGenClassAdapter = {
    if (genClassGeneratorAdapter == null) {
      genClassGeneratorAdapter = new ScalaEcoreExtensionsGenClassGeneratorAdapter(SigmaDelegateDomain.instance, this);
    }

    genClassGeneratorAdapter
  }

  override def createGenEnumAdapter = {
    genEnumGeneratorAdapter = null
    genEnumGeneratorAdapter
  }

  override def createGenModelAdapter = {
    genModelGeneratorAdapter = null
    genModelGeneratorAdapter
  }

  override def createGenPackageAdapter = {
    genPackageGeneratorAdapter = null
    genPackageGeneratorAdapter
  }

}