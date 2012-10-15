package fr.unice.i3s.sigma.scala

import scala.collection.JavaConversions._
import fr.unice.i3s.sigma.delegates.SigmaInvocationDelegate
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EParameter

final class SigmaScalaInvocationDelegate(operation: EOperation,
  domain: SigmaScalaDelegateDomain) extends SigmaInvocationDelegate(operation, domain) {

  override def getExpectedMethodSignature() = {
    val args = target.getEParameters match {
      case c if c.length > 0 =>
        c.map(p => p.getName + " : " + domain.elementTypeName(p))
          .mkString(", ", ", ", "")
      case _ => ""
    }

    "def %s%s(self : %s%s) : %s" format (
      getDelegateMethodName,
      domain.classifierTypeParameters(target.getEContainingClass()),
      domain.classifierTypeName(target.getEContainingClass()),
      args,
      domain.elementTypeName(target))
  }

}