package fr.unice.i3s.sigma.scala.mtt

trait TextTemplateTest { this: TextTemplate ⇒
  override def init = {}
}

trait TextTemplate extends TextOutput with DelayedInit {
  implicit class TextTemplateString(that: String) {
    def unary_! = out << that
    def quoted = Decorators.surroundText("\"")(that)
    def singleQuoted = Decorators.surroundText("'")(that)
  }

  protected val endl = TextSection.endl
  protected val out: Text = new Text(stripWhitespace)

  def delayedInit(body: ⇒ Unit) = {
    body
    init
  }

  protected def init = render
  protected def render: Unit
  protected def stripWhitespace: Boolean = false

  override def toString = out.toString

}