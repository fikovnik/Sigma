package fr.unice.i3s.sigma.delegate

import org.junit.BeforeClass

object AbstractSigmaScalaStandaloneDelegateTest {

  @BeforeClass
  def registerDelegates() {
    SigmaDelegateDomain.installGlobally();
  }

}

abstract class AbstractSigmaScalaStandaloneDelegateTest {

}