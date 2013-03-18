package fr.unice.i3s.sigma.java.delegates.codegen;

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory;
import org.eclipse.emf.common.notify.Adapter;

import fr.unice.i3s.sigma.java.delegates.JSigmaDelegateDomain;

public class SigmaGeneratorAdapterFactory extends
		GenModelGeneratorAdapterFactory {

	/**
	 * A descriptor for this adapter factory, which can be used to
	 * programatically
	 * {@link org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory.Descriptor.Registry#addDescriptor(String, org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory.Descriptor)
	 * register} it.
	 * 
	 * @see org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory.Descriptor.Registry
	 */
	public static final GeneratorAdapterFactory.Descriptor DESCRIPTOR = new GeneratorAdapterFactory.Descriptor() {
		@Override
		public GeneratorAdapterFactory createAdapterFactory() {
			return new SigmaGeneratorAdapterFactory();
		}
	};

	public static void install() {
		GeneratorAdapterFactory.Descriptor.Registry.INSTANCE.addDescriptor(
				GenModelPackage.eNS_URI, DESCRIPTOR);
	}

	@Override
	public Adapter createGenClassAdapter() {
		genClassGeneratorAdapter = null;
		return genClassGeneratorAdapter;
	}

	@Override
	public Adapter createGenEnumAdapter() {
		genEnumGeneratorAdapter = null;
		return genEnumGeneratorAdapter;
	}

	@Override
	public Adapter createGenModelAdapter() {
		if (genModelGeneratorAdapter == null) {
			genModelGeneratorAdapter = new SigmaGenModelGeneratorAdapter(
					getDomain(), this);
		}

		return genModelGeneratorAdapter;
	}

	@Override
	public Adapter createGenPackageAdapter() {
		genPackageGeneratorAdapter = null;
		return genPackageGeneratorAdapter;
	}

	protected JSigmaDelegateDomain getDomain() {
		return JSigmaDelegateDomain.getDefaultInstance();
	}

}
