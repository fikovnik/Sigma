package fr.unice.i3s.sigma.m2t

import scala.util.DynamicVariable

/**
 * Trait providing convenient methods for testing M2T transformations.
 */
trait TextTemplateTesting { this: TextTemplate ⇒

  override def source: Source = base.value._1
  /** Sets new transformation context to be the given source and a new text */
  def source_=(value: Source) = base.value = (value, new Text(stripWhitespace, relaxedNewLines))

  /** Executes block with a new transformation context using given source as the transformation source */
  def withSource(value: Source)(block: ⇒ Unit): Unit = {
    base.withValue(value, new Text(stripWhitespace, relaxedNewLines)) {
      block
    }
  }

  /** Returns the current transformation result */
  override def toString = out.toString
}