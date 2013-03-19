package fr.unice.i3s.sigma.delegate

import org.eclipse.core.runtime.Platform
import org.junit.Assert._
import org.junit.BeforeClass
import org.junit.Test

final object SigmaScalaPluginRegistrationTest {

  @BeforeClass
  def checkIsEclipseRunning() {
    assertTrue("These tests are meant to be running as Eclipse plug-in tests",
      Platform.isRunning)
  }
}

/**
 * These tests checks whether the delegation has been correctly set up
 * in the platform (plugin.xml).
 */
final class SigmaScalaPluginRegistrationTest {

  @Test
  def testInvocationDelegates() {
    new SigmaScalaInvocationDelegateTest().testInheritance
  }

  @Test
  def testSettingDelegates() {
    new SigmaScalaSettingValidationDelegateTest().testSetter
  }

  @Test
  def testValidationDelegates() {
    new SigmaScalaValidationDelegateTest().testSimpleValidation
  }

}