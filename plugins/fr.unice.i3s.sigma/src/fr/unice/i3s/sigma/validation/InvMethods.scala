package fr.unice.i3s.sigma.validation

import java.lang.reflect.Method

trait InvMethods { this: ValidationContext ⇒

  implicit class MethodSatisfiable(that: Self) {
    def satisfies(c: ⇒ Boolean) = c
    def satisfies(c: ⇒ ValidationResult)(implicit o: Overloaded1) = c match {
      case _: Error ⇒ false
      case _ ⇒ true
    }
  }

  loadMethodBasedConstraints()

  private def loadMethodBasedConstraints() {
    val invMethodPrefix = "inv"

    val methods = getClass.getMethods

    def register(method: Method) {
      val name = method.getName.drop(3)

      val check = () ⇒ {
        invoke(method) match {
          case x: Boolean ⇒ toValidationResult(name, x)
          case x: ValidationResult ⇒ x
        }
      }

      new Invariant(name, check)
    }

    methods
      .filter { m ⇒
        m.getName.startsWith(invMethodPrefix) &&
          m.getName.length > 3 &&
          m.getParameterTypes.size == 0 &&
          (classOf[ValidationResult].isAssignableFrom(m.getReturnType) ||
            classOf[Boolean].isAssignableFrom(m.getReturnType))
      }
      .foreach(register)
  }

  private def invoke(method: Method) = method.invoke(this).asInstanceOf[Any]

}