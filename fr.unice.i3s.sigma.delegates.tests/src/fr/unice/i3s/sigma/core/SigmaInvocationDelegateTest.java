package fr.unice.i3s.sigma.core;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import tm.TestClass;
import tm.delegates.TestClassDelegate;

public class SigmaInvocationDelegateTest extends
		AbstractSigmaStandaloneDelegateTest {

	@Test
	public void testNoParametersDelegation() {
		TestClass self = createTestClass("ABCDEF");

		assertEquals(TestClassDelegate.invokeMethod(self), self.method());
	}

	// TODO: check invocation with arguments

}
