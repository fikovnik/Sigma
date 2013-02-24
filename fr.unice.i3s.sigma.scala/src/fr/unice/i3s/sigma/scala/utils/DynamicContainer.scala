package fr.unice.i3s.sigma.scala.utils

import scala.reflect.runtime.universe._
import scala.collection.mutable.Buffer

class DynamicContainer {
  private[this] var current: (Buffer[_], Type) = _

  def +=[U: TypeTag](elem: U) = typeOf[U] match {
    case t if t <:< valueType ⇒ current._1.asInstanceOf[Buffer[U]] += elem
    case _ ⇒ throw new IllegalArgumentException(s"Current variable has type of: $valueType not ${typeOf[U]}")

  }

  def valueType: Type = current._2
  def isSet: Boolean = current != null
  def isCompatible[U: TypeTag]: Boolean = isSet && (typeOf[U] match {
    case t if t <:< valueType ⇒ true
    case _ ⇒ false
  })

  def withValue[U: TypeTag](newVal: Buffer[U])(thunk: ⇒ Any): Unit = {
    require(newVal != null)

    val oldVal = current
    current = (newVal, typeOf[U])

    try thunk
    finally current = oldVal
  }

  override def toString: String = s"DynamicContainer($valueType)"
}
