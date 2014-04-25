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

  /** The type of the model element that is used as the entry point for the transformation */
  type Source >: Null

  /** A source for current transformation */
  protected def source: Source = base.value._1
  /** An output for current transformation */
  protected def out: Text = base.value._2

  // transformation context
  protected[m2t] val base = new DynamicVariable[(Source, Text)](null)

  /** 
   * Executes the transformation using `source` as the transformation source.
   * Returns a string that results from executing the `main` entry point with the given source as `source`. 
   * 
   * @param source the transformation source
   */
  def transform(source: Source): String = base.withValue(
    (source, new Text(stripWhitespace, relaxedNewLines))) {
      main
      out.toString
    }

  /**
   * Executes {{{block}}} with {{{section}}} as a current section
   */
  protected def withSection(section: Text)(block: ⇒ Any) {
    base.withValue((source, section))(block)
  }

}