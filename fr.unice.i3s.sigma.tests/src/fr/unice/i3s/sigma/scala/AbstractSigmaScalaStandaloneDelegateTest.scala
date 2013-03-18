package fr.unice.i3s.sigma.scala

import org.junit.BeforeClass

import fr.unice.i3s.sigma.delegates.SigmaDelegateDomain;

object AbstractSigmaScalaStandaloneDelegateTest {

  @BeforeClass
  def registerDelegates() {
    SigmaDelegateDomain.installGlobally();
  }

}

abstract class AbstractSigmaScalaStandaloneDelegateTest {

}