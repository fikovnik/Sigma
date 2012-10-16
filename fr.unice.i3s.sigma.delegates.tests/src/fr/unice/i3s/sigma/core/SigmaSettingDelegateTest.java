package fr.unice.i3s.sigma.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tm.TestClass;
import tm.TmFactory;
import tm.TmPackage;

public class SigmaSettingDelegateTest extends
		AbstractSigmaStandaloneDelegateTest {

	@Test
	public void testDelegation() {
		TmFactory fm = TmPackage.eINSTANCE.getTmFactory();

		TestClass tc = fm.createTestClass();
		tc.setAttribute(10);

		assertEquals(5, tc.getDerivedAttribute());
	}

}
