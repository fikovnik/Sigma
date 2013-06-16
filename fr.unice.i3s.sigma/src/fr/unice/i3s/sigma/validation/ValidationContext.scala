package fr.unice.i3s.sigma.validation

import scala.util.DynamicVariable
import org.eclipse.emf.ecore.EObject
import scala.reflect.{ ClassTag, classTag }
import java.lang.reflect.Method
import scala.collection.mutable.Buffer
import fr.unice.i3s.sigma.internal.OverloadHack

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

trait ValidationContext extends SelfVariable with Guardable with OverloadHack {
  override type Self >: Null <: EObject
  type Check = () ⇒ ValidationResult

  implicit val selfTag: ClassTag[Self]

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
        Map.empty
      }

      new ValidationContextResult(validations.toMap)
    }
  }

  def fix(instance: Self, fix: QuickFix) {
    withSelf(instance) {
      fix.perform()
    }
  }

  override def toString = s"Validation context ${getClass.getSimpleName} for $selfTag: " +
    constraints.map(_.name).mkString(", ")

  // helpers

  protected[validation] def registerConstraint(inv: Constraint) = {
    require(inv != null, "Constraint name must not be null")
    require(!constraints.exists { _.name == inv.name }, s"A constraint ${inv.name} has been already defined")

    _constraints += inv
  }

  protected[validation] def toValidationResult(name: String, res: Boolean): ValidationResult = {
    if (res) Passed
    else Error(s"The `$name` constraint is violated on `$self`")
  }

  case class Constraint(name: String, check: Check) extends SelfVariable {
    type Self = ValidationContext#Self

    // TODO: is this possible to replace this with AutoContainment
    registerConstraint(this)

    def validate(instance: Self): ValidationResult = {
      withSelf(instance) { check() }
    }

    override def toString = s"Constraint $name for $selfTag"
  }

  implicit class Satisfiable(that: Self) {
    def satisfies(name: String): Boolean = {
      constraints.find { _.name == name } match {
        case Some(inv) ⇒ inv.validate(that) == Passed
        case None ⇒ throw new RuntimeException(s"Unresolvable constraint dependency from $this to `$name` that does not exists in context $this")
      }
    }
  }
}