package fr.unice.i3s.sigma.validation

import scala.collection.mutable.Buffer

sealed trait ValidationResult

object Passed extends ValidationResult {
  override def toString = "Passed"
}

object Cancelled extends ValidationResult {
  override def toString = "Cancelled"
}

sealed trait Fixable { this: ValidationResult ⇒
  private val _fixes = Buffer[Fix]()
  def fixes: List[Fix] = _fixes.toList

  private var _message: String = _
  def message: String = _message
  protected def message_=(v: String) = _message = v

  private class Overloaded1
  private implicit val overload1 = new Overloaded1

  class Fix {
    def this(title: String, perform: () ⇒ Unit) = {
      this()
      this.title = title
      this.perform = perform
    }

    _fixes += this

    private var _title: String = _
    def title: String = _message
    protected def title_=(v: String) = _message = v

    private var _perform: () ⇒ Unit = _
    def perform: () ⇒ Unit = _perform
    protected def perform_=(v: ⇒ Unit) = _perform = { () ⇒ v }
    private def perform_=(v: () ⇒ Unit)(implicit o: Overloaded1) = _perform = v

    override def toString = s"Fix `$title` for `${Fixable.this}`"
  }
}

object Warning {
  def apply(message: String): Warning = new Warning(message)
}

class Warning extends ValidationResult with Fixable {
  def this(message: String) = {
    this()
    this.message = message
  }
  override def toString = s"Warning(${fixes.size} fixes): $message"
}

object Error {
  def apply(message: String): Error = new Error(message)
}

class Error extends ValidationResult with Fixable {
  def this(message: String) = {
    this()
    this.message = message
  }
  override def toString = s"Error(${fixes.size} fixes): $message"
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
