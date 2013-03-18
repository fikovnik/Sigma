package fr.unice.i3s.sigma.core;

import static org.junit.Assert.assertTrue;

import org.eclipse.core.runtime.Platform;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ SigmaInvocationDelegateTest.class,
		SigmaSettingDelegateTest.class, SigmaValidationDelegateTest.class })
public final class SigmaPluginRegistrationTest {

	@BeforeClass
	public static void checkEclipseIsRunning() {
		assertTrue(
				"These tests are meant to be running as Eclipse plug-in tests",
				Platform.isRunning());
	}

}
