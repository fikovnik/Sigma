package fr.unice.i3s.sigma.scala.mtt

import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.io.StringWriter

@RunWith(classOf[JUnitRunner])
class TextSpec extends FlatSpec with MustMatchers {

  // TODO: where to put this so it can be accessed everywhere?
  val endl = System.getProperty("line.separator")

  "Text" must "append simple text" in {

    val text = Text()
    text append "hello world"
    text.toString must be === "hello world"
  }

  it must "support sections" in {

    val text = Text()
    text append "a"
    val sub1 = text.startSection
    sub1 append "b"
    val sub2 = sub1.startSection
    sub2 append "c"
    text append "f"
    sub1 append "e"
    sub2 append "d"

    text.toString must be === "abcdef"
  }

  it must "support many section" in {

    val text = Text()
    text.startSection append "a"
    text.startSection append "b"
    text.startSection append "c"
    text.startSection append "d"
    text.startSection append "e"
    text.startSection append "f"

    text.toString must be === "abcdef"
  }

  it must "support decorators" in {
    val text = Text()
    val d1: Decorator = s ⇒ s"($s)"
    val d2: Decorator = s ⇒ s"[$s]"
    val d3: Decorator = s ⇒ s"{$s}"

    (text withDecorator d1) {
      text append "a"
      text append "b"

      (text withDecorator d2) {

        text append "c"

        (text withDecorator d3) {
          text append "d"
        }
      }
    }

    text.toString must be === "(a)(b)([c])([{d}])"
  }

  it must "support block decorators" in {
    val text = Text()
    val d1: Decorator = s ⇒ s"($s)"
    val d2: Decorator = s ⇒ s"[$s]"
    val d3: Decorator = s ⇒ s"{$s}"

    text.withBlockDecorator(d1) {
      text append "a"
      text append "b"

      text.withBlockDecorator(d2) {
        text append "c"

        text.withBlockDecorator(d3) {
          text append "d"
        }
      }
    }

    text.toString must be === "(ab[c{d}])"
  }

  it must "support indent" in {
    val text = Text()
    text << "test"
    text indent {
      text << "indent"
      text << "indent2" << endl << "indent3"
      text indent {
        text << "indent4" << endl << "indent5"
        text.indentBy(1) {
          text << "indent6"
        }
      }
      text << endl
      text << "indent7"
    }
    text << endl
    text << "test"

    text.toString must be ===
      """|test
           |  indentindent2
           |  indent3
           |    indent4
           |    indent5
           |     indent6
           |  indent7
           |test""".stripMargin
  }

  it must "output to writer" in {
    val text = Text()
    val out = new StringWriter
    text << "a" >> out

    out.toString must be === "a"
  }

  it must "indent with brackets" in {
    val text = Text()

    text << "test" curlyIndent {
      text << "indent1" curlyIndent {
        text << "indent2" squareIndent {
          text << "indent3"
        }
        text angleIndent {
          text << "indent4"
        }
      }
      text parenIndent {
        text << "indent5"
      }
    }
    text << "test"

    text.toString must be ===
      """|test {
 		 |  indent1 {
		 |    indent2 [
		 |      indent3
		 |    ] <
		 |      indent4
		 |    >
		 |  } (
		 |    indent5
		 |  )
		 |}test""".stripMargin
  }

  it must "strip spaces" in {
    val text = new Text(stripWhitespace = true)

    text << """
      some text
      some text
        some text
          some text
      some text
      """

    text indent {
      text << """
        indent text
          indent text
            indent text
        indent text
        """
    }

    text.toString must be ===
      """|some text
   		 |some text
  		 |  some text
  		 |    some text
  		 |some text
           |  indent text
           |    indent text
           |      indent text
           |  indent text""".stripMargin

  }

  it must "strip spaces not considering empty lines" in {
    val text = new Text(stripWhitespace = true, indent = 4)

    text << """
	   text1
	   text2
	
	   text3
		 text4
    
		 text5
	   text6
               
	   text7
	   """

    text.toString must be ===
      """|text1
 		 |text2
		 |
		 |text3
		 |  text4
         |
         |  text5
         |text6
         |
         |text7""".stripMargin

  }

}