package fr.unice.i3s.sigma.m2t

import Text._

object Decorators {

  def identity: Decorator = (str: String) ⇒ str  
  
  def indentText(num: Int) = (text: String) ⇒ {
    val prefix = " " * num
    val nls = text.count(_ == endlc)
    val lines = text.split(endl)

    (lines map (prefix + _) mkString (endl)) + (
      // the problem is that otherwise we might have eaten the last endl:
      // scala> "a\nb\nc\n".split("\n")
      // res2: Array[String] = Array(a, b, c)
      // this line is unindented!
      if (nls + 1 != lines.size) endl else ""
    )
  }

  def surroundText(str: String): Decorator =
    surroundText(str, str)

  def surroundText(begin: String, end: String): Decorator = {
    text ⇒ begin + text + end
  }

  def relaxedNewLines: Decorator = { text ⇒
    // do not eat endls
    if (text.trim == "") text
    // do not add extra endls
    else if (text.last == endlc) text
    else text + endl
  }

  def stripWhitespace(tabSize: Int, keepNewLine: Boolean = false): Decorator = { text ⇒
    val expandedText = text replace ("\t", " " * tabSize)
    var lines = (expandedText split endl).toList

    if (lines.size < 2) {
      // do not eat a endls and single lines
      text
    } else {
      // expand tabs
      // split

      if (!lines.isEmpty) {
        // how shall we treat the last line in block like?
        // """
        // bla bla bla
        // """
        // if keepNewLine == true we add a new line
        var addNL = false
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
          addNL = keepNewLine
        }

        // drop empty lines (either empty or full of whitespace chars)
        lines = lines collect {
          case line if line.trim.isEmpty ⇒ ""
          case line ⇒ line
        }

        // drop prefix it and concatenate
        (lines map { _.drop(prefix) } mkString (endl)) + (if (addNL) endl else "")
      } else {
        ""
      }
    }
  }
}
