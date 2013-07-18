package fr.unice.i3s.sigma.m2t

import scala.annotation.tailrec
import scala.util.DynamicVariable
import java.io.Writer
import java.io.File
import java.io.OutputStream
import java.io.OutputStreamWriter
import com.google.common.base.Charsets
import scala.collection.mutable.Stack

import scala.collection.mutable.ListBuffer

/**
 *
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
protected[this] abstract class TextSection[T <: TextSection[T]] {

  /** The buffer to which the append with add text */
  private[this] var buffer = new StringBuilder
  private[this] val marks = ListBuffer[(Int, TextSection[T])]()
  protected[this] val decorators = new Stack[Decorator]

  protected def createSection: T

  protected[m2t] def deleteRight(chars: Int): this.type = {
    if (buffer.size >= chars) {
      buffer.delete(buffer.size - chars, buffer.size)
    }
    this
  }

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

/**
 * Provides some convenient methods for outputting text into streams and writers.
 * The text is taken from the {{{#toString}}} method of the class where this trait is mixed in.
 */
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

object Text {
  val endl = System.getProperty("line.separator")
  val endlc = endl.charAt(0)

  def apply(
    stripWhitespace: Boolean = false,
    relaxedNewLines: Boolean = false,
    defaultIndent: Int = 2) = new Text(stripWhitespace, relaxedNewLines, defaultIndent)
}

class Text(
  stripWhitespace: Boolean = false,
  relaxedNewLines: Boolean = false,
  defaultIndent: Int = 2)

  extends TextSection[Text]
  with TextOutput {

  import Text._

  if (relaxedNewLines) {
    decorators push Decorators.relaxedNewLines
  }
  if (stripWhitespace) {
    decorators push Decorators.stripWhitespace(defaultIndent, relaxedNewLines)
  }

  def <<(text: String): this.type = append(text)
  
  def indentBy(num: Int)(block: ⇒ Unit): this.type = {
    if (!relaxedNewLines) {
      append(endl)
    }
    
    withBlockDecorator(Decorators.indentText(num))(block)

    this
  }

  def indent(block: ⇒ Unit): this.type = indentBy(defaultIndent)(block)

  def surroundWith(begin: String, end: String)(block: ⇒ Unit): this.type = {
    if (relaxedNewLines) {
      deleteRight(1)
    }

    append(begin)

    block

    if (!relaxedNewLines) {
      append(endl)
    }

    append(end)

    this
  }


  def curlyIndent(block: ⇒ Unit): this.type = {
    surroundWith(" {", "}") {
      indent(block)
    }
  }

  def squareIndent(block: ⇒ Unit): this.type = {
    surroundWith(" [", "]") {
      indent(block)
    }
  }

  def parenIndent(block: ⇒ Unit): this.type = {
    surroundWith(" (", ")") {
      indent(block)
    }
  }

  def angleIndent(block: ⇒ Unit): this.type = {
    surroundWith(" <", ">") {
      indent(block)
    }
  }

  override protected[m2t] def createSection: Text = new Text(stripWhitespace, relaxedNewLines, defaultIndent)
}
