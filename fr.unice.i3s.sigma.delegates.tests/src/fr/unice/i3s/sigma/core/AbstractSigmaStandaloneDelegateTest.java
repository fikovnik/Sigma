package fr.unice.i3s.sigma.core;

import org.eclipse.emf.ecore.EPackage;
import org.junit.BeforeClass;

import tm.TmPackage;
import fr.unice.i3s.sigma.delegates.SigmaDelegateDomain;

public abstract class AbstractSigmaStandaloneDelegateTest {

	@BeforeClass
	public static void registerDelegates() {
		// load package
		EPackage.Registry.INSTANCE.put(TmPackage.eNS_URI, TmPackage.eINSTANCE);

		// // initialize resource factories
		// Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
		// "xmi", new XMIResourceFactoryImpl());

		SigmaDelegateDomain.installGlobally();
	}

	// protected static Library load(String filename) {
	// ResourceSet rs = new ResourceSetImpl();
	// Resource r = rs.getResource(
	// URI.createFileURI(new File(filename).getAbsolutePath()), true);
	// return (Library) r.getContents().get(0);
	// }

}