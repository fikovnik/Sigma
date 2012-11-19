package fr.unice.i3s.sigma.scala

import org.eclipse.emf.ecore.EObject
import fr.unice.i3s.sigma.core.ISigmaQuickFix

abstract sealed class ValidationResult {

}

case class OK extends ValidationResult
case class Info(message: String) extends ValidationResult
case class Warning[T <: EObject](message: String, quickFixes: QuickFix[T]*) extends ValidationResult
case class Error(message: String) extends ValidationResult
case class Cancel extends ValidationResult
//, guard: Option[T => Boolean] = None, description: Option[String] = None
case class QuickFix[T <: EObject](label: String)(val action: T => Unit)(implicit val m: Manifest[T])

private[scala] class SigmaScalaQuickFix(fix: QuickFix[EObject]) extends ISigmaQuickFix {
  // TODO: fix asInstanceOf
  def getContextClass() = fix.m.erasure.asInstanceOf[Class[_ <: EObject]]

  def getLabel() = fix.label

  // TODO: add description
  def getDescription() = ""

  def validate(self: EObject) = fix.m.erasure.isAssignableFrom(self.getClass)

  def execute(self: EObject) = fix.action(self)
}