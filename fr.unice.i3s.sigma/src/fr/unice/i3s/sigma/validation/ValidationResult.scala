package fr.unice.i3s.sigma.validation

sealed trait ValidationResult

object Passed extends ValidationResult {
  override def toString = "Passed"
}

object Cancelled extends ValidationResult {
  override def toString = "Cancelled"
}

case class Warning(val message: String, val fixes: Fix*) extends ValidationResult {
  override def toString = s"Warning(${fixes.size} fixes): $message"
}

case class Error(val message: String, val fixes: Fix*) extends ValidationResult {
  override def toString = s"Error(${fixes.size} fixes): $message"
}

class ValidationContextResult(val results: Map[String, ValidationResult]) {
  def cancelled: Boolean = results == Map.empty
  def passed: Boolean = results forall { case (_, inv) ⇒ inv == Passed }
  def violates(constraint: String): Boolean =
    results.get(constraint).map(_ != Passed) getOrElse (false)

  override def toString =
    if (results.isEmpty) Cancelled.toString
    else results map { case (name, inv) ⇒ s"$name - $inv" } mkString ("\n")
}
