package fr.unice.i3s.sigma.m2t

import org.eclipse.emf.ecore.EObject
import scala.util.DynamicVariable

abstract class M2T(
  stripWhitespace: Boolean = true,
  relaxedNewLines: Boolean = true) {

  implicit class TextTemplateString(that: String) {
    def unary_! = out << that
    def quoted = Decorators.surroundText("\"")(that)
    def singleQuoted = Decorators.surroundText("'")(that)
  }

  // TODO: rename to Self and use the SelfVariable trait
  type Root >: Null <: EObject

  final protected val endl = TextSection.endl
  
  private val base = new DynamicVariable[(Root, Text)](null)
  protected def root: Root = base.value._1
  protected def out: Text = base.value._2

  /**
   * Main template
   */
  // TODO: rename to main
  def render: Unit

  def transform(newRoot: Root): String = {
    val res = base.withValue(
      (newRoot, new Text(stripWhitespace, relaxedNewLines))) {
        render
        out.toString
      }
    
    res
  }

}