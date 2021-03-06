package fr.unice.i3s.sigma.m2t

abstract class AbstractTextTemplate(
  stripWhitespace: Boolean,
  relaxedNewLines: Boolean) {

  implicit class TextTemplateString(that: String) {
    def unary_! = out append that
    def quoted = Decorators.surroundText("\"")(that)
    def singleQuoted = Decorators.surroundText("'")(that)
  }

  /** New line constant */
  final protected val endl = Text.endl

  /** Returns the primary text section for output */
  protected def out: Text

  /** Transformation entry point */
  protected def main: Unit

  /**
   * Starts a new section
   */
  protected def startSection() = out.startSection()

  protected def indentBy(num: Int)(block: ⇒ Unit): this.type = {
    out.indentBy(num)(block)
    this
  }

  def indent(block: ⇒ Unit): this.type = {
    out.indent(block)
    this
  }

  def curlyIndent(block: ⇒ Unit): this.type = {
    out.curlyIndent(block)
    this
  }

  def squareIndent(block: ⇒ Unit): this.type = {
    out.squareIndent(block)
    this
  }

  def parenIndent(block: ⇒ Unit): this.type = {
    out.parenIndent(block)
    this
  }

  def angleIndent(block: ⇒ Unit): this.type = {
    out.angleIndent(block)
    this
  }
  
}