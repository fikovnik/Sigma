package fr.unice.i3s.sigma.m2t

import org.eclipse.emf.ecore.EObject
import scala.util.DynamicVariable

/**
 * Base class for M2T transformations
 */
abstract class TextTemplate(
  val stripWhitespace: Boolean = true,
  val relaxedNewLines: Boolean = true)

  extends AbstractTextTemplate(stripWhitespace, relaxedNewLines) {

  /** Type of the source object to be transformed */
  type M2TSource >: Null

  /** Returns the given source instance that is being transformed */
  protected def source: M2TSource = base.value._1
  protected[m2t] def out: Text = base.value._2

  // transformation context
  protected[m2t] val base = new DynamicVariable[(M2TSource, Text)](null)

  /**
   * Transformation entry point
   */
  def transform(source: M2TSource): String = {
    val res = base.withValue(
      (source, new Text(stripWhitespace, relaxedNewLines))) {
        execute
        out.toString
      }

    res
  }
  
  /**
   * Executes {{{block}}} with {{{section}}} as a current section
   */
  protected def withSection(section: Text)(block: ⇒ Any) {
    base.withValue((source, section))(block)
  }

}