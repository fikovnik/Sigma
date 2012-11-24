package fr.unice.i3s.sigma.scala

import fr.unice.i3s.sigma.scala.utils._
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate.Factory
import fr.unice.i3s.sigma.delegates.SigmaInvocationDelegateFactory

final class SigmaScalaInvocationDelegateFactory extends SigmaInvocationDelegateFactory {

  override def getDomain = SigmaScalaDelegateDomain.instance

  override def doCreateInvocationDelegate(target: EOperation) =
    new SigmaScalaInvocationDelegate(target, getDomain)

}