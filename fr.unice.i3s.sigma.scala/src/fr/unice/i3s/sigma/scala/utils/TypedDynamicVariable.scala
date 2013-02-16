package fr.unice.i3s.sigma.scala.utils

import scala.reflect.runtime.universe._

class TypedDynamicVariable[T: TypeTag](init: T) {
  private class Variable[V <: T](val value: V, val valueType: Type)

  private val tl = new InheritableThreadLocal[Variable[_ <: T]] {
    override def initialValue = new Variable(init, typeOf[T])
  }

  /** Retrieve the current value */
  def value[U <: T: TypeTag]: U = typeOf[U] match {
    case t if t =:= valueType ⇒ tl.get.value.asInstanceOf[U]
    case _ ⇒ throw new IllegalArgumentException(s"Current variable has type of: $valueType not ${typeOf[U]}")
  }

  /**
   * Change the currently bound value, discarding the old value.
   * Usually withValue() gives better semantics.
   */
  def set[U <: T: TypeTag](newVal: U) = tl set new Variable(newVal, typeOf[U])

  def valueType: Type = tl.get.valueType

  /**
   * Set the value of the variable while executing the specified
   * thunk.
   *
   * @param newVal The value to which to set the variable
   * @param thunk The code to evaluate under the new setting
   */
  def withValue[U <: T: TypeTag, S](newVal: U)(thunk: ⇒ S): S = {
    val oldVal = tl.get
    this set newVal

    try thunk
    finally tl set oldVal
  }

  override def toString: String = s"DynamicVariable($value, $valueType)"
}
