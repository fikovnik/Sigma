package fr.unice.i3s.sigma.test.scalatest

import org.scalatest.matchers.BeMatcher
import org.scalatest.matchers.MatchResult
import fr.unice.i3s.sigma.m2t.TextTemplateTesting
import fr.unice.i3s.sigma.m2t.Text

trait TextMatchers {
  
  class TextMatcher(target: String) extends BeMatcher[AnyRef] {
    def apply(source: AnyRef) =
      
      // TODO: use https://code.google.com/p/java-diff-utils to create a diff
      // or JMeld to visualize the difference
      MatchResult(
        source.toString == target,
        s"'${source.toString}' was not '$target'",
        s"'${source.toString}' was '$target'")
  }

  def text(target: String) = new TextMatcher(target)
}  


object TextMatchers extends TextMatchers