package fr.unice.i3s.sigma.validation

import org.eclipse.emf.ecore.EValidator
import org.eclipse.emf.common.util.DiagnosticChain
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.ecore.EClass
import scala.reflect.{ classTag, ClassTag }
import collection.mutable.{ HashMap, MultiMap, Set }

class SigmaEValidator extends EValidator {

  private val contexts = new HashMap[Class[_], Set[ValidationContext]] with MultiMap[Class[_], ValidationContext]

  def validate(eObject: EObject, diagnostics: DiagnosticChain, context: java.util.Map[Object, Object]) = {
    // not supported
    true
  }

  def validate(eDataType: EDataType, value: Any, diagnostics: DiagnosticChain, context: java.util.Map[Object, Object]): Boolean = {
    // not supported
    true
  }

  def validate(eClass: EClass, eObject: EObject, diagnostics: DiagnosticChain, context: java.util.Map[Object, Object]): Boolean = {
    println(eObject)
    true
  }

  def register[T >: Null <: EObject : ClassTag](context: ValidationContext) {
    contexts.addBinding(classTag[T].runtimeClass, context)
  }

}