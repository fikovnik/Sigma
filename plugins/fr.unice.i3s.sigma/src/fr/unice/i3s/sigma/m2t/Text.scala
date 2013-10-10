package fr.unice.i3s.sigma.m2t

import scala.collection.mutable.ListBuffer

object TextSection {

  sealed trait Command
  case class Append(str: String) extends Command
  case class DropRight(chars: Int) extends Command

}

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
  private val appendDecorator: Decorator,
  private val sectionDecorator: Decorator) {

  /** The command buffer */
  private val commands = new ListBuffer[TextSection.Command]
  
  /** The left section - processed after commands and before the right section */
  private var left: Option[TextSection[T]] = None
  /** The right section - processed after left section */
  private var right: Option[TextSection[T]] = None
  
  /** Pointer to the most right part - the current text section */
  private var curr: TextSection[T] = this

  protected[this] def createSection(
    appendDecorator: Decorator,
    sectionDecorator: Decorator): T

  protected[m2t] def deleteRight(chars: Int): this.type = {
	curr.commands += TextSection.DropRight(chars)	  
    this
  }

  def append(text: String): this.type = {
    curr.commands += TextSection.Append(text)
    this
  }

  def startSection(): T = startSection(Decorators.identity, Decorators.identity)

  def startSection(
    extraAppendDecorator: Decorator,
    extraSectionDecorator: Decorator): T = {

    // create a new section
    val section = createSection(
      (extraAppendDecorator andThen curr.appendDecorator),
      // do not copy the section decorator
      (extraSectionDecorator))

    // next section to continue with
    val next = createSection(curr.appendDecorator, Decorators.identity)

    curr.left = Some(section)
    curr.right = Some(next)
    curr = next
    section
  }

  def withSection(section: TextSection[T])(block: ⇒ Any): this.type = {

    // creates new section that will follow the given one in the tree
    // note: section decorator is not copied since it will be
    // automatically inherited
    val next = createSection(curr.appendDecorator, Decorators.identity)
    curr.right = Some(section)
    val prev = curr
    curr = section

    block

    prev.left = prev.right
    prev.right = Some(next)
    curr = next

    this
  }

  def withDecorator(decorator: Decorator)(block: ⇒ Unit): this.type = {
    val section = createSection((decorator andThen curr.appendDecorator), curr.sectionDecorator)
    withSection(section)(block)
    this
  }

  def withSectionDecorator(decorator: Decorator)(block: ⇒ Unit): this.type = {
    val section = createSection(curr.appendDecorator, decorator)
    withSection(section)(block)
    this
  }
  
  protected def processCommands(sb: StringBuilder) {
    for (cmd ← commands) cmd match {
      case TextSection.Append(str) ⇒ sb append appendDecorator(str)
      case TextSection.DropRight(chars) ⇒ sb delete (sb.size - chars, sb.size)
    }
  } 

  override def toString = {
    val sb = new StringBuilder

    processCommands(sb)

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
  with TextOutputting {

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
