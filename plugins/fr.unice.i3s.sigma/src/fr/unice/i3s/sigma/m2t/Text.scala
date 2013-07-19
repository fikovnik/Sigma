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
protected[this] abstract class TextSection[T <: TextSection[T]](
  appendDecorator: Decorator,
  sectionDecorator: Decorator) {

  /** The buffer to which the append with add text */
  private[this] val buffer = new ListBuffer[String]
  private[this] var left: Option[TextSection[T]] = None
  private[this] var right: Option[TextSection[T]] = None
  private[this] var curr: this.type = this

  protected[this] def createSection(
    appendDecorator: Decorator,
    sectionDecorator: Decorator): T

  protected[m2t] def deleteRight(chars: Int): this.type = {
    right match {
      case Some(r) ⇒ r.deleteRight(chars)
      case None ⇒
        require(buffer.nonEmpty)
        val last = buffer.last
        require(last.length - chars >= 0)

        buffer(buffer.size - 1) = last dropRight chars
    }

    this
  }

  def append(text: String): this.type = {
    right match {
      case Some(r) ⇒ r append text
      case None ⇒ buffer += text
    }

    this
  }

  def startSection(): T = startSection(Decorators.identity, Decorators.identity)

  def startSection(
    extraAppendDecorator: Decorator,
    extraSectionDecorator: Decorator): T = {

    right match {
      case Some(r) ⇒ r.startSection(extraAppendDecorator, extraSectionDecorator)
      case None ⇒
        // create a new section
        val section = createSection(
          (extraAppendDecorator andThen appendDecorator),
          // do not copy the section decorator
          (extraSectionDecorator))
        left = Some(section)
        // continue with the same section
        right = Some(createSection(appendDecorator, Decorators.identity))
        section
    }

    // TODO: no this since we return the new section instead
  }

  def withSection(section: TextSection[T])(block: ⇒ Any): this.type = {
    right match {
      case Some(r) ⇒ r.withSection(section)(block)
      case None ⇒
        // do not copy the section decorator for this one since it will be
        // automatically inherited
        val next = Some(createSection(appendDecorator, Decorators.identity))
        right = Some(section)
        block
        left = right
        right = next
    }

    this
  }

  def withDecorator(decorator: Decorator)(block: ⇒ Unit): this.type = {
    right match {
      case Some(r) ⇒ r.withDecorator(decorator)(block)
      case None ⇒
        val section = createSection((decorator andThen appendDecorator), sectionDecorator)
        withSection(section)(block)
    }
    this
  }

  def withSectionDecorator(decorator: Decorator)(block: ⇒ Unit): this.type = {
    right match {
      case Some(r) ⇒ r.withSectionDecorator(decorator)(block)
      case None ⇒
        // section decorators are not composeable since they need to be applied 
        // individually at the end of the merged section
        val section = createSection(appendDecorator, decorator)
        withSection(section)(block)
    }
    this
  }

  override def toString = {
    val sb = new StringBuffer

    val thisText = buffer map appendDecorator mkString ""
    if (thisText.nonEmpty) {
      sb append thisText
    }

    val leftText = left match {
      case Some(l) ⇒ l.toString
      case None ⇒ ""
    }

    if (leftText.nonEmpty) {
      sb append leftText
    }

    val rightText = right match {
      case Some(r) ⇒ r.toString
      case None ⇒ ""
    }

    if (rightText.nonEmpty) {
      sb append rightText
    }

    val text = sb.toString
    if (text.nonEmpty) {
      val decorated = sectionDecorator(text)
      decorated		  
    } else {
      ""
    }
  }
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
  appendDecorator: Decorator,
  sectionDecorator: Decorator,
  stripWhitespace: Boolean,
  relaxedNewLines: Boolean,
  defaultIndent: Int)

  extends TextSection[Text](appendDecorator, sectionDecorator)
  with TextOutput {

  def this(stripWhitespace: Boolean = false,
    relaxedNewLines: Boolean = false,
    defaultIndent: Int = 2) {

    this(
      // append decorator
      Decorators.identity,
      // block decorator
      Decorators.identity,
      stripWhitespace,
      relaxedNewLines,
      defaultIndent)
  }

  import Text._

  override def append(str: String) = {
    var text = str

    text = {
      if (stripWhitespace) Decorators.stripWhitespace(defaultIndent, relaxedNewLines)(str)
      else str
    }

    text = {
      if (relaxedNewLines) Decorators.relaxedNewLines(text)
      else text
    }

    super.append(text)
  }

  def <<(text: String): this.type = append(text)

  def indentBy(num: Int)(block: ⇒ Unit): this.type = {
    if (!relaxedNewLines) {
      append(endl)
    }

    withSectionDecorator(Decorators.indentText(num))(block)

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

  override protected[this] def createSection(
    appendDecorator: Decorator,
    sectionDecorator: Decorator): Text = {

    new Text(appendDecorator, sectionDecorator, stripWhitespace, relaxedNewLines, defaultIndent)
  }

}
