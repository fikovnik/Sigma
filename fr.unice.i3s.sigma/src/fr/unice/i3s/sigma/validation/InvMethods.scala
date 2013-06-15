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

      new Constraint(name, check)
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

  private def invoke(method: Method) = method.invoke(this).asInstanceOf[Any]

}