package fr.unice.i3s.sigma.m2t

import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.io.StringWriter
import fr.unice.i3s.sigma.test.scalatest.TextMatchers

@RunWith(classOf[JUnitRunner])
class TextSpec extends FlatSpec with MustMatchers with TextMatchers {

  val endl = Text.endl

  "Decorators" must "be composable" in {
    val d1: Decorator = s ⇒ s"($s)"
    val d2: Decorator = s ⇒ s"[$s]"
    val d3 = d1 andThen d2

    d3("a") must be(text("[(a)]"))
  }

  "Text" must "append simple t" in {

    val t = Text()

    t append "hello world"

    t must be(text("hello world"))
  }

  it must "delete right characters" in {

    val t = Text()
    t << "hello"
    t deleteRight 1
    t must be(text("hell"))
  }

  it must "support sections" in {

    val t = Text()
    t append "a"
    val sub1 = t.startSection()
    sub1 append "b"
    val sub2 = sub1.startSection()
    sub2 append "c"
    t append "f"
    sub1 append "e"
    sub2 append "d"

    t must be(text("abcdef"))
  }

  it must "allow simple decorator" in {
    val t = Text()
    val d: Decorator = s ⇒ s"($s)"

    t.withDecorator(d) {
      t append "a"
      t append "bc"
      t append "d"
    }

    t must be(text("(a)(bc)(d)"))

  }

  it must "allow nested decorators" in {

    val t = Text()
    val d1: Decorator = s ⇒ s"($s)"
    val d2: Decorator = s ⇒ s"[$s]"

    t.withDecorator(d1) {
      t append "a"
      t.withDecorator(d2) {
        t append "bc"
      }
      t append "d"
    }

    t must be(text("(a)([bc])(d)"))

  }

  it must "allow mutliple nested decorators" in {
    val t = Text()
    val d1: Decorator = s ⇒ s"($s)"
    val d2: Decorator = s ⇒ s"[$s]"
    val d3: Decorator = s ⇒ s"{$s}"

    t.withDecorator(d1) {
      t append "a"
      t append "b"

      t.withDecorator(d2) {

        t append "c"

        t.withDecorator(d3) {
          t append "d"
        }
      }
    }

    t must be(text("(a)(b)([c])([{d}])"))
  }

  it must "allow simple section decorator" in {
    val t = Text()
    val d: Decorator = s ⇒ s"($s)"

    t.withSectionDecorator(d) {
      t append "a"
      t append "bc"
      t append "d"
    }

    t must be(text("(abcd)"))

  }

  it must "allow nested section decorators" in {

    val t = Text()
    val d1: Decorator = s ⇒ s"($s)"
    val d2: Decorator = s ⇒ s"[$s]"

    t.withSectionDecorator(d1) {
      t.withSectionDecorator(d2) {
        t append "a"
        t append "bc"
        t append "d"
      }
    }

    t must be(text("([abcd])"))

  }

  it must "allow multiple nested section decorators" in {
    val t = Text()
    val d1: Decorator = s ⇒ s"($s)"
    val d2: Decorator = s ⇒ s"[$s]"
    val d3: Decorator = s ⇒ s"{$s}"

    t.withSectionDecorator(d1) {
      t append "a"
      t append "b"

      t.withSectionDecorator(d2) {
        t append "c"

        t.withSectionDecorator(d3) {
          t append "d"
        }
      }
    }

    t must be(text("(ab[c{d}])"))
  }

  it must "indent section without adding new line" in {
    val t = Text(defaultIndent = 2)

    t << "a"
    t indent {
      t << "b"
    }
    t << "c"

    t must be(text(
      """|a
           |  bc""".stripMargin))
  }

  it must "allow multiple indent section without adding new line" in {
    val t = Text(defaultIndent = 2)

    t << "a"
    t indent {
      t << "b"
      t indent {
        t << "c"
      }
    }
    t << "d"

    t must be(text(
      """|a
           |  b
           |    cd""".stripMargin))
  }

  it must "indent section" in {
    val t = Text(defaultIndent = 2)

    t << "a"
    t indent {
      t << "b"
    }
    t << endl
    t << "c"

    t must be(text(
      """|a
           |  b
           |c""".stripMargin))
  }

