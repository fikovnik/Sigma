package fr.unice.i3s.sigma.validation

import scala.util.DynamicVariable
import org.eclipse.emf.ecore.EObject
import scala.reflect.{ ClassTag, classTag }
import java.lang.reflect.Method
import scala.collection.mutable.Buffer

trait OverloadHack {
  class Overloaded1
  class Overloaded2
  implicit val overload1 = new Overloaded1
  implicit val overload2 = new Overloaded2
}

trait Guardable {
  def guardedBy(g: Boolean) = g

  implicit class CheckedBoolean(that: Boolean) {
    def check(g: ⇒ ValidationResult) =
      if (that) g
      else Cancelled
  }
}

private[validation] trait SelfVariable {
  type Self >: Null

  private val _self = new DynamicVariable[Self](null)
  protected def self: Self = _self.value

  protected def withSelf[R](newself: Self)(thunk: ⇒ R): R =
    _self.withValue(newself) {
      thunk
    }

}

class ValidationContext(val name: String) extends SelfVariable with Guardable with OverloadHack {
  override type Self >: Null <: EObject
  type Check = () ⇒ ValidationResult

  case class Constraint(name: Symbol, check: Check) extends SelfVariable {
    type Self = ValidationContext#Self

    // TODO: is this possible to replace this with AutoContainment
    registerConstraint(this)

    def validate(instance: Self): ValidationResult = {
      withSelf(instance) { check() }
    }

    override def toString = s"Constraint $name for $selfClassTag"
  }

  def this() = this(getClass.getSimpleName)

  protected[validation] implicit val selfClassTag: ClassTag[Self] = implicitly

  private val _constraints = Buffer[Constraint]()

  def guard: Boolean = true

  def constraints: List[Constraint] = _constraints.toList

  def validate(instance: Self): ValidationContextResult = {
    withSelf(instance) {
      val validations = if (guard) {
        constraints map { inv ⇒
          (inv.name -> inv.validate(instance))
        }
      } else {
        constraints.map((_.name -> Cancelled)).toMap
      }

      new ValidationContextResult(validations.toMap)
    }
  }

  def fix(instance: Self, fix: QuickFix) {
    withSelf(instance) {
      fix.perform()
    }
  }

  override def toString = s"Validation context $name for $selfClassTag with " +
    constraints.mkString(", ")

  // helpers

  protected[validation] def registerConstraint(inv: Constraint) = {
    require(inv != null, "Constraint name must not be null")
    require(!constraints.exists { _.name == inv.name }, s"A constraint ${inv.name} has been already defined")

    _constraints += inv
  }

  protected[validation] def toValidationResult(name: Symbol, res: Boolean): ValidationResult = {
    if (res) Passed
    else Error(s"The `$name` constraint is violated on `$self`")
  }

  implicit class Satisfiable(that: Self) {
    def satisfies(name: Symbol): Boolean = {
      constraints.find { _.name == name } match {
        case Some(inv) ⇒ inv.validate(that) == Passed
        case None ⇒ throw new RuntimeException(s"Unresolvable constraint dependency from $this to `$name` that does not exists in context $this")
      }
    }
  }
}