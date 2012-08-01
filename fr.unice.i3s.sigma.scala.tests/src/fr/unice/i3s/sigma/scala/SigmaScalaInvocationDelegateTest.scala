package fr.unice.i3s.sigma.scala

import org.junit.Assert._
import org.junit.Test

import test.TestFactory

final class SigmaScalaInvocationDelegateTest extends AbstractSigmaScalaStandaloneDelegateTest {

  @Test
  def testInheritance() {
    val a = TestFactory.eINSTANCE.createA
    val b = TestFactory.eINSTANCE.createB
    val c = TestFactory.eINSTANCE.createC
    
    assertEquals("A", a.op1)
    assertEquals("B", b.op1)
    assertEquals("A", c.op1)    
  }
  
}