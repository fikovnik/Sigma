package fr.unice.i3s.sigma.scala

import fr.unice.i3s.sigma.scala.utils._
import fr.unice.i3s.sigma.delegates.SigmaInvocationDelegate
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EParameter

final class SigmaScalaInvocationDelegate(operation: EOperation,
  domain: SigmaScalaDelegateDomain) extends SigmaInvocationDelegate(operation, domain) {

  override def getMethodSignature: String = {
    val selfType = domain.classifierTypeName(target.getEContainingClass())
    val name = getMethodName
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