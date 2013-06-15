package fr.unice.i3s.sigma.validation

import scala.collection.mutable.Buffer

sealed trait ValidationResult

object Passed extends ValidationResult {
  override def toString = "Passed"
}

object Cancelled extends ValidationResult {
  override def toString = "Cancelled"
}

case class QuickFix(title: String, perform: () ⇒ Any) {
  override def toString = s"QuickFix `$title`"
}

sealed trait Fixable { this: ValidationResult ⇒
  private val _quickFixes = Buffer[QuickFix]()
  def quickFixes: Seq[QuickFix] = _quickFixes.toSeq

  def quickFix(title: String)(perform: ⇒ Any): this.type = {
    _quickFixes += QuickFix(title, () ⇒ perform)
    this
  }
}

object Warning {
  def apply(message: String): Warning = new Warning(message)
  def unapply(that: Warning) = Some((that.message, that.quickFixes))
}

class Warning(val message: String) extends ValidationResult with Fixable {
  override def toString = s"Warning(${quickFixes.size} fixes): $message"
}

object Error {
  def apply(message: String): Error = new Error(message)
  def unapply(that: Error) = Some((that.message, that.quickFixes))
}

class Error(val message: String) extends ValidationResult with Fixable {
  override def toString = s"Error(${quickFixes.size} fixes): $message"
}

class ValidationContextResult(val results: Map[Symbol, ValidationResult]) {
  def cancelled: Boolean = results == Map.empty
  def passed: Boolean = results forall { case (_, inv) ⇒ inv == Passed }
  def violates(constraint: Symbol): Boolean =
    results.get(constraint).map(_ != Passed) getOrElse (false)

  override def toString =
    if (results.isEmpty) Cancelled.toString
    else results map { case (name, inv) ⇒ s"$name - $inv" } mkString ("\n")
}
