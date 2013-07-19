package fr.unice.i3s.sigma.m2t

trait StaticTextTemplateTesting { this: StaticTextTemplate ⇒
  override def toString: String = out.toString
}