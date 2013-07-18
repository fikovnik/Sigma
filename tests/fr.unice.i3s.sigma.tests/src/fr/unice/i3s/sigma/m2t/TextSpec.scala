package fr.unice.i3s.sigma.m2t

import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.io.StringWriter
import fr.unice.i3s.sigma.test.scalatest.M2TMatchers

@RunWith(classOf[JUnitRunner])
class TextSpec extends FlatSpec with MustMatchers with M2TMatchers {

  val endl = Text.endl

  "Text" must "append simple t" in {

    val t = Text()
    
    t append "hello world"
    
    t.toString must be === "hello world"
  }
  

  it must "support sections" in {

    val t = Text()
    t append "a"
    val sub1 = t.startSection
    sub1 append "b"
    val sub2 = sub1.startSection
    sub2 append "c"
    t append "f"
    sub1 append "e"
    sub2 append "d"

    t.toString must be === "abcdef"
  }

  it must "support many section" in {

    val t = Text()
    t.startSection append "a"
    t.startSection append "b"
    t.startSection append "c"
    t.startSection append "d"
    t.startSection append "e"
    t.startSection append "f"

    t.toString must be === "abcdef"
  }

  it must "support decorators" in {
    val t = Text()
    val d1: Decorator = s ⇒ s"($s)"
    val d2: Decorator = s ⇒ s"[$s]"
    val d3: Decorator = s ⇒ s"{$s}"

    (t withDecorator d1) {
      t append "a"
      t append "b"

      (t withDecorator d2) {

        t append "c"

        (t withDecorator d3) {
          t append "d"
        }
      }
    }

    t.toString must be === "(a)(b)([c])([{d}])"
  }

  it must "support block decorators" in {
    val t = Text()
    val d1: Decorator = s ⇒ s"($s)"
    val d2: Decorator = s ⇒ s"[$s]"
    val d3: Decorator = s ⇒ s"{$s}"

    t.withBlockDecorator(d1) {
      t append "a"
      t append "b"

      t.withBlockDecorator(d2) {
        t append "c"

        t.withBlockDecorator(d3) {
          t append "d"
        }
      }
    }

    t.toString must be === "(ab[c{d}])"
  }

  it must "support indent" in {
    val t = Text()
    t << "test"
    t indent {
      t << "indent"
      t << "indent2" << endl << "indent3"
      t indent {
        t << "indent4" << endl << "indent5"
        t.indentBy(1) {
          t << "indent6"
        }
      }
      t << endl
      t << "indent7"
    }
    t << endl
    t << "test"

    t.toString must be ===
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
    val t = Text()
    val out = new StringWriter
    t << "a" >> out

    out.toString must be === "a"
  }

  it must "indent with brackets" in {
    val t = Text()

    t << "test" curlyIndent {
      t << "indent1" curlyIndent {
        t << "indent2" squareIndent {
          t << "indent3"
        }
        t angleIndent {
          t << "indent4"
        }
      }
      t parenIndent {
        t << "indent5"
      }
    }
    t << "test"

    t.toString must be (text(
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
		 |}test""".stripMargin))
  }

  it must "strip spaces" in {
    val t = new Text(stripWhitespace = true)

    t << """
      some t
      some t
        some t
          some t
      some t
      """

    t indent {
      t << """
        indent t
          indent t
            indent t
        indent t
        """
    }

    t.toString must be ===
      """|some t
   		 |some t
  		 |  some t
  		 |    some t
  		 |some t
           |  indent t
           |    indent t
           |      indent t
           |  indent t""".stripMargin

  }

  it must "strip spaces not considering empty lines" in {
    val t = new Text(stripWhitespace = true, defaultIndent = 4)

    t << """
	   t1
	   t2
	
	   t3
		 t4
    
		 t5
	   t6
               
	   t7
	   """

    t.toString must be ===
      """|t1
 		 |t2
		 |
		 |t3
		 |  t4
         |
         |  t5
         |t6
         |
         |t7""".stripMargin

  }

  it must "relaxed whitespace test" in {
    val t = new Text(stripWhitespace = true, relaxedNewLines = true, defaultIndent = 2)

    t << "class A" curlyIndent {
      t << """
      val a = 1
      val b = 1
      """
    }

    t.toString must be (text(
      """|class A {
  		 |  val a = 1
   		 |  val b = 1
   		 |}
         |""".stripMargin))

  }

}