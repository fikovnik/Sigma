package fr.unice.i3s.sigma.core;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import tm.TestClass;
import tm.TmFactory;
import tm.TmPackage;

public class SigmaInvocationDelegateTest extends
		AbstractSigmaStandaloneDelegateTest {

	@Test
	public void testNoParametersDelegation() {
		TmFactory fm = TmPackage.eINSTANCE.getTmFactory();

		TestClass tc = fm.createTestClass();
		tc.setAttribute(10);

		assertEquals(100, tc.getSquare());
	}

	// TODO: check invocation with arguments

}
