package fr.unice.i3s.sigma.test.scalatest

import fr.unice.i3s.sigma.validation.ValidationResult
import org.scalatest.matchers.BeMatcher
import org.scalatest.matchers.MatchResult
import fr.unice.i3s.sigma.validation.ValidationResult
import fr.unice.i3s.sigma.validation.ValidationResult
import org.scalatest.matchers.Matcher
import fr.unice.i3s.sigma.validation.Passed

trait ValidationMatchers {

  val pass = Matcher { (left: ValidationResult) ⇒
    MatchResult(left == Passed, "validation passed", "validation did not pass")
  }

}

object ValidationMatchers extends ValidationMatchers