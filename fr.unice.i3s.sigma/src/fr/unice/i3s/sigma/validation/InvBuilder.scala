package fr.unice.i3s.sigma.validation

trait InvBuilder { this: ValidationContext ⇒

  trait ConstraintBuilder {
    def guardedBy(thunk: ⇒ Boolean): ConstraintBuilder
    def check(thunk: ⇒ ValidationResult): Constraint
    def check(thunk: ⇒ Boolean)(implicit o: Overloaded1): Constraint
  }

  private class ConstraintBuilderImpl(val name: String) extends ConstraintBuilder {
    type Guard = () ⇒ Boolean
    final val NoGuard = () ⇒ true

    private var guard: Guard = NoGuard

    def guardedBy(thunk: ⇒ Boolean) = {
      guard = () ⇒ thunk
      this
    }

    def check(thunk: ⇒ ValidationResult) = build { () ⇒
      if (guard()) {
        thunk
      } else {
        Cancelled
      }
    }
    def check(thunk: ⇒ Boolean)(implicit o: Overloaded1) = build { () ⇒
      if (guard()) {
        toValidationResult(name, thunk)
      } else {
        Cancelled
      }
    }

    private def build(check: Check) = {
      new Constraint(name, check) {}
    }
  }

  protected def constraint(name: String): ConstraintBuilder = new ConstraintBuilderImpl(name)

}