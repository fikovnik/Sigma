package fr.unice.i3s.sigma.delegates

import java.lang.reflect.Method
import org.eclipse.emf.ecore.EClass
import fr.unice.i3s.sigma.validation.ValidationResult
import org.eclipse.emf.ecore.EObject

final class SigmaValidationDelegate(
  val target: EClass,
  val constraint: String,
  val delegateMethod: Method,
  val domain: SigmaDelegateDomain) {

  def validate(target: EObject): ValidationResult =
    domain.safeDynamicInvoke(delegateMethod, target) {
      val ret = delegateMethod.invoke(null /* static */ , target)
      domain.toValidationResult(ret, target, this)
    }

}