package fr.unice.i3s.sigma.validation

sealed trait ValidationResult

object Passed extends ValidationResult

object Cancelled extends ValidationResult

case class Warning(val message: String, val fixes: Fix*) extends ValidationResult

case class Error(val message: String, val fixes: Fix*) extends ValidationResult

class ValidationContextResult(val results: Map[String, ValidationResult]) {
  def cancelled: Boolean = results == Map.empty
  def passed: Boolean = results forall { case (_, inv) ⇒ inv == Passed }
  def violates(constraint: String): Boolean =
    results.get(constraint).map(_ != Passed) getOrElse (false)
}
