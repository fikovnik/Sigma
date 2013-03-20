package fr.unice.i3s.sigma.validation

import scala.util.DynamicVariable
import org.eclipse.emf.ecore.EObject

private[validation] trait GuardedSelf[T >: Null] {
  private var _guard: Unit ⇒ Boolean = { _ ⇒ true }
  protected def guard = _guard
  protected def guard_=(g: ⇒ Boolean) = _guard = { _ ⇒ g }

  private val _self = new DynamicVariable[T](null)
  protected def self: T = _self.value

  def validateWithSelf[R](newself: T)(thunk: ⇒ R): Option[R] = {
    _self.withValue(newself) {
      if (!guard()) None
      else Some(thunk)
    }
  }

}

abstract class ValidationContext[T >: Null](val name: String) extends GuardedSelf[T] {
  class Overloaded1
  implicit val overload1 = new Overloaded1

  abstract class Constraint(val name: String) extends GuardedSelf[T] {
    require(name != null && !name.trim.isEmpty, "Constraint name must not be null")
    require(!constraints.contains(name), s"A constraint $name has been already defined")

    constraints += (name -> this)

    private var _check: Unit ⇒ ValidationResult = { _ ⇒ throw new RuntimeException(s"Check in constraint $name has not been defined") }
    protected def check = _check
    protected def check_=(g: ⇒ ValidationResult) = _check = { _ ⇒ g }
    protected def check_=(g: ⇒ Boolean)(implicit o: Overloaded1) = _check = { _ ⇒
      if (g) Passed
      else Error(s"The `$name` constraint is violated on `$self`")
    }

    def validate(instance: T): ValidationResult = {
      validateWithSelf(instance) { check() } getOrElse (Cancelled)
    }
  }

  def this() = this(getClass.getSimpleName)

  def validate(instance: T): ValidationContextResult = {
    val validations = validateWithSelf(instance) {
      constraints map {
        case (name, inv) ⇒ (name -> inv.validate(instance))
      }
    }

    new ValidationContextResult(validations.map(_.toMap).getOrElse(Map.empty))
  }

  private val constraints = new collection.mutable.HashMap[String, Constraint]

  implicit class Satisfiable(that: T) {
    def satisfies(c: Constraint): Boolean = c.validate(that) == Passed
  }

}