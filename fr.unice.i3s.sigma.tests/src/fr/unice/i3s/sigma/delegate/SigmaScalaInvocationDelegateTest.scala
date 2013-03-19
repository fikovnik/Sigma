package fr.unice.i3s.sigma.delegate

import org.junit.Assert._
import org.junit.Test
import test.TestFactory
import test.delegates.ADelegate
import test.delegates.BDelegate

final class SigmaScalaInvocationDelegateTest extends AbstractSigmaScalaStandaloneDelegateTest {

  @Test
  def testInheritance() {
    val a = TestFactory.eINSTANCE.createA
    val b = TestFactory.eINSTANCE.createB
    val c = TestFactory.eINSTANCE.createC

    assertEquals(ADelegate.invokeOp1(a), a.op1)
    assertEquals(BDelegate.invokeOp1(b), b.op1)
    assertEquals(ADelegate.invokeOp1(c), c.op1)
  }

}