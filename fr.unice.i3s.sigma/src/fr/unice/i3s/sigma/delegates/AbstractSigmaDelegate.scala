package fr.unice.i3s.sigma.delegates

import java.lang.reflect.Method

abstract class AbstractSigmaDelegate(val delegateMethod: Method, val domain: SigmaDelegateDomain) {

  require(delegateMethod != null)

}