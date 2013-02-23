package org.eclipse.emf.ecore.scala

import org.eclipse.emf.ecore.EDataType;

trait EDataTypeScalaSupport {
  implicit class EDataTypeScalaSupport(that: EDataType) {
    def serializable: Boolean = that.isSerializable
    def serializable_=(value: Boolean): Unit = that.setSerializable(value)
  }
}

object EDataTypeScalaSupport extends EDataTypeScalaSupport
