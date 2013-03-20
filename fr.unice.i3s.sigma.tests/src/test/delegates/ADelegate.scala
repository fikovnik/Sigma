package test.delegates

import scala.collection.JavaConversions._
import scala.collection.mutable.Buffer
import test.A
import test.B

/**
 * Delegate helper object for EMF EClass {@code A}.
 *
 * @see A
 */
object ADelegate {
  /**
   * Invocation delegate for the {@code op1()},
   * an operation defined in {@code A} class.
   *
   * @param self containing class
   * @returns a value that will subsequently returned by the original {@code op1} operation
   * @see A#op1()
   */
  def invokeOp1(self: A): String = self match {
    case b: B ⇒ BDelegate.invokeOp1(b)
    case a: A ⇒ "A"
  }
}
