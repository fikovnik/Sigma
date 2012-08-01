package fr.unice.i3s.sigma.core;

import java.io.File;

import library.Library;
import library.LibraryPackage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.BeforeClass;

import fr.unice.i3s.sigma.core.SigmaDelegateDomain;

public abstract class AbstractSigmaStandaloneDelegateTest {

	@BeforeClass
	public static void registerDelegates() {
		// load package
		EPackage.Registry.INSTANCE.put(LibraryPackage.eNS_URI,
				LibraryPackage.eINSTANCE);

		// initialize resource factories
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"xmi", new XMIResourceFactoryImpl());

		SigmaDelegateDomain.installGlobally();
	}

	protected static Library load(String filename) {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.getResource(
				URI.createFileURI(new File(filename).getAbsolutePath()), true);
		return (Library) r.getContents().get(0);
	}

}