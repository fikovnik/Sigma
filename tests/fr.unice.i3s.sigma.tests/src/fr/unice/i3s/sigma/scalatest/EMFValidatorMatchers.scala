package fr.unice.i3s.sigma.scalatest

import org.scalatest.matchers.Matcher
import org.eclipse.emf.ecore.EObject
import org.scalatest.matchers.MatchResult
import org.scalatest.matchers.BePropertyMatcher
import org.scalatest.matchers.BePropertyMatchResult
import fr.unice.i3s.sigma.support.EMFScalaSupport

trait EMFValidatorMatchers extends EMFScalaSupport {

  class ValidBePropertyMatcher extends BePropertyMatcher[EObject] {
    def apply(left: EObject) = BePropertyMatchResult(left.sIsValid, "valid")
  }

  def violate(right: String): Matcher[EObject] =
    new Matcher[EObject] {
      def apply(left: EObject): MatchResult = {
        MatchResult(
          left sViolatesConstraint right,
          "object `%s' did not violate `%s' constaint" format (left, right),
          "object `%s' violated `%s' constaint" format (left, right))
      }
    }

  def violateAny(right: String): Matcher[EObject] =
    new Matcher[EObject] {
      def apply(left: EObject): MatchResult = {
        MatchResult(
          left sViolatesConstraintAny right,
          "object `%s' did not violate `%s' constaint" format (left, right),
          "object `%s' violated `%s' constaint" format (left, right))
      }
    }

  def valid = new ValidBePropertyMatcher
}