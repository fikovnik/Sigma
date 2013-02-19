package fr.unice.i3s.sigma.scala.mtt

import scala.annotation.tailrec
import scala.collection.mutable.Buffer
import scala.util.DynamicVariable
import java.io.Writer
import java.io.File
import java.io.OutputStream
import java.io.OutputStreamWriter
import com.google.common.base.Charsets
import scala.collection.mutable.Stack

/**
 * This class is not thread safe.
 *
 * <i>Implementation note</i>
 * <br/>
 * We have to use the curriously repeating template pattern unless MyType will
 * be properly supported in scala. References:
 * <ul>
 * <li>https://groups.google.com/d/topic/scala-user/ibqlG7ffkkY/discussion</li>
 * <li>http://www.scala-lang.org/node/6649M</li>
 * <li>http://www.scala-lang.org/node/11964</li>
 * </ul>
 */

abstract class TextSection[T <: TextSection[T]] {

  val endl = System.getProperty("line.separator")

  /** The buffer to which the append with add text */
  private[this] var buffer = new StringBuilder
  private[this] val marks = Buffer[(Int, TextSection[T])]()
  protected[this] val decorators = new Stack[Decorator]

  protected def createSection: T

  def append(text: String): this.type = {
    val decorator: Decorator = decorators match {
      case Stack() ⇒ identity
      case _ ⇒ decorators reduceLeft (_ andThen _)
    }

    buffer append decorator(text)
    this
  }

  def withDecorator(decorator: Decorator)(block: ⇒ Unit): this.type = {
    decorators push decorator

    try block
    finally decorators.pop

    this
  }

  def withBlockDecorator(decorator: Decorator)(block: ⇒ Unit): this.type = {
    val newBuffer = new StringBuilder
    val oldBuffer = buffer

    buffer = newBuffer
    try block
    finally buffer = oldBuffer

    buffer append decorator(newBuffer.toString)

    this
  }

  def startSection: T = {
    val section = createSection
    marks += ((buffer.length, section))
    section
  }

  override def toString = {
    var offset = 0

    for ((index, section) ← marks) {
      val text = section.toString

      buffer insert (index + offset, text)
      offset += text.length
    }

    buffer.toString

  }
}

trait TextSectionAdditions { this: TextSection[_] ⇒

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

  implicit class TextTemplateString(that: String) {
    def unary_! = append(that)
    def quoted = Decorators.surroundText("\"")(that)
    def singleQuoted = Decorators.surroundText("'")(that)
  }

  private[this] var _defaultIndent: Int = 2

  def defaultIndent = _defaultIndent
  def defaultIndent_=(value: Int) = {
    require(value > 0)
    _defaultIndent = value
  }

  def output(out: Writer): this.type = {
    out append (toString)
    out.flush
    this
  }

  def output(out: OutputStream): this.type =
    output(new OutputStreamWriter(out, Charsets.UTF_8))

  def <<(text: String): this.type = append(text)
  def >>(out: Writer): this.type = output(out)
  def >>(out: OutputStream): this.type = output(out)

  def indentBy(num: Int)(block: ⇒ Unit): this.type = {
    append(endl)
    withBlockDecorator(Decorators.indentText(num))(block)
  }

  def indent(block: ⇒ Unit): this.type = indentBy(defaultIndent)(block)

  def surroundWith(begin: String, end: String)(block: ⇒ Unit): this.type = {
    withBlockDecorator(Decorators.surroundText(begin, end))(block)
  }

  def curlyIndent(block: ⇒ Unit): this.type = {
    surroundWith(" {", endl + "}") {
      indent(block)
    }
  }

  def squareIndent(block: ⇒ Unit): this.type = {
    surroundWith(" [", endl + "]") {
      indent(block)
    }
  }

  def parenIndent(block: ⇒ Unit): this.type = {
    surroundWith(" (", endl + ")") {
      indent(block)
    }
  }

  def angleIndent(block: ⇒ Unit): this.type = {
    surroundWith(" <", endl + ">") {
      indent(block)
    }
  }

  def stripWhitespace(block: ⇒ Unit): this.type = {
    withDecorator(Decorators.stripWhitespace(defaultIndent))(block)
  }
}

object Text {
  def apply() = new Text
}

class Text extends TextSection[Text] with TextSectionAdditions {
  var _stripWhitespace: Boolean = false;

  def stripWhitespace: Boolean = _stripWhitespace
  def stripWhitespace_=(strip: Boolean) = {
    decorators push Decorators.stripWhitespace(defaultIndent)
    _stripWhitespace = strip
  }

  override def createSection: Text = new Text
}
