package test.delegates

import scala.collection.JavaConversions._
import scala.collection.mutable.Buffer
import fr.unice.i3s.sigma.scala.utils._
import test.A

/**
 * Delegate helper object for EMF EClass {@code B}.
 *
 * @see B
 */
object BDelegate {
  /**
   * Invocation delegate for the {@code op1()},
   * an operation defined in {@code A} class.
   *
   * @param self containing class
   * @returns a value that will subsequently returned by the original {@code op1} operation
   * @see A#op1()
   */
  def invokeOp1(self: A): String = {
    "B"
  }
}
