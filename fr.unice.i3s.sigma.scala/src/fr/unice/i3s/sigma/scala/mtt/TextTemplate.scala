package fr.unice.i3s.sigma.scala.mtt

abstract class TextTemplate extends Text {

  protected def render: Unit

  override def toString = {
    render
    super.toString
  }

}