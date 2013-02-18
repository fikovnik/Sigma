package fr.unice.i3s.sigma.scala.mtt

import scala.annotation.tailrec
import scala.collection.mutable.Buffer
import scala.util.DynamicVariable
import java.io.Writer
import java.io.File
import java.io.OutputStream
import java.io.OutputStreamWriter
import com.google.common.base.Charsets

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

  private[this] trait TextBuffer {
    def append(s: String): TextBuffer
    def insert(index: Int, s: String): TextBuffer
    def length: Int
    def toString: String
  }

  private[this] class StandardBuffer extends TextBuffer {
    val sb = new StringBuilder

    def append(s: String) = { sb.append(s); this }
    def insert(index: Int, s: String) = { sb.insert(index, s); this }
    def length = sb.length
    override def toString = sb.toString
  }

  private[this] class DecoratedBuffer(decorator: Decorator) extends StandardBuffer {
    override def append(s: String) = { sb.append(decorator(s)); this }
  }

  /** The buffer to which the append with add text */
  private[this] var buffer: TextBuffer = new StandardBuffer
  private[this] var marks: Buffer[(Int, TextSection[T])] = Buffer()

  private[this] def withBuffer(newbuffer: TextBuffer)(block: ⇒ Unit) = {
    val oldbuffer = buffer

    buffer = newbuffer
    try block
    finally buffer = oldbuffer

    newbuffer
  }

  protected def createSection: T

  def append(text: String): this.type = {
    buffer append text
    this
  }

  def withDecorator(decorator: Decorator)(block: ⇒ Unit): this.type = {
    val sb = withBuffer(new DecoratedBuffer(decorator))(block)
    append(sb.toString)
    this
  }

  def withBlockDecorator(decorator: Decorator)(block: ⇒ Unit): this.type = {
    val sb = withBuffer(new StandardBuffer)(block)
    append(decorator(sb.toString))
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

      buffer.insert(index + offset, text)
      offset += text.length
    }

    buffer.toString

  }
}

trait TextSectionAdditions { this: TextSection[_] ⇒

  object decorators {

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
      // expand tabs
      val expandedText = text.replace("\t", " " * tabSize)
      // split and drop empty lines
      val lines = (expandedText split endl) filter (!_.isEmpty)

      if (!lines.isEmpty) {
        // longest whitespace prefix
        val prefix = lines.map(_.segmentLength(_.isWhitespace, 0)).min
        // drop it and concatenate
        lines map (_.drop(prefix)) mkString (endl)
      } else {
        ""
      }
    }
  }

  implicit class TextTemplateString(that: String) {
    def unary_! = append(that)
    def quoted = decorators.surroundText("\"")(that)
    def singleQuoted = decorators.surroundText("'")(that)
  }

  private[this] var _defaultIndent: Int = 2

  def defaultIndent = _defaultIndent
  def defaultIndent_=(value: Int) = {
    require(value > 0)
    _defaultIndent = value
  }

  def output(out: Writer): this.type = {
    out.append(toString)
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
    withBlockDecorator(decorators.indentText(num))(block)
  }

  def indent(block: ⇒ Unit): this.type = indentBy(defaultIndent)(block)

  def surroundWith(begin: String, end: String)(block: ⇒ Unit): this.type = {
    withBlockDecorator(decorators.surroundText(begin, end))(block)
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
    withDecorator(decorators.stripWhitespace(defaultIndent))(block)
  }
}

object Text {
  def apply() = new Text
}

class Text extends TextSection[Text] with TextSectionAdditions {
  override def createSection: Text = new Text
}
