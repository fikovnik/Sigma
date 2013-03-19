package fr.unice.i3s.sigma.m2t

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

object TextSection {
  val endl = System.getProperty("line.separator")

}

import TextSection._

abstract class TextSection[T <: TextSection[T]] {

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

trait TextOutput {
  def output(out: Writer): this.type = {
    out append (toString)
    out.flush
    this
  }

  def output(out: OutputStream): this.type =
    output(new OutputStreamWriter(out, Charsets.UTF_8))

  def >>(out: Writer): this.type = output(out)
  def >>(out: OutputStream): this.type = output(out)
}

trait TextSectionAdditions { this: TextSection[_] ⇒

  private[this] var _defaultIndent: Int = 2

  def defaultIndent = _defaultIndent
  def defaultIndent_=(value: Int) = {
    require(value > 0)
    _defaultIndent = value
  }

  def <<(text: String): this.type = append(text)

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

class Text(val stripWhitespace: Boolean = false, indent: Int = 2) extends TextSection[Text]
  with TextSectionAdditions
  with TextOutput {

  this.defaultIndent = indent

  if (stripWhitespace) {
    decorators push Decorators.stripWhitespace(defaultIndent)
  }

  override def createSection: Text = new Text
}
