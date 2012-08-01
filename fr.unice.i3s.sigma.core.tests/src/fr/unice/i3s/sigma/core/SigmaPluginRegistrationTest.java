package fr.unice.i3s.sigma.core;

import static org.junit.Assert.assertTrue;

import org.eclipse.core.runtime.Platform;
import org.junit.BeforeClass;
import org.junit.Test;

public final class SigmaPluginRegistrationTest {

	@BeforeClass
	public static void checkEclipseIsRunning() {
		assertTrue(
				"These tests are meant to be running as Eclipse plug-in tests",
				Platform.isRunning());
	}

	@Test
	public void testInvocationDelegate() {
		new SigmaInvocationDelegateTest().testDelegation();
	}

	@Test
	public void testSettingDelegate() {
		new SigmaSettingDelegateTest().testDelegation();
	}

	@Test
	public void testValidationDelegate() throws Exception {
		new SigmaValidationDelegateTest().testDelegate();
	}

}
