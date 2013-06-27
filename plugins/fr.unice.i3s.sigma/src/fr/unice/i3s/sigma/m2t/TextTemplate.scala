package fr.unice.i3s.sigma.m2t

abstract class TextTemplate(
  stripWhitespace: Boolean = true,
  relaxedNewLines: Boolean = true) extends TextOutput {

  implicit class TextTemplateString(that: String) {
    def unary_! = out << that
    def quoted = Decorators.surroundText("\"")(that)
    def singleQuoted = Decorators.surroundText("'")(that)
  }

  protected val endl = TextSection.endl
  protected val out: Text = new Text(stripWhitespace, relaxedNewLines)
  //  protected var rendered: Boolean = false

  protected def render: Unit

  override lazy val toString = {
    //    if (rendered) {
    //      render
    //    }
    render
    out.toString
  }

}