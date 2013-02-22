package org.eclipse.emf.ecore.scala

import org.eclipse.emf.ecore.EDataType;

trait EDataTypeScalaSupport {
  implicit class EDataTypeScalaSupport(obj: EDataType) {
    def serializable: Boolean = obj.isSerializable
    def serializable_=(value: Boolean): Unit = obj.setSerializable(value)
  }
}

object EDataTypeScalaSupport extends EDataTypeScalaSupport
