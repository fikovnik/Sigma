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

  def section: T = {
    rightOpt match {
      case None ⇒
        // subsection do not inherit any blockDecorators
        // otherwise they will be applied multiple times
        leftOpt = Some(createSection(decorator, identity))
        rightOpt = Some(createSection(decorator, identity))

        leftOpt.get

      case Some(right) ⇒
        right section
    }
  }

  def withDecorator(newDecorator: Decorator)(block: ⇒ Any): this.type = {
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

  def withBlockDecorator(newDecorator: Decorator)(block: ⇒ Any): this.type = {
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

  protected[this] def createSection(
    decorator: Decorator,
    blockDecorator: Decorator): T

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

  private[this] def indentText(num: Int) =
    (text: String) ⇒ {
      val str =
        if (text.last == '\n') text.substring(0, text.length - 1)
        else text

      str.replace("\n", "\n" + " " * num) + "\n"
    }

  private[this] def surroundText(str: String) =
    (text: String) ⇒ s"$str$text$str"

  implicit class TextTemplateString(that: String) {
    def unary_! = append(that)
    def quoted = surroundText("\"")(that)
    def singleQuoted = surroundText("'")(that)
  }

  private[this] var _defaultIndent: Int = 2

  def defaultIndent = _defaultIndent
  def defaultIndent_=(value: Int) = {
    require(value > 0)
    _defaultIndent = value
  }

  def <<(text: String): this.type = append(text)

  def >>(out: Writer): this.type = {
    out.append(toString)
    out.flush
    this
  }

  def >>(out: OutputStream): this.type =
    >>(new OutputStreamWriter(out, Charsets.UTF_8))

  def append(texts: String*): this.type = {
    texts foreach append

    this
  }

  def indentBy(num: Int)(block: ⇒ Any): this.type = {
    withBlockDecorator(indentText(num)) {
      append(endl)
      block
    }

    this
  }

  def indent(block: ⇒ Any): this.type = {
    withBlockDecorator(indentText(defaultIndent)) {
      append(endl)
      block
    }

    this
  }

  def cIndent(block: ⇒ Any): this.type = {
    append(" {")
    indent(block)
    append("}")
  }

  def sIndent(block: ⇒ Any): this.type = {
    append(" [")
    indent(block)
    append("]")
  }

  def pIndent(block: ⇒ Any): this.type = {
    append(" (")
    indent(block)
    append(")")
  }

  def aIndent(block: ⇒ Any): this.type = {
    append(" <")
    indent(block)
    append(">")
  }

}

class TextTemplate(decorator: Decorator, blockDecorator: Decorator)
  extends TextSection[TextTemplate](decorator, blockDecorator)
  with TextSectionAdditions {

  def this() = this(identity, identity)

  def generate: Unit = {}

  override def toString = {
    generate
    super.toString
  }

  override def createSection(decorator: Decorator, blockDecorator: Decorator): TextTemplate =
    new TextTemplate(decorator, blockDecorator)
}