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

private[validation] object SelfGuard {
  type Guard = () ⇒ Boolean
  val NoGuard: Guard = { () ⇒ true }
}

private[validation] trait SelfGuard[T >: Null] extends OverloadHack {
  import SelfGuard._

  private var _guard: Guard = NoGuard
  protected def guard = _guard
  protected def guard_=(v: ⇒ Boolean) = _guard = { () ⇒ v }
  private[validation] def guard_=(v: Guard)(implicit o: Overloaded1) = _guard = v

  private val _self = new DynamicVariable[T](null)
  protected def self: T = _self.value

  protected def validateWithSelf[R](newself: T)(thunk: ⇒ R): Option[R] = {
    _self.withValue(newself) {
      if (!guard()) None
      else Some(thunk)
    }
  }
  protected def withSelf(newself: T)(thunk: ⇒ Unit) =
    _self.withValue(newself) {
      thunk
    }

}

class ValidationContext[T >: Null: ClassTag](val name: String) extends SelfGuard[T] with OverloadHack {
  import SelfGuard._

  type Check = () ⇒ ValidationResult

  def this() = this(getClass.getSimpleName)

  private val _constraints = Buffer[Constraint]()
  def constraints: List[Constraint] = _constraints.toList

  loadMethodBasedConstraints()

  implicit class Satisfiable(that: T) {
    def satisfies(name: Symbol): Boolean = {
      constraints.find { _.name == name } match {
        case Some(inv) ⇒ inv.validate(that) == Passed
        case None ⇒ throw new RuntimeException(s"Unresolvable constraint dependency from $this to `$name` that does not exists in context $this")
      }
    }
  }

  abstract class Constraint extends SelfGuard[T] {

    def this(name: Symbol, guard: Guard, check: Check) = {
      this()
      this.name = name
      this.guard = guard
      this.check = check
    }

    // TODO: is this possible to replace this with AutoContainment
    registerConstraint(this)

    private var _name: Symbol = _
    def name: Symbol = _name
    protected def name_=(v: Symbol) = {
      require(v != null, "Constraint name must not be null")
      require(!constraints.exists { _.name == v }, s"A constraint `$v` has been already defined")

      _name = v
    }

    private var _check: Check = {
      () ⇒ throw new RuntimeException(s"Check in constraint $name has not been defined")
    }
    protected def check = _check
    protected def check_=(v: ⇒ ValidationResult)(implicit o: Overloaded1) = _check = { () ⇒ v }
    protected def check_=(v: ⇒ Boolean)(implicit o: Overloaded2) = _check = () ⇒ toValidationResult(name, v)
    private def check_=(v: Check) = _check = v

    def validate(instance: T): ValidationResult = {
      validateWithSelf(instance) { check() } getOrElse (Cancelled)
    }

    override def toString = s"Constraint $name for ${classTag[T]} " + {
      if (guard != NoGuard) "with" else "without"
    } + " guard"
  }

  def validate(instance: T): ValidationContextResult = {
    // TODO: validate constraints
    val validations = validateWithSelf(instance) {
      constraints map { inv ⇒
        (inv.name -> inv.validate(instance))
      }
    }

    new ValidationContextResult(validations.map(_.toMap).getOrElse(Map.empty))
  }

  def fix(instance: T, fix: Fixable#Fix) {
    withSelf(instance) {
      fix.perform()
    }
  }

  override def toString = s"Validation context $name for `${classTag[T]}` with " +
    constraints.mkString(", ")

  // constraint builder

  trait ConstraintBuilder {
    def guardedBy(thunk: ⇒ Boolean): ConstraintBuilder
    def check(thunk: ⇒ ValidationResult): Constraint
    def check(thunk: ⇒ Boolean)(implicit o: Overloaded1): Constraint
  }

  private class ConstraintBuilderImpl(val name: Symbol) extends ConstraintBuilder {
    private var guard: Guard = NoGuard

    def guardedBy(thunk: ⇒ Boolean) = {
      guard = () ⇒ thunk
      this
    }

    def check(thunk: ⇒ ValidationResult) = build(() ⇒ thunk)
    def check(thunk: ⇒ Boolean)(implicit o: Overloaded1) = build(() ⇒ toValidationResult(name, thunk))

    private def build(check: Check) = {
      new Constraint(name, guard, check) {}
    }
  }

  protected def constraint(name: Symbol): ConstraintBuilder = new ConstraintBuilderImpl(name)

  // helpers

  private def registerConstraint(inv: Constraint) = _constraints += inv

  private def toValidationResult(name: Symbol, res: Boolean): ValidationResult = {
    if (res) Passed
    else Error(s"The `$name` constraint is violated on `$self`")
  }

  private def loadMethodBasedConstraints() {
    val invMethodPrefix = "inv"
    val guardMethodSuffix = "_Guard"

    val methods = getClass.getMethods

    def registerConstraint(method: Method) {
      val name = Symbol(method.getName.drop(3))

      def findGuard = methods.find { m ⇒
        m.getName == invMethodPrefix + name.name + guardMethodSuffix &&
          classOf[Boolean].isAssignableFrom(m.getReturnType) &&
          m.getParameterTypes.size == 0
      }

      val check = () ⇒ {
        invoke(method) match {
          case x: Boolean ⇒ toValidationResult(name, x)
          case x: ValidationResult ⇒ x
        }
      }

      val guard = findGuard match {
        case Some(m) ⇒ () ⇒ {
          invoke(m) match {
            case x: Boolean ⇒ x
          }
        }
        case None ⇒ NoGuard
      }

      new Constraint(name, guard, check) {}
    }

    methods
      .filter { m ⇒
        m.getName.startsWith(invMethodPrefix) &&
          !m.getName.endsWith(guardMethodSuffix) &&
          m.getName.length > 3 &&
          m.getParameterTypes.size == 0 &&
          (classOf[ValidationResult].isAssignableFrom(m.getReturnType) ||
            classOf[Boolean].isAssignableFrom(m.getReturnType))
      }
      .foreach(registerConstraint)
  }

  private def invoke(method: Method) = method.invoke(ValidationContext.this).asInstanceOf[Any]

}