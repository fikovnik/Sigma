package fr.unice.i3s.sigma.scala

import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate.Factory

final class SigmaScalaInvocationDelegateFactory extends Factory {

  override def createInvocationDelegate(eOperation: EOperation) = {
    new SigmaScalaInvocationDelegate(eOperation, SigmaScalaDelegateDomain.instance)
  }

}