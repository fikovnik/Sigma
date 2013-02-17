package fr.unice.i3s.sigma.scala.utils.ecore

import org.eclipse.emf.ecore.EDataType;

trait EDataTypeScalaSupport {
  implicit class EDataTypeScalaSupport(obj: EDataType) {
    def serializable: Boolean = obj.isSerializable
    def serializable_=(value: Boolean): Unit = obj.setSerializable(value)
  }
}

object EDataTypeScalaSupport extends EDataTypeScalaSupport
