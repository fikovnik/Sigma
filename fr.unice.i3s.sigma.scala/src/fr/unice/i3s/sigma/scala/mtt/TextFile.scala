package fr.unice.i3s.sigma.scala.mtt

import scala.annotation.tailrec
import scala.collection.mutable.Buffer
import scala.util.DynamicVariable

import TextSection._
import java.io.Writer

object TextSection {
  def indentText(num: Int) =
    (text: String) => {
      val str =
        if (text.last == '\n') text.substring(0, text.length - 1)
        else text

      str.replace("\n", "\n" + " " * num) + "\n"
    }

  def surroundText(str: String) =
    (text: String) => s"$str$text$str"

  val endl = System.getProperty("line.separator")

  implicit class TextSectionedString(val str: String) {
    def quoted = surroundText("\"")(str)
    def singleQuoted = surroundText("'")(str)
  }
}

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
  private[this] val decorators: List[String => String] = List(),
  private[this] val blockDecorators: List[String => String] = List()) {

  private[this] var leftOpt: Option[T] = None
  private[this] var rightOpt: Option[T] = None

  protected val buffer = Buffer[String]()

  def append(text: String): this.type = {
    rightOpt match {
      case None => buffer += text
      case Some(right) => right append text
    }

    this
  }

  def section: T = {
    rightOpt match {
      case None =>
        // subsection do not inherit any blockDecorators
        // otherwise they will be applied multiple times
        leftOpt = Some(createSection(decorators, Nil))
        rightOpt = Some(createSection(decorators, Nil))

        leftOpt.get

      case Some(right) =>
        right section
    }
  }

  def withDecorator(decorator: String => String)(block: => Any): this.type = {
    rightOpt match {
      case None =>
        rightOpt = Some(createSection(decorator :: decorators,
          blockDecorators))

        block

        leftOpt = rightOpt
        rightOpt = Some(createSection(decorators, blockDecorators))

      case Some(right) =>
        right.withDecorator(decorator)(block)
    }

    this
  }

  def withBlockDecorator(decorator: String => String)(block: => Any): this.type = {
    rightOpt match {
      case None =>
        rightOpt = Some(createSection(decorators,
          blockDecorators = decorator :: Nil))

        block

        leftOpt = rightOpt
        rightOpt = Some(createSection(decorators, blockDecorators))

      case Some(right) =>
        right.withBlockDecorator(decorator)(block)
    }

    this
  }

  protected[this] def createSection(
    decorators: List[String => String],
    blockDecorators: List[String => String]): T

  override def toString = {
    val sb = new StringBuilder

    // process decorators
    sb append buffer.map { str =>
      (decorators foldLeft str) { (a, b) => b(a) }
    }.mkString

    // left part
    sb append leftOpt.map(_.toString).getOrElse("")

    // right part
    sb append rightOpt.map(_.toString).getOrElse("")

    // process block decorators
    if (!sb.isEmpty)
      (blockDecorators foldLeft sb.toString) { (a, b) => b(a) }
    else
      ""
  }
}

trait RichTextSection { this: TextSection[_] =>

  private[this] var _defaultIndent: Int = 2

  def defaultIndent = _defaultIndent
  def defaultIndent_=(value: Int) = {
    require(value > 0)
    _defaultIndent = value
  }

  def <<(text: String): this.type = append(text)

  def >>(out: Writer) = out.append(toString)

  def append(texts: String*): this.type = {
    texts foreach append

    this
  }

  def indentBy(num: Int)(block: => Any): this.type = {
    withBlockDecorator(indentText(num)) {
      append(endl)
      block
    }

    this
  }

  def indent(block: => Any): this.type = {
    withBlockDecorator(indentText(defaultIndent)) {
      append(endl)
      block
    }

    this
  }

}

class Text(
  decorators: List[String => String] = List(),
  blockDecorators: List[String => String] = List())
  extends TextSection[Text](decorators, blockDecorators) with RichTextSection {

  protected[this] override def createSection(
    decorators: List[String => String],
    blockDecorators: List[String => String]): Text =

    new Text(decorators, blockDecorators)
}