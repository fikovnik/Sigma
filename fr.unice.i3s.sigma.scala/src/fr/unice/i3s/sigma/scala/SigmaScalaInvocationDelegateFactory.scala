package fr.unice.i3s.sigma.scala

import fr.unice.i3s.sigma.scala.utils._
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate.Factory
import fr.unice.i3s.sigma.delegates.SigmaInvocationDelegateFactory
import fr.unice.i3s.sigma.scala.SigmaScalaDelegateDomain.{ instance => domain }

final class SigmaScalaInvocationDelegateFactory extends SigmaInvocationDelegateFactory(domain) {

  override def getExpectedMethodSignature(target: EOperation): String = {
    val selfType = domain.classifierTypeName(target.getEContainingClass())
    val name = getExpectedMethodName(target)
    val typeParams = domain.classifierTypeParameters(target.getEContainingClass())
    val returnType = domain.elementTypeName(target)

    val argNames = "self" :: (target.getEParameters map (_.getName))
    val argTypes = selfType :: (target.getEParameters map (domain.elementTypeName(_)))
    val args = (argNames zip argTypes) map {
      case (name, typeName) => s"$name: $typeName"
    }

    // TODO: exception

    s"def $name${typeParams}(${args.mkString(", ")}): $returnType"
  }

}