package fr.unice.i3s.sigma.scala.mtt

import TextSection._

object Decorators {

  def indentText(num: Int) = (text: String) ⇒ {
    val prefix = " " * num
    text.split(endl).map(prefix + _).mkString(endl)
  }

  def surroundText(str: String): Decorator =
    surroundText(str, str)

  def surroundText(begin: String, end: String): Decorator = {
    text ⇒ begin + text + end
  }

  def stripWhitespace(tabSize: Int): Decorator = { text ⇒
    // don't eat new lines
    if (text == endl) {
      text
    } else {
      // expand tabs
      val expandedText = text replace ("\t", " " * tabSize)
      // split
      var lines = (expandedText split endl).toList

      if (!lines.isEmpty) {
        // longest whitespace prefix of non-empty lines
        val prefix = lines
          .filter(!_.trim.isEmpty)
          .map(_.segmentLength(_.isWhitespace, 0))
          .min

        // is the input from the following like scala block:
        // """
        // bla bla bla
        // """
        if (lines.size >= 3
          && lines.head == ""
          && lines.last.segmentLength(_.isWhitespace, 0) == prefix) {
          lines = lines drop (1)
          lines = lines dropRight (1)
        }

        // drop empty lines (either empty or full of whitespace chars)
        lines = lines collect {
          case line if line.trim.isEmpty ⇒ ""
          case line ⇒ line
        }

        // drop prefix it and concatenate
        lines map { _.drop(prefix) } mkString (endl)
      } else {
        ""
      }
    }
  }
}
