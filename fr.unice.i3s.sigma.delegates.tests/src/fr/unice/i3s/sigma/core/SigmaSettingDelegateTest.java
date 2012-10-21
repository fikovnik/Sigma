package fr.unice.i3s.sigma.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tm.TestClass;
import tm.delegates.TestClassDelegate;

public class SigmaSettingDelegateTest extends
		AbstractSigmaStandaloneDelegateTest {

	@Test
	public void testDelegation() {
		TestClass self = createTestClass("ABCDEF");

		assertEquals(TestClassDelegate.getDerivedAttribute(self),
				self.getDerivedAttribute());
	}

}
