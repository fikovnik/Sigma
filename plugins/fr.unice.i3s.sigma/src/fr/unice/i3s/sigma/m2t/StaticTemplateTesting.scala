package fr.unice.i3s.sigma.m2t

trait StaticTemplateTesting { this: StaticTextTemplate ⇒
  override def toString: String = out.toString
}