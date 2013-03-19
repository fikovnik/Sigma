package fr.unice.i3s.sigma.delegate

import org.junit.Assert._
import org.junit.Test
import test.TestFactory
import test.delegates.DDelegate

final class SigmaScalaSettingValidationDelegateTest extends AbstractSigmaScalaStandaloneDelegateTest {

  @Test
  def testSetter() {
    val d = TestFactory.eINSTANCE.createD

    assertEquals(DDelegate.getAttr1(d), d.getAttr1)
  }

}