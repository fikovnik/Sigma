package fr.unice.i3s.sigma.support.ecore

import org.eclipse.emf.ecore.EDataType;

trait EDataTypeScalaSupport {
  implicit class EDataTypeScalaSupport(that: EDataType) {
    def serializable: Boolean = that.isSerializable
    def serializable_=(value: Boolean): Unit = that.setSerializable(value)
  }
}

object EDataTypeScalaSupport extends EDataTypeScalaSupport
