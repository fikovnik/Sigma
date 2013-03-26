package fr.unice.i3s.sigma.validation

import scala.collection.mutable.Buffer

sealed trait ValidationResult

object Passed extends ValidationResult {
  override def toString = "Passed"
}

object Cancelled extends ValidationResult {
  override def toString = "Cancelled"
}

trait Fixable { this: ValidationResult ⇒
  private[validation] val fixes = Buffer[Fix]()

  def apply(config: (this.type) ⇒ Unit): this.type = {
    config(this)
    this
  }

  def quickFix(title: String)(action: ⇒ Unit): Fix = {
    val fix = new Fix(title, { () ⇒ action })
    fixes += fix
    fix
  }
}

case class Warning[T](val message: String) extends ValidationResult with Fixable {
  override def toString = s"Warning(${fixes.size} fixes): $message"
}

case class Error(val message: String) extends ValidationResult with Fixable {
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
