package fr.unice.i3s.sigma.delegates

import scala.collection.JavaConversions._
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EParameter
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.InternalEObject
import java.lang.reflect.Method
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import org.eclipse.emf.ecore.ETypedElement

class SigmaInvocationDelegate(
  val operation: EOperation,
  delegateMethod: Method,
  domain: SigmaDelegateDomain) extends AbstractSigmaDelegate(delegateMethod, domain) with InvocationDelegate with EcorePackageScalaSupport {

  override def dynamicInvoke(targetObject: InternalEObject, arguments: EList[_]): Object = {
    domain.safeDynamicInvoke(delegateMethod, targetObject) {
      // prepend the self
      val args = (targetObject +: arguments).toArray
      // process the args
      for ((arg, idx) ← args.drop(1).zipWithIndex) {
        args(idx) = processArgument(operation.eParameters(idx), arguments(idx))
      }

      // invoke
      val ret = delegateMethod.invoke(null /* static method */ , args)
      domain.processResult(operation, ret).asInstanceOf[Object]
    }
  }

  protected def processArgument(eType: ETypedElement, arg: Any): Any = {
    if (eType.isMany) {
      arg match {
        case c: EList[_] ⇒ asScalaBuffer(c)
        case _ ⇒ arg
      }
    } else {
      arg
    }
  }
}