package fr.unice.i3s.sigma.scala

import org.junit.BeforeClass

object AbstractSigmaScalaStandaloneDelegateTest {

  @BeforeClass
  def registerDelegates() {
    SigmaScalaDelegateDomain.installGlobally();
  }

}

abstract class AbstractSigmaScalaStandaloneDelegateTest {

}