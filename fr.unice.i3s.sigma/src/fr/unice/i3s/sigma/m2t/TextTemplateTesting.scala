package fr.unice.i3s.sigma.m2t

trait TextTemplateTesting { this: TextTemplate ⇒
  // TODO: better name
  def partial: String = out.toString
}