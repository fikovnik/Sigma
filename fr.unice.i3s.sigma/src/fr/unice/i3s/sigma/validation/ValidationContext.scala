package fr.unice.i3s.sigma.validation

import scala.util.DynamicVariable
import org.eclipse.emf.ecore.EObject
import scala.reflect.{ ClassTag, classTag }

private[validation] trait SelfGuard[T >: Null] {
  private var _guard: Unit ⇒ Boolean = { _ ⇒ true }
  def guard = _guard
  def guard_=(g: ⇒ Boolean) = _guard = { _ ⇒ g }

  private val _self = new DynamicVariable[T](null)
  protected def self: T = _self.value

  def validateWithSelf[R](newself: T)(thunk: ⇒ R): Option[R] = {
    _self.withValue(newself) {
      if (!guard()) None
      else Some(thunk)
    }
  }

}

abstract class ValidationContext[T >: Null: ClassTag](val name: String) extends SelfGuard[T] {
  class Overloaded1
  implicit val overload1 = new Overloaded1

  private val constraints = collection.mutable.Map[Symbol, Constraint]()

  def this() = this(getClass.getSimpleName)

  object Constraint {
    def apply(name: Symbol): Constraint = {
      require(name != null, "Constraint name must not be null")
      require(!constraints.contains(name), s"A constraint $name has been already defined")

      val inv = new Constraint(name)
      constraints += (name -> inv)
      inv
    }
  }

  class Constraint(val name: Symbol) extends SelfGuard[T] {
    private var _check: Unit ⇒ ValidationResult = { _ ⇒ throw new RuntimeException(s"Check in constraint $name has not been defined") }
    def check = _check
    def check_=(g: ⇒ ValidationResult) = _check = { _ ⇒ g }
    def check_=(g: ⇒ Boolean)(implicit o: Overloaded1) = _check = { _ ⇒
      if (g) Passed
      else Error(s"The `$name` constraint is violated on `$self`")
    }

    def apply(config: this.type ⇒ Unit): this.type = {
      config(this)
      this
    }

    def validate(instance: T): ValidationResult = {
      validateWithSelf(instance) { check() } getOrElse (Cancelled)
    }
  }

  def validate(instance: T): ValidationContextResult = {
    val validations = validateWithSelf(instance) {
      constraints map {
        case (name, inv) ⇒ (name.name -> inv.validate(instance))
      }
    }

    new ValidationContextResult(validations.map(_.toMap).getOrElse(Map.empty))
  }

  implicit class Satisfiable(that: T) {
    def satisfies(name: Symbol): Boolean = {
      constraints.get(name) match {
        case Some(inv) ⇒ inv.validate(that) == Passed
        case None ⇒ throw new RuntimeException(s"Unresolvable constraint dependency from $this to `$name` that does not exists in context $this")
      }
    }
  }

  override def toString = s"Validation context $name for class: ${classTag[T]}"

}