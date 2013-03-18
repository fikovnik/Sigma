package fr.unice.i3s.sigma.core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import testmodel.TestClass;
import testmodel.delegates.TestClassDelegate;

public class SigmaInvocationDelegateTest extends
		AbstractSigmaStandaloneDelegateTest {

	@Test
	public void testInvocationWithNoParametersDelegation() {
		TestClass self = createTestClass("ABCDEF");

		assertEquals(TestClassDelegate.invokeMethod(self), self.method());
	}

	@Test
	public void testInvocationWithParametersDelegation() {
		TestClass self = createTestClass("ABCDEF");

		assertEquals(TestClassDelegate.invokeMethodWithArgs(self, "a", 1),
				self.methodWithArgs("a", 1));
	}

}
