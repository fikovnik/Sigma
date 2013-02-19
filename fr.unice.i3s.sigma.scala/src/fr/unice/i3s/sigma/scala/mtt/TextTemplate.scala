package fr.unice.i3s.sigma.scala.mtt

trait TextTemplateTest { this: TextTemplate ⇒
  override def init = {}
}

abstract class TextTemplate(stripWhitespace: Boolean = false) extends TextOutput {
  implicit class TextTemplateString(that: String) {
    def unary_! = out << that
    def quoted = Decorators.surroundText("\"")(that)
    def singleQuoted = Decorators.surroundText("'")(that)
  }

  protected val endl = TextSection.endl
  protected val out: Text = new Text(stripWhitespace)

  init

  protected def init = render
  protected def render: Unit

  override def toString = out.toString

}