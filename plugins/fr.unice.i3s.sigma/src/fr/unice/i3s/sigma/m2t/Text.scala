package fr.unice.i3s.sigma.m2t

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
  private val appendDecorator: Decorator,
  private val sectionDecorator: Decorator) {

  /** The section buffer */
  private val buffer = new StringBuilder

  /** The left section - processed after commands and before the right section */
  private var left: Option[TextSection[T]] = None
  /** The right section - processed after left section */
  private var right: Option[TextSection[T]] = None

  /** Pointer to the most right part - the current text section */
  private var curr: TextSection[T] = this

  protected[this] def createSection(
    appendDecorator: Decorator,
    sectionDecorator: Decorator): T

  protected[m2t] def currBufferSize = curr.buffer.size

  def dropRight(chars: Int): this.type = {
    val target = if (curr.buffer.size > 0) {
      curr
    } else if (right.isDefined) {
      // the current section does not contain any text => find the section right before it
      // find the last section
      def find(sec: TextSection[T]): TextSection[T] = sec.right match {
        case Some(r) if r == curr ⇒ sec
        case Some(r) ⇒ find(r)
        case None ⇒ sys.error("Invalid text section tree")
      }

      find(this)
    } else {
      throw new StringIndexOutOfBoundsException
    }

    target.buffer delete (target.buffer.size - chars, target.buffer.size)

    this
  }

  def append(text: String): this.type = {
    curr.buffer append curr.appendDecorator(text)
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

  override def toString: String = {
    // new string builder with the current node
    val sb = new StringBuilder(buffer.toString)

    left foreach (sb append _.toString)
    right foreach (sb append _.toString)

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
    if (relaxedNewLines && currBufferSize > 0) {
      dropRight(1)
    }

    append(begin)

    block

    if (!relaxedNewLines) {
      append(endl)
    }

    append(end)
    
    if (relaxedNewLines) {
      dropRight(1)
    }

    this
  }

  def quoted(block: ⇒ Unit): this.type = surroundWith("\"", "\"") {block}

  
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
