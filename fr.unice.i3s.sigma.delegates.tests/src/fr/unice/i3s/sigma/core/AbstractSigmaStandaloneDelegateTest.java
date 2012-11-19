package fr.unice.i3s.sigma.core;

import org.junit.BeforeClass;

import testmodel.TestClass;
import testmodel.TmFactory;
import testmodel.TmPackage;
import fr.unice.i3s.sigma.delegates.SigmaDelegateDomain;

public abstract class AbstractSigmaStandaloneDelegateTest {

	protected final TmFactory tmFactory = TmPackage.eINSTANCE.getTmFactory();

	@BeforeClass
	public static void registerDelegates() {
		// load package
		TmPackage.eINSTANCE.eClass();

		// register Sigma delegate
		SigmaDelegateDomain.installGlobally();
	}

	protected TestClass createTestClass(String attribute) {
		TestClass tc = tmFactory.createTestClass();
		tc.setAttribute(attribute);
		return tc;
	}

}