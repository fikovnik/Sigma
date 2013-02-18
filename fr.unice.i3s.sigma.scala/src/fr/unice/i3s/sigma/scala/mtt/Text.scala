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

abstract class TextSection[T <: TextSection[T]](
  private[this] val decorator: Decorator = identity,
  private[this] val blockDecorator: Decorator = identity) {

  private[this] var leftOpt: Option[T] = None
  private[this] var rightOpt: Option[T] = None

  val endl = System.getProperty("line.separator")

  protected val buffer = new StringBuilder

  def append(text: String): this.type = {
    rightOpt match {
      case None ⇒ buffer append decorator(text)
      case Some(right) ⇒ right append text
    }

    this
  }

  def startSection: T = {
    rightOpt match {
      case None ⇒
        // subsection do not inherit any blockDecorators
        // otherwise they will be applied multiple times
        leftOpt = Some(createSection(decorator, identity))
        rightOpt = Some(createSection(decorator, identity))

        leftOpt.get

      case Some(right) ⇒
        right startSection
    }
  }

  def withDecorator(newDecorator: Decorator)(block: ⇒ Unit): this.type = {
    rightOpt match {
      case None ⇒
        rightOpt = Some(createSection(newDecorator andThen decorator, blockDecorator))

        block

        leftOpt = rightOpt
        rightOpt = Some(createSection(decorator, blockDecorator))

      case Some(right) ⇒
        right.withDecorator(newDecorator)(block)
    }

    this
  }

  def withBlockDecorator(newDecorator: Decorator)(block: ⇒ Unit): this.type = {
    rightOpt match {
      case None ⇒
        rightOpt = Some(createSection(decorator, newDecorator))

        block

        leftOpt = rightOpt
        rightOpt = Some(createSection(decorator, blockDecorator))

      case Some(right) ⇒
        right.withBlockDecorator(newDecorator)(block)
    }

    this
  }

  protected def createSection(decorator: Decorator, blockDecorator: Decorator): T

  override def toString = {
    val sb = new StringBuilder

    // the actual content
    sb append buffer

    // left part
    sb append leftOpt.map(_.toString).getOrElse("")

    // right part
    sb append rightOpt.map(_.toString).getOrElse("")

    // process block decorators
    if (!sb.isEmpty)
      blockDecorator(sb.toString)
    else
      ""
  }
}

trait TextSectionAdditions { this: TextSection[_] ⇒

  object decorators {

    def indentText(num: Int) = (text: String) ⇒ {
      val str =
        if (text.last == '\n') text.substring(0, text.length - 1)
        else text

      str.replace("\n", "\n" + " " * num) + "\n"
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

class Text(decorator: Decorator, blockDecorator: Decorator)
  extends TextSection[Text](decorator, blockDecorator)
  with TextSectionAdditions {

  def this() = this(identity, identity)

  override def createSection(decorator: Decorator, blockDecorator: Decorator): Text =
    new Text(decorator, blockDecorator)
}