package fr.unice.i3s.sigma.m2t

abstract class AbstractTextTemplate(
  stripWhitespace: Boolean,
  relaxedNewLines: Boolean) extends TextOutput {

  implicit class TextTemplateString(that: String) {
    def unary_! = out << that
    def quoted = Decorators.surroundText("\"")(that)
    def singleQuoted = Decorators.surroundText("'")(that)
  }

  /** New line string */
  final protected val endl = Text.endl
  
  /** Returns the primary text section for output */
  protected def out: Text

  /** Template entry point */
  protected def execute: Unit
  
}