package fr.unice.i3s.sigma.m2t

import org.eclipse.emf.ecore.EObject
import scala.util.DynamicVariable

/**
 * Base class for M2T transformations
 */
abstract class M2T(
  val stripWhitespace: Boolean = true,
  val relaxedNewLines: Boolean = true) {

  implicit class TextTemplateString(that: String) {
    def unary_! = out << that
    def quoted = Decorators.surroundText("\"")(that)
    def singleQuoted = Decorators.surroundText("'")(that)
  }

  /** Type of the source object to be transformed */
  type M2TSource >: Null

  /** New line string */
  final protected val endl = TextSection.endl
  /** Returns the given source instance that is being transformed */
  protected def source: M2TSource = base.value._1
  /** Returns the primary text section for output */
  protected def out: Text = base.value._2

  // transformation context
  protected[m2t] val base = new DynamicVariable[(M2TSource, Text)](null)

  /**
   * Main template
   */
  protected def transform: Unit

  /**
   * Transformation entry point
   */
  def transform(source: M2TSource): String = {
    val res = base.withValue(
      (source, new Text(stripWhitespace, relaxedNewLines))) {
        transform
        out.toString
      }

    res
  }

  /**
   * Executes {{{block}}} with {{{section}}} as a current section
   */  
  def withSection(section: Text)(block: ⇒ Any) {
    base.withValue((source, section))(block)
  }

  /**
   * Starts a new section
   */
  protected def startSection = out.startSection

}