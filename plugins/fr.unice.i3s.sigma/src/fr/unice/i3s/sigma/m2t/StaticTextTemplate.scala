package fr.unice.i3s.sigma.m2t

abstract class StaticTextTemplate(
  stripWhitespace: Boolean = true,
  relaxedNewLines: Boolean = true)

  extends AbstractTextTemplate(stripWhitespace, relaxedNewLines) with TextOutput {

  protected[m2t] val out: Text = new Text(stripWhitespace, relaxedNewLines)

  override lazy val toString = {
    execute
    out.toString
  }

}