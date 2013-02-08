package fr.unice.i3s.sigma.scala.mtt

import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import org.junit.runner.RunWith
import TextSection._
import org.scalatest.junit.JUnitRunner
import java.io.StringWriter

@RunWith(classOf[JUnitRunner])
class TextFileSpec extends FlatSpec with MustMatchers {

  "Text" must "append simple text" in {

    val text = new Text
    text append "hello world"
    text.toString must be === "hello world"
  }

  it must "support section" in {

    val text = new Text
    text append "a"
    val sub1 = text.section
    sub1 append "b"
    val sub2 = sub1.section
    sub2 append "c"
    text append "f"
    sub1 append "e"
    sub2 append "d"

    text.toString must be === "abcdef"
  }

  it must "support many section" in {

    val text = new Text
    text.section append "a"
    text.section append "b"
    text.section append "c"
    text.section append "d"
    text.section append "e"
    text.section append "f"

    text.toString must be === "abcdef"
  }

  it must "support decorators" in {
    val text = new Text
    val d1 = (s: String) => s"($s)"
    val d2 = (s: String) => s"[$s]"
    val d3 = (s: String) => s"{$s}"

    (text withDecorator d1) {
      text append "a"
      text append "b"

      (text withDecorator d2) {
        val sub1 = text.section

        (sub1 withDecorator d3) {
          sub1 append "c"
        }

        text append "d"

        (text withDecorator d3) {
          text append "e"
        }
      }
    }
    text.toString must be === "(a)(b)([{c}])([d])([{e}])"
  }

  it must "support block decorators" in {
    val text = new Text
    val d1 = (s: String) => s"($s)"
    val d2 = (s: String) => s"[$s]"
    val d3 = (s: String) => s"{$s}"

    text.withBlockDecorator(d1) {
      text append "a"
      text append "b"

      text.withBlockDecorator(d2) {
        val sub1 = text.section

        text append "d"

        sub1.withBlockDecorator(d3) {
          sub1 append "c"
        }

        text.withBlockDecorator(d3) {
          text append "e"
        }
      }
    }

    text.toString must be === "(ab[{c}d{e}])"
  }

  it must "support indent" in {
    val text = new Text
    text << "Text"
    text indent {
      text << "indent"
      text << "indent2" << endl << "indent3"
      text indent {
        text << "indent4" << endl << "indent5"
        text.indentBy(1) {
          text << "indent6"
        }
      }
      text << "indent7"
    }
    text << "Text"

    text.toString must be ===
      """|Text
         |  indentindent2
         |  indent3
         |    indent4
         |    indent5
         |     indent6
         |  indent7
         |Text""".stripMargin
  }

  it must "support indented sections" in {
    val text = new Text
    var sec: Text = null
    text << "Text"
    text indent {
      text << "indent"
      text << "indent2" << endl << "indent3"
      text indent {
        sec = text.section
        text << "indent4" << endl << "indent5"
        text.indentBy(1) {
          text << "indent6"
        }
      }
      text << "indent7"
    }
    text << "Text"

    text.toString must be ===
      """|Text
         |  indentindent2
         |  indent3
         |    indent4
         |    indent5
         |     indent6
         |  indent7
         |Text""".stripMargin

    sec << "indent8" << endl

    text.toString must be ===
      """|Text
         |  indentindent2
         |  indent3
         |    indent8
         |    indent4
         |    indent5
         |     indent6
         |  indent7
         |Text""".stripMargin
  }

  it must "output to writer" in {
    val text = new Text
    val out = new StringWriter
    text << "a" >> out

    out.toString must be === "a"
  }
}