  it must "allow multiple indented section" in {
    val t = Text(defaultIndent = 2)

    t << "a"
    t indent {
      t << "b"
      t << "c"
      t indent {
        t << "d"
        t << "e"
        t << endl
        t << "f"
      }
      t << "g"
      t << endl
      t << "h"
    }
    t << endl
    t << "i"

    t must be(text(
      """|a
           |  bc
           |    de
           |    fg
           |  h
           |i""".stripMargin))
  }

  it must "allow mutliple indents" in {
    val t = Text(defaultIndent = 2)
    t << "a"
    t indent {
      t << "b"
      t << "c"
      t << endl
      t << "d"
      t indent {
        t << "e"
        t << endl
        t << "f"
        t.indentBy(1) {
          t << "g"
        }
      }
      t << endl
      t << "h"
    }
    t << endl
    t << "i"

    t must be(text(
      """|a
           |  bc
           |  d
           |    e
           |    f
           |     g
           |  h
           |i""".stripMargin))
  }

  it must "output to writer" in {
    val t = Text()
    val out = new StringWriter
    t << "a" >> out

    out must be(text("a"))
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

    t.toString must be(text(
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

  it must "strip spaces on multiline strings" in {
    val t = new Text(stripWhitespace = true)

    t << """
        a
        """

    t must be(text("a"))
  }

  it must "strip spaces on multiline strings with multiple lines" in {
    val t = new Text(stripWhitespace = true)

    t << """
        a
        b
          c
          d
        e
        """

    t must be(text(
      """|a
             |b
             |  c
             |  d
             |e""".stripMargin))
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

    t must be(text(
      """|some t
     		 |some t
    		 |  some t
    		 |    some t
    		 |some t
           |  indent t
           |    indent t
           |      indent t
           |  indent t""".stripMargin))
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

    t must be(text(
      """|t1
   		 |t2
  		 |
  		 |t3
  		 |  t4
           |
           |  t5
           |t6
           |
           |t7""".stripMargin))

  }

  it must "respect section decorators in forked sections" in {
    val t = new Text(defaultIndent = 2)

    var sec: Text = null
    t << "a" curlyIndent {
      sec = t.startSection()
      t << endl
      t << "b"
    }
    sec << "c"
    sec << endl
    sec << "d"

    t must be(text(
      """|a {
    		 |  c
     		 |  d
           |  b
     		 |}""".stripMargin))
  }

  it must "respect section decorators in multiple nested forked sections" in {
    val t = new Text(defaultIndent = 2)

    var sec1: Text = null
    var sec2: Text = null
    var sec3: Text = null
    t << "a" curlyIndent {
      sec1 = t.startSection()
      t << endl
      t << "b"
      t curlyIndent {
        sec2 = t.startSection()
        t << "c"
        t curlyIndent {
          t << "d"
          sec3 = t.startSection()
          t << "e"
        }
      }
    }
    sec1 << "f"
    sec1 << endl
    sec1 << "g"
    sec2 << "h"
    sec2 << endl
    sec2 << "i"
    sec3 << "j"
    sec3 << endl
    sec3 << "k"

    t must be(text(
      """|a {
    	 |  f
     	 |  g
         |  b {
         |    h
         |    ic {
         |      dj
         |      ke
         |    }
         |  }
     	 |}""".stripMargin))
  }

  it must "relaxed whitespace test" in {
    val t = new Text(
      stripWhitespace = true,
      relaxedNewLines = true,
      defaultIndent = 2)

    t << "class A" curlyIndent {
      t << """
        val a = 1
        val b = 1
        """
    }

    t must be(text(
      """|class A {
    	 |  val a = 1
     	 |  val b = 1
     	 |}
         |""".stripMargin))

  }

  "StripWhitespaceDecorator" must "correctly handle multiline text with relaxed newlines" in {
    // NOTE: the problem has been found while woring with EMF import manager
    // the last line of the following append would be lost
    // \nimport fr.unice.i3s.sigma.support.EMFProxyBuilder;\nimport fr.unice.i3s.sigma.support.EMFScalaSupport;\n\nimport org.eclipse.emf.common.util.EList;\n\nimport org.eclipse.emf.ecore.EAnnotation;\nimport org.eclipse.emf.ecore.EAttribute;\nimport org.eclipse.emf.ecore.EClassifier;\nimport org.eclipse.emf.ecore.EDataType;\nimport org.eclipse.emf.ecore.EGenericType;
    val str = "\na\nb\nc"
    Decorators.stripWhitespace(2, true)(str) must be(text(
      """|
         |a
         |b
         |c""".stripMargin))
  }

}