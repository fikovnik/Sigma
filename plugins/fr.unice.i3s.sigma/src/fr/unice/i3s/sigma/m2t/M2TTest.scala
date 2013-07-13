package fr.unice.i3s.sigma.m2t

import scala.util.DynamicVariable

/**
 * Trait providing convenient methods for testing M2T transformations.
 */
trait M2TTest { this: M2T => 

  /** Sets transformation source and executes block */
  def withSource(source: M2TSource)(block: => Unit): Unit = {
    base.withValue(source, new Text(stripWhitespace, relaxedNewLines)) {
      block
    }
  }
    
  /** Returns the current transformation result */
  override def toString = out.toString 
}