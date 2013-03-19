package fr.unice.i3s.sigma.delegate

import org.eclipse.emf.ecore.util.Diagnostician
import org.junit.Assert._
import org.junit.Test

import test.TestFactory

final class SigmaScalaValidationDelegateTest extends AbstractSigmaScalaStandaloneDelegateTest {
  
  @Test
  def testSimpleValidation() {
    val d = TestFactory.eINSTANCE.createD
    val validator = Diagnostician.INSTANCE
    val diagnostic = validator.validate(d)
    
    assertTrue(diagnostic.getChildren.size == 1)
    assertTrue(diagnostic.getChildren.get(0).getMessage.startsWith("The 'AlwaysFalseInvariant' constraint is violated"))
  }
  
